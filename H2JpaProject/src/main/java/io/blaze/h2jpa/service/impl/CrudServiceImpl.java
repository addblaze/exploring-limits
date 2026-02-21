package io.blaze.h2jpa.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.blaze.h2jpa.dto.SampleDTO;
import io.blaze.h2jpa.entity.SampleEntity;
import io.blaze.h2jpa.exceptions.EntityNotFound;
import io.blaze.h2jpa.mapper.SampleMapper;
import io.blaze.h2jpa.repository.H2Repository;
import io.blaze.h2jpa.service.CrudService;


@Service
public class CrudServiceImpl implements CrudService {
	
	private H2Repository h2Repository;
		
	private SampleMapper mapper;
	
	public CrudServiceImpl(SampleMapper mapper, H2Repository h2Repository) {
		this.mapper = mapper;
		this.h2Repository = h2Repository;
	}

	@Override
	public SampleDTO create(SampleDTO dto) {
		if(null != dto) {
			SampleEntity entity = mapper.mapToEntity(dto);
			entity = h2Repository.save(entity);
			dto = mapper.mapToDTO(entity);
		}
		return dto;
	}

	@Override
	public List<SampleDTO> retrieveAll() {
		return h2Repository.findAll()
				.stream()
				.map(e -> mapper.mapToDTO(e))
				.collect(Collectors.toList());
	}

	@Override
	public SampleDTO retrieve(Long id) {
		return h2Repository.findById(id)
				.map(e -> mapper.mapToDTO(e))
				.orElseThrow(() -> new EntityNotFound("ID Not Found!"));
	}

}
