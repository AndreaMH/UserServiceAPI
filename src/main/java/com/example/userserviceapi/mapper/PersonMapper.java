package com.example.userserviceapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

import com.example.userserviceapi.entities.PersonEntity;
import com.example.userserviceapi.web.api.model.Person;



@Mapper(componentModel = "spring")
public interface PersonMapper {

	@Mappings({})
	Person mapperFromPersonEntityToPerson(PersonEntity entity);

	@Mappings({})
	PersonEntity mapperFromPersonToPersonEntity(Person person);

}
