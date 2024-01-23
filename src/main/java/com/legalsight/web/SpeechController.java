package com.legalsight.web;

import com.legalsight.web.dto.Speech;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/speeches")
public interface SpeechController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Speech> create(@RequestBody final Speech request);

    @GetMapping("/{id}")
    ResponseEntity<Speech> get(@PathVariable("id") final String id);

    @PutMapping("/{id}")
    ResponseEntity<Speech> update(@PathVariable("id") final String id, @RequestBody final Speech request);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") final String id);

    @GetMapping
    ResponseEntity<Page<Speech>> list(
            Speech filter,
            @PageableDefault(size = 10, sort = {"createTime"}, direction = Sort.Direction.DESC) Pageable pageable
    );
}
