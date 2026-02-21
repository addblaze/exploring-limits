package io.blaze.h2jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.blaze.h2jpa.entity.SampleEntity;

@Repository
public interface H2Repository extends JpaRepository<SampleEntity, Long> {

}
