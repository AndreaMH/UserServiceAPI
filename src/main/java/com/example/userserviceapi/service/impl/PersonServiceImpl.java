package com.example.userserviceapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.userserviceapi.entities.PersonTable;
import com.example.userserviceapi.repository.PersonRepository;
import com.example.userserviceapi.service.PersonService;
import com.example.userserviceapi.web.api.model.People;
import com.example.userserviceapi.web.api.model.Person;
import com.example.userserviceapi.web.api.model.PersonResponse;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;

	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public PersonResponse createPerson(Person user) {
		PersonResponse personResponse = new PersonResponse();
		personResponse.setResult("Persona creada");

		PersonTable personTable = new PersonTable();

		String nombre = user.getName();
		personTable.setName(nombre);

		String dir = user.getAddress();
		personTable.setAddress(dir);

		personRepository.save(personTable);

		return personResponse;
	}

	@Override
	public People findAllPeople() {
		People people = new People();
		List<Person> peopleList = new ArrayList<Person>();

		try {
			List<PersonTable> listaPersonas = (List<PersonTable>) personRepository.findAll();

			for (PersonTable personTable : listaPersonas) {
				Person person = new Person();
				person.setName(personTable.getName());
				person.setAddress(personTable.getAddress());

				peopleList.add(person);
			}

			people.setResultCode("0");

		} catch (Exception e) {
			people.setResultCode("1");
		}

		people.setPeopleList(peopleList);

		return people;
	}

	@Override
	public Person findPersonByName(String name) {
		Person personApi = new Person();

		List<PersonTable> listaPersona = personRepository.findByName(name);

		for (PersonTable personTable : listaPersona) {
			personApi.setName(personTable.getName());
			personApi.setAddress(personTable.getAddress());
		}

		return personApi;
	}

	@Override
	public Void updatePerson(Person body) {
		Person person = new Person();
		person.setAddress("Alemania");

		return null;
	}

	@Override
	public PersonResponse deletePersonByName() {
		PersonResponse personResponse = new PersonResponse();
		personResponse.setResult("Persona borrada");

		return personResponse;
	}

}
