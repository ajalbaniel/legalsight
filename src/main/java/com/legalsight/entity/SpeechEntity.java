package com.legalsight.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@Entity
@Table(name = "speech")
@Where(clause = "deleted = false")
public class SpeechEntity extends LegalSightEntity {
    @Column(name = "content", length = Integer.MAX_VALUE)
    private String content;
    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "author_id"))
    @AttributeOverride(name = "name", column = @Column(name = "author_name"))
    private AuthorEmbeddable author;
    @Column(name = "date_given")
    private LocalDate dateGiven;
    @ElementCollection
    @CollectionTable(
            name = "speech_subject_area",
            joinColumns = @JoinColumn(name = "speech_id")
    )
    @Column(name = "subject_area")
    private List<String> subjectAreas;
}
