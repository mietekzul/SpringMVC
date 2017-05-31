package pl.raziel.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.raziel.spring.mvc.domain.Person;
import pl.raziel.spring.mvc.repositories.PersonRepository;

import java.util.List;

@Component
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public List<Person> getPersons() {
		return personRepository.findAll();
	}
}
