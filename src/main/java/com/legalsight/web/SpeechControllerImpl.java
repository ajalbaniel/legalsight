package com.legalsight.web;

import com.legalsight.web.dto.Speech;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SpeechControllerImpl implements SpeechController {
    @Override
    public ResponseEntity<Speech> create(RequestEntity<Speech> request) {
        return null;
    }

    @Override
    public ResponseEntity<Speech> find(String id) {
        return null;
    }

    @Override
    public ResponseEntity<Speech> update(String id, RequestEntity<Speech> request) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public ResponseEntity<Page<Speech>> list(Pageable pageable) {
        return null;
    }
}
