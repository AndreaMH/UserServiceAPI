package com.example.userserviceapi.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.userserviceapi.entities.PersonTable;

@Repository
public interface PersonRepository extends CrudRepository<PersonTable, Long> {

	@Query("select * from person where name=:name")
	List<PersonTable> findByName(@Param("name") String name);
}
