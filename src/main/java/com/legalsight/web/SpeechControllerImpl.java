package com.legalsight.web;

import com.legalsight.service.SpeechService;
import com.legalsight.web.dto.Speech;
import com.legalsight.web.dto.SpeechFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SpeechControllerImpl implements SpeechController {

    private final SpeechService service;

    @Override
    public ResponseEntity<Speech> create(Speech request) {
        return ResponseEntity.ok(service.create(request));
    }

    @Override
    public ResponseEntity<Speech> get(String id) {
        return ResponseEntity.ok(service.get(id));
    }

    @Override
    public ResponseEntity<Speech> update(String id, Speech request) {
        request.setId(id);
        return ResponseEntity.ok(service.update(request));
    }

    @Override
    public void delete(String id) {
        service.delete(id);
    }

    @Override
    public ResponseEntity<Page<Speech>> list(SpeechFilter filter, Pageable pageable) {
        return ResponseEntity.ok(service.list(filter, pageable));
    }
}
