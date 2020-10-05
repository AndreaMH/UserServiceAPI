package com.example.userserviceapi.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.userserviceapi.entities.PersonEntity;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

	@Query("select * from person where name=:name")
	List<PersonEntity> findByName(@Param("name") String name);
}
