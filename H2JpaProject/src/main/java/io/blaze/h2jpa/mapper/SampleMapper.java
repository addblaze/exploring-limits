package io.blaze.h2jpa.mapper;

import org.mapstruct.Mapper;

import io.blaze.h2jpa.dto.SampleDTO;
import io.blaze.h2jpa.entity.SampleEntity;

@Mapper(componentModel = "spring")
public interface SampleMapper {

	SampleDTO mapToDTO(SampleEntity entity);
	
	SampleEntity mapToEntity(SampleDTO dto);
}