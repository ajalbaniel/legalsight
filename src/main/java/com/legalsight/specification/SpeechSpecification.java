package com.legalsight.specification;

import com.legalsight.entity.AuthorEmbeddable_;
import com.legalsight.entity.SpeechEntity;
import com.legalsight.entity.SpeechEntity_;
import com.legalsight.web.dto.SpeechFilter;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class SpeechSpecification implements Specification<SpeechEntity> {
    private static final LocalDate FAR_PAST = LocalDate.of(1600, 1, 1);
    private static final LocalDate FAR_FUTURE = LocalDate.of(2100, 12, 31);

    private final transient SpeechFilter filter;
    @Getter
    private final List<Predicate> predicates = new ArrayList<>();

    @Override
    public Predicate toPredicate(Root<SpeechEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        addAuthorPredicate(root, criteriaBuilder);
        addDateRangePredicate(root, criteriaBuilder);
        addSubjectAreasPredicate(root);
        addContentPredicate(root, criteriaBuilder);

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void addContentPredicate(Root<SpeechEntity> root, CriteriaBuilder builder) {
        if (StringUtils.isNotBlank(filter.getContentSnippet())) {
            String searchWordPattern = "%" + filter.getContentSnippet().toLowerCase() + "%";
            predicates.add(builder.like(builder.lower(root.get("content")), searchWordPattern));
        }
    }

    private void addDateRangePredicate(Root<SpeechEntity> root, CriteriaBuilder builder) {
        // hibernate could not support LocalDate.MIN and LocalDate.MAX hence resorting to this work-around
        LocalDate fromDate = Optional.ofNullable(filter.getDateGivenFrom()).orElse(FAR_PAST);
        LocalDate toDate = Optional.ofNullable(filter.getDateGivenTo()).orElse(FAR_FUTURE);

        if (fromDate.isAfter(FAR_PAST) || toDate.isBefore(FAR_FUTURE)) {
            predicates.add(builder.between(root.get(SpeechEntity_.DATE_GIVEN), fromDate, toDate));
        }
    }

    private void addAuthorPredicate(Root<SpeechEntity> root, CriteriaBuilder builder) {
        if (StringUtils.isNotBlank(filter.getAuthor())) {
            predicates.add(
                    builder.equal(
                            root.get(SpeechEntity_.AUTHOR).get(AuthorEmbeddable_.NAME),
                            filter.getAuthor()
                    )
            );
        }
    }

    private void addSubjectAreasPredicate(Root<SpeechEntity> root) {
        if (filter.getSubjectAreas() != null) {
            Join<SpeechEntity, String> joinSubjectAreas = root.join(SpeechEntity_.SUBJECT_AREAS);
            predicates.add(joinSubjectAreas.in(filter.getSubjectAreas()));
        }
    }
}
