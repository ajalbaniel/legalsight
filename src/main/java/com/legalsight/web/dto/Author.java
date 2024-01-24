package com.legalsight.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Author {
    private String id;
    @NotBlank
    private String name;
}
