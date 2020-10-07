package com.example.userserviceapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.userserviceapi.entities.PersonEntity;
import com.example.userserviceapi.exceptions.InvalidAgeException;
import com.example.userserviceapi.mapper.PersonMapper;
import com.example.userserviceapi.repository.PersonRepository;
import com.example.userserviceapi.service.PersonService;
import com.example.userserviceapi.web.api.model.People;
import com.example.userserviceapi.web.api.model.Person;
import com.example.userserviceapi.web.api.model.PersonResponse;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;

	private PersonMapper personMapper;

	public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
		this.personRepository = personRepository;
		this.personMapper = personMapper;
	}
	
	public String greet() {
		return "Hello World";
	}

	@Override
	public PersonResponse createPerson(Person user) throws InvalidAgeException {
		PersonResponse personResponse = new PersonResponse();
		personResponse.setResult("Persona creada");

		PersonEntity personEntity = new PersonEntity();

		String nombre = user.getName();
		personEntity.setName(nombre);

		String dir = user.getAddress();
		personEntity.setAddress(dir);

		int edad = user.getAge();

		if (edad < 18) {
			throw new InvalidAgeException(400);

		} else {
			personEntity.setAge(edad);
			personRepository.save(personEntity);
		}

		return personResponse;
	}

	@Override
	public People findAllPeople() {
		People people = new People();
		List<Person> peopleList = new ArrayList<Person>();

		try {
			List<PersonEntity> listaPersonas = (List<PersonEntity>) personRepository.findAll();

			peopleList = listaPersonas.stream()
					.map(personEntity -> personMapper.mapperFromPersonEntityToPerson(personEntity))
					.collect(Collectors.toList());

			people.setResultCode("0"); // OK

		} catch (Exception e) {
			people.setResultCode("1"); // KO
		}

		people.setPeopleList(peopleList);

		return people;
	}

	@Override
	public Person findPersonByName(String name) {
		Person person;
		List<Person> personList;

		List<PersonEntity> personRepoList = personRepository.findByName(name);

		personList = personRepoList.stream()
				.map(personEntity -> personMapper.mapperFromPersonEntityToPerson(personEntity))
				.collect(Collectors.toList());

		person = personList.get(0);

		return person;
	}

	@Override
	public Void updatePerson(Person body, String name) {
		List<PersonEntity> personRepoList = personRepository.findByName(name);

		long id = personRepoList.get(0).getId();

		List<PersonEntity> newList = personRepoList.stream()
				.map(personEnt -> personMapper.mapperFromPersonToPersonEntity(body)).collect(Collectors.toList());

		newList.get(0).setId(id);
		personRepository.save(newList.get(0));

		return null;
	}

	@Override
	public PersonResponse deletePersonByName(String name) {
		PersonResponse personResponse = new PersonResponse();
		personResponse.setResult("Persona borrada");

		List<PersonEntity> listaPersona = personRepository.findByName(name);

		listaPersona.stream().filter(n -> n.getName().equals(name)).forEach(n -> personRepository.delete(n));

		return personResponse;
	}

}
