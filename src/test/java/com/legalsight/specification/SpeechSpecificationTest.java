package com.legalsight.specification;

import com.legalsight.entity.SpeechEntity;
import com.legalsight.web.dto.SpeechFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class SpeechSpecificationTest {

    @Test
    void toPredicateNoFilterReturnsEmptyPredicate() {
        SpeechFilter filter = new SpeechFilter();
        SpeechSpecification specification = new SpeechSpecification(filter);

        Root<SpeechEntity> root = mock(Root.class);
        CriteriaQuery<?> query = mock(CriteriaQuery.class);
        CriteriaBuilder criteriaBuilder = mock(CriteriaBuilder.class);

        Predicate predicate = specification.toPredicate(root, query, criteriaBuilder);
        assertThat(predicate).isNull();
    }
}
