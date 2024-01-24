package com.legalsight.web.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SpeechFilter {
    private String contentSnippet;
    private String author;
    private LocalDate dateGivenFrom;
    private LocalDate dateGivenTo;
    private List<String> subjectAreas;
}
