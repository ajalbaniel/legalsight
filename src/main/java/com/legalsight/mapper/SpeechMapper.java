package com.legalsight.mapper;

import com.legalsight.entity.SpeechEntity;
import com.legalsight.web.dto.SpeechDto;
import org.mapstruct.Mapper;

@Mapper
public interface SpeechMapper {

    SpeechDto toDomain(SpeechEntity speechEntity);

    SpeechEntity toEntity(SpeechDto speechDto);

}
