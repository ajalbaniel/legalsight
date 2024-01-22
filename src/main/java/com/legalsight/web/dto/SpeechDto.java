package com.legalsight.web.dto;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class SpeechDto {
    private String id;
    private String content;
    private AuthorDto author;
    private Instant dateGiven;
    private List<String> subjectAreas;
}
