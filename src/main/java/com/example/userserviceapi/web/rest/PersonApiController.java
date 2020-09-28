package com.example.userserviceapi.web.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.userserviceapi.service.PersonService;
import com.example.userserviceapi.web.api.PersonApi;
import com.example.userserviceapi.web.api.model.People;
import com.example.userserviceapi.web.api.model.Person;
import com.example.userserviceapi.web.api.model.PersonResponse;

import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-25T10:13:35.563Z")

@Controller
public class PersonApiController implements PersonApi {

	private PersonService personService;

	public PersonApiController(PersonService personService) {
		this.personService = personService;
	}

	public ResponseEntity<PersonResponse> createPerson(
			@ApiParam(value = "name and address", required = true) @Valid @RequestBody Person user) {

		return new ResponseEntity<PersonResponse>(personService.createPerson(user), HttpStatus.OK);
	}

	public ResponseEntity<PersonResponse> deletePersonByName() {

		return new ResponseEntity<PersonResponse>(personService.deletePersonByName(), HttpStatus.OK);
	}

	public ResponseEntity<People> findAllPeople() {

		return new ResponseEntity<People>(personService.findAllPeople(), HttpStatus.OK);
	}

	public ResponseEntity<Person> findPersonByName(
			@NotNull @ApiParam(value = "User's name", required = true) @Valid @RequestParam(value = "name", required = true) String name) {

		return new ResponseEntity<Person>(personService.findPersonByName(name), HttpStatus.OK);
	}

	public ResponseEntity<Void> updatePerson(
			@ApiParam(value = "name that need to be updated", required = true) @PathVariable("name") String name,
			@ApiParam(value = "Updated user object", required = true) @Valid @RequestBody Person body) {

		return new ResponseEntity<Void>(personService.updatePerson(body), HttpStatus.OK);
	}

}
