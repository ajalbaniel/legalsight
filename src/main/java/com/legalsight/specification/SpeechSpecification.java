package com.legalsight.specification;

import com.legalsight.entity.BaseEntity_;
import com.legalsight.entity.SpeechEntity;
import com.legalsight.entity.SpeechEntity_;
import com.legalsight.web.dto.Speech;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SpeechSpecification implements Specification<SpeechEntity> {

    private final transient Speech filter;
    @Getter
    private final List<Predicate> predicates = new ArrayList<>();

    @Override
    public Predicate toPredicate(Root<SpeechEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        addAuthorPredicate(root, criteriaBuilder);
        addSubjectAreasPredicate(root);

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void addAuthorPredicate(Root<SpeechEntity> root, CriteriaBuilder builder) {
        if (filter.getAuthor() != null &&
                StringUtils.isNotBlank(filter.getAuthor().getName())) {
            predicates.add(
                    builder.equal(
                            root.get(SpeechEntity_.AUTHOR).get(BaseEntity_.ID),
                            filter.getAuthor().getName()
                    )
            );
        }
    }

    private void addSubjectAreasPredicate(Root<SpeechEntity> root) {
        if (filter.getSubjectAreas() != null && !filter.getSubjectAreas().isEmpty()) {
            Join<SpeechEntity, String> joinTags = root.join(SpeechEntity_.SUBJECT_AREAS);
            predicates.add(joinTags.in(filter.getSubjectAreas()));
        }
    }
}
