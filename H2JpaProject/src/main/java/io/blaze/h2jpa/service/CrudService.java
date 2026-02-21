package io.blaze.h2jpa.service;

import java.util.List;

import io.blaze.h2jpa.dto.SampleDTO;

public interface CrudService {
	
	SampleDTO create(SampleDTO dto);
	
	List<SampleDTO> retrieveAll();
	
	SampleDTO retrieve(Long id);

}
