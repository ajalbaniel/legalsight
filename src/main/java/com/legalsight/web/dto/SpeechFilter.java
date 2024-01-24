package com.legalsight.web.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SpeechFilter {
    private String content;
    private String author;
    private LocalDate dateGivenRange;
    private List<String> subjectAreas;
}
