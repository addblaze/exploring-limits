package io.blaze.h2jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.blaze.h2jpa.dto.SampleDTO;
import io.blaze.h2jpa.service.CrudService;

@RestController
@RequestMapping("/CrudOps")
public class CrudController {
	
	@Autowired
	CrudService crudService;
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleDTO> create(@RequestBody SampleDTO dto) {	
		if(null != dto.dataKey()) {
			dto = crudService.create(dto);
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.badRequest().body(dto);
		}
	}
	
	@GetMapping(value = "/retrieveAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SampleDTO>> retrieveAll() {
		return ResponseEntity.ok(crudService.retrieveAll());
	}
	
	@GetMapping(value = "/retrieve/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SampleDTO> retrieve(@PathVariable Long id) {
		return ResponseEntity.ok(crudService.retrieve(id));
	}
}
