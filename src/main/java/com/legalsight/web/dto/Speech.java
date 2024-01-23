package com.legalsight.web.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Speech {
    private String id;
    private String content;
    private Author author;
    private LocalDate dateGiven;
    private List<String> subjectAreas;
}
