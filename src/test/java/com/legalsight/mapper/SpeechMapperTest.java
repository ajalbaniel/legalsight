package com.legalsight.mapper;

import com.legalsight.entity.SpeechEntity;
import com.legalsight.web.dto.Speech;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Spy;

import static com.legalsight.data.SpeechTestData.dummySpeech;
import static com.legalsight.data.SpeechTestData.dummySpeechEntity;
import static org.assertj.core.api.Assertions.assertThat;

class SpeechMapperTest {

    @Spy
    private SpeechMapper speechMapper = Mappers.getMapper(SpeechMapper.class);

    @Test
    void testToDomain() {
        SpeechEntity entity = dummySpeechEntity();

        Speech domain = speechMapper.toDomain(entity);

        assertThat(domain).isNotNull();
        assertThat(domain)
                .usingRecursiveComparison()
                .isEqualTo(entity);
    }

    @Test
    void testToEntity() {
        Speech domain = dummySpeech();

        SpeechEntity entity = speechMapper.toEntity(domain);

        assertThat(entity).isNotNull();
        assertThat(entity)
                .usingRecursiveComparison()
                .ignoringFields("version", "modifyTime", "createTime", "deleted")
                .isEqualTo(domain);
    }

}
