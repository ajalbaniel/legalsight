package com.legalsight.mapper;

import com.legalsight.entity.SpeechEntity;
import com.legalsight.web.dto.Speech;
import org.mapstruct.Mapper;

@Mapper
public interface SpeechMapper {

    Speech toDomain(SpeechEntity speechEntity);

    SpeechEntity toEntity(Speech speech);

}
