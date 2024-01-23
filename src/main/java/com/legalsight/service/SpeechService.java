package com.legalsight.service;

import com.legalsight.web.dto.Speech;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SpeechService {

    Speech get(String id);

    Speech create(Speech speech);

    Speech update(Speech speech);

    void delete(String id);

    Page<Speech> list(Speech filter, Pageable pageable);

}
