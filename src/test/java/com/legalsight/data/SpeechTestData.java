package com.legalsight.data;

import com.legalsight.entity.AuthorEmbeddable;
import com.legalsight.entity.SpeechEntity;
import com.legalsight.web.dto.Author;
import com.legalsight.web.dto.Speech;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.NONE)
public final class SpeechTestData {
    public static Speech dummySpeech() {
        Speech dto = new Speech();
        dto.setId(UUID.randomUUID().toString());
        Author author = new Author();
        author.setName("AJ Albaniel");
        dto.setAuthor(author);
        dto.setContent("The quick brown fox jumped over the lazy dog.");
        dto.setSubjectAreas(List.of("fox", "dog"));
        dto.setDateGiven(LocalDate.of(1991, 10, 18));

        return dto;
    }

    public static SpeechEntity dummySpeechEntity() {
        SpeechEntity entity = new SpeechEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setDeleted(false);
        AuthorEmbeddable authorEmbeddable = new AuthorEmbeddable();
        authorEmbeddable.setName("AJ Albaniel");
        entity.setAuthor(authorEmbeddable);
        entity.setContent("The quick brown fox jumped over the lazy dog.");
        entity.setSubjectAreas(List.of("fox", "dog"));
        entity.setDateGiven(LocalDate.of(1991, 10, 18));

        return entity;
    }

}
