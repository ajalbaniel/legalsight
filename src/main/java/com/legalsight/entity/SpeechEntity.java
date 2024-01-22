package com.legalsight.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "speech")
public class SpeechEntity extends BaseEntity {
    @Column(name = "content")
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
