package com.legalsight.service;

import com.legalsight.entity.SpeechEntity;
import com.legalsight.mapper.SpeechMapper;
import com.legalsight.repository.SpeechRepository;
import com.legalsight.specification.SpeechSpecification;
import com.legalsight.web.dto.Speech;
import com.legalsight.web.exception.SpeechNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class SpeechServiceImpl implements SpeechService {

    private final SpeechRepository repository;

    private final SpeechMapper mapper;

    @Override
    public Speech get(String id) {
        return mapper.toDomain(findByIdOrThrow(id));
    }

    private SpeechEntity findByIdOrThrow(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new SpeechNotFoundException(
                        String.format("Speech record with id `%s` not found", id)
                ));
    }

    @Transactional
    @Override
    public Speech create(Speech speech) {
        speech.setId(null);
        return mapper.toDomain(repository.save(mapper.toEntity(speech)));
    }

    @Transactional
    @Override
    public Speech update(Speech speech) {
        SpeechEntity existingRecord = findByIdOrThrow(speech.getId());
        return mapper.toDomain(repository.save(mapper.update(speech, existingRecord)));
    }

    @Transactional
    @Override
    public void delete(String id) {
        SpeechEntity existingRecord = findByIdOrThrow(id);
        existingRecord.setDeleted(true);
        repository.save(existingRecord);
    }

    @Override
    public Page<Speech> list(Speech filter, Pageable pageable) {
        SpeechSpecification specification = new SpeechSpecification(filter);
        return repository.findAll(specification, pageable).map(mapper::toSearchResult);
    }
}
