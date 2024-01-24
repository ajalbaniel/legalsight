package com.legalsight.web;

import com.legalsight.service.SpeechService;
import com.legalsight.web.dto.Speech;
import com.legalsight.web.dto.SpeechFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class SpeechControllerImplTest {

    @Mock
    private SpeechService speechService;

    @InjectMocks
    private SpeechControllerImpl speechController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateSpeech() {
        Speech speech = new Speech();
        when(speechService.create(any(Speech.class))).thenReturn(speech);

        ResponseEntity<Speech> response = speechController.create(speech);
        assertEquals(response.getBody(), speech);
    }

    @Test
    void testGetSpeech() {
        Speech speech = new Speech();
        when(speechService.get(any(String.class))).thenReturn(speech);

        ResponseEntity<Speech> response = speechController.get("1");
        assertEquals(response.getBody(), speech);
    }

    @Test
    void testUpdateSpeech() {
        Speech speech = new Speech();
        when(speechService.update(any(Speech.class))).thenReturn(speech);

        ResponseEntity<Speech> response = speechController.update("1", speech);
        assertEquals(response.getBody(), speech);
    }

    @Test
    void testListSpeeches() {
        Speech speech = new Speech();
        List<Speech> speechList = List.of(speech);
        Page<Speech> speechPage = new PageImpl<>(speechList);

        when(speechService.list(any(SpeechFilter.class), any(Pageable.class))).thenReturn(speechPage);

        ResponseEntity<Page<Speech>> response = speechController.list(new SpeechFilter(), Pageable.unpaged());
        assertEquals(response.getBody(), speechPage);
    }
}