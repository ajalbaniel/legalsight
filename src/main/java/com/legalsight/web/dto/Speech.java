package com.legalsight.web.dto;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class Speech {
    private String id;
    private String content;
    private Author author;
    private Instant dateGiven;
    private List<String> subjectAreas;
}
