package com.legalsight.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Speech {
    private String id;
    @NotBlank
    private String content;
    @NotNull
    @Valid
    private Author author;
    @NotNull
    private LocalDate dateGiven;
    private List<String> subjectAreas;
}
