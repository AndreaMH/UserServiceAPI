package com.example.userserviceapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.userserviceapi.entities.PersonTable;
import com.example.userserviceapi.exceptions.InvalidAgeException;
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
	public PersonResponse createPerson(Person user) throws InvalidAgeException {
		PersonResponse personResponse = new PersonResponse();
		personResponse.setResult("Persona creada");

		PersonTable personTable = new PersonTable();

		String nombre = user.getName();
		personTable.setName(nombre);

		String dir = user.getAddress();
		personTable.setAddress(dir);

		int edad = user.getAge();

		if (edad < 18) {
			throw new InvalidAgeException(400);

		} else {
			personTable.setAge(edad);
			personRepository.save(personTable);
		}

		return personResponse;
	}

	@Override
	public People findAllPeople() {
		People people = new People();
		List<Person> peopleList = new ArrayList<Person>();

		try {
			List<PersonTable> listaPersonas = (List<PersonTable>) personRepository.findAll();

			/*
			 * for (PersonTable personTable : listaPersonas) { Person person = new Person();
			 * person.setName(personTable.getName());
			 * person.setAddress(personTable.getAddress());
			 * person.setAge(personTable.getAge());
			 * 
			 * peopleList.add(person); }
			 */

			listaPersonas.stream().forEach(personTable -> {
				recorrerListaPersonas(peopleList, personTable);
			});

			people.setResultCode("0"); // OK

		} catch (Exception e) {
			people.setResultCode("1"); // KO
		}

		people.setPeopleList(peopleList);

		return people;
	}

	private void recorrerListaPersonas(List<Person> peopleList, PersonTable personTable) {
		Person person = new Person();
		recorrerListaPersonaPorNombre(person, personTable);
		peopleList.add(person);
	}

	@Override
	public Person findPersonByName(String name) {
		Person personApi = new Person();

		List<PersonTable> listaPersona = personRepository.findByName(name);

		/*
		 * for (PersonTable personTable : listaPersona) {
		 * personApi.setName(personTable.getName());
		 * personApi.setAddress(personTable.getAddress());
		 * personApi.setAge(personTable.getAge()); }
		 */

		listaPersona.stream().forEach(personTable -> {
			recorrerListaPersonaPorNombre(personApi, personTable);
		});

		return personApi;
	}

	private void recorrerListaPersonaPorNombre(Person personApi, PersonTable personTable) {
		personApi.setName(personTable.getName());
		personApi.setAddress(personTable.getAddress());
		personApi.setAge(personTable.getAge());
	}

	@Override
	public Void updatePerson(Person body, String name) {
		PersonTable personTable = new PersonTable();

		// buscar persona en base de datos
		List<PersonTable> listaPersona = personRepository.findByName(name);

		long id = 0;

		for (PersonTable personlist : listaPersona) {
			personTable.setName(personlist.getName());
			personTable.setAddress(personlist.getAddress());
			personTable.setAge(personlist.getAge());
			id = personlist.getId();
		}

		/*
		 * listaPersona.stream().forEach((personList) -> {
		 * personTable.setName(personList.getName());
		 * personTable.setAddress(personList.getAddress());
		 * personTable.setAge(personList.getAge()); id = personList.getId(); });
		 */

		personTable = personRepository.findById(id).get();

		// setear la nueva direccion y edad
		personTable.setAddress(body.getAddress());
		personTable.setAge(body.getAge());

		// actualizar en base de datos la nueva persona
		personRepository.save(personTable);

		return null;
	}

	@Override
	public PersonResponse deletePersonByName(String name) {
		PersonResponse personResponse = new PersonResponse();
		personResponse.setResult("Persona borrada");

		List<PersonTable> listaPersona = personRepository.findByName(name);

		/*
		 * for (PersonTable personTable : listaPersona) { if
		 * (personTable.getName().equals(name)) { personRepository.delete(personTable);
		 * } }
		 */

		listaPersona.stream().filter(n -> n.getName().equals(name)).forEach(n -> {
			personRepository.delete(n);
		});

		return personResponse;
	}

}
