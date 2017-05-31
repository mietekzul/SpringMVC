package pl.raziel.spring.mvc.repositories.initrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.raziel.spring.mvc.domain.Person;
import pl.raziel.spring.mvc.repositories.PersonRepository;
import pl.raziel.spring.mvc.utils.PersonGenerator;

import java.util.List;

@Component
public class PersonRepositoryInit implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonGenerator personGenerator;

	@Override
	public void run(String... args) throws Exception {

		List<Person> persons = personGenerator.generatePersons();

		persons.stream().forEach(e -> personRepository.save(e));
	}
}
