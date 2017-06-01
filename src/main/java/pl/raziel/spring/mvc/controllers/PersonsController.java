package pl.raziel.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.raziel.spring.mvc.domain.Person;
import pl.raziel.spring.mvc.services.PersonService;

import java.util.List;

@RestController
@RequestMapping(path = "/persons")
public class PersonsController {

	@Autowired
	private PersonService personService;

	@GetMapping(path = "getAll")
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> persons = personService.getPersons();

		return new ResponseEntity<>(persons, HttpStatus.OK);
	}
}
