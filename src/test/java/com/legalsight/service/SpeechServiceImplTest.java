package com.legalsight.service;

import com.legalsight.entity.SpeechEntity;
import com.legalsight.mapper.SpeechMapper;
import com.legalsight.repository.SpeechRepository;
import com.legalsight.web.dto.Speech;
import com.legalsight.web.exception.SpeechNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class SpeechServiceImplTest {

    @Mock
    private SpeechRepository speechRepository;

    @Mock
    private SpeechMapper speechMapper;

    @InjectMocks
    private SpeechServiceImpl speechService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenGetSpeech_thenSuccess() {
        SpeechEntity speechEntity = new SpeechEntity();
        Speech speech = new Speech();
        when(speechRepository.findById(any(String.class))).thenReturn(Optional.of(speechEntity));
        when(speechMapper.toDomain(any(SpeechEntity.class))).thenReturn(speech);

        Speech result = speechService.get("1");
        assertNotNull(result);
    }

    @Test
    void whenGetSpeechNotFound_thenThrowException() {
        when(speechRepository.findById(any(String.class))).thenReturn(Optional.empty());

        assertThrows(SpeechNotFoundException.class, () -> speechService.get("1"));
    }

}
