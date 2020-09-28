package com.example.userserviceapi.service;

import com.example.userserviceapi.web.api.model.People;
import com.example.userserviceapi.web.api.model.Person;
import com.example.userserviceapi.web.api.model.PersonResponse;

public interface PersonService {

	PersonResponse createPerson(Person user);

	People findAllPeople();

	Person findPersonByName(String name);

	Void updatePerson(Person body);

	PersonResponse deletePersonByName();

}
