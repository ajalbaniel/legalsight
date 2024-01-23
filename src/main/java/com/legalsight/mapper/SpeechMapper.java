package com.legalsight.mapper;

import com.legalsight.entity.SpeechEntity;
import com.legalsight.web.dto.Speech;
import io.micrometer.common.util.StringUtils;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface SpeechMapper {

    int CONTENT_PREVIEW_CHAR_COUNT = 50;
    String ELLIPSIS = "…";

    Speech toDomain(SpeechEntity speechEntity);

    SpeechEntity toEntity(Speech speech);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    SpeechEntity update(Speech domain, @MappingTarget SpeechEntity entity);

    @Mapping(target = "content", source = "content", qualifiedByName = "toContentPreview")
    Speech toSearchResult(SpeechEntity speechEntity);

    @Named("toContentPreview")
    default String toContentPreview(String content) {
        return StringUtils.truncate(content, CONTENT_PREVIEW_CHAR_COUNT, ELLIPSIS);
    }
}
