package pl.raziel.spring.mvc.utils;

import org.springframework.stereotype.Service;
import pl.raziel.spring.mvc.domain.Person;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PersonGenerator {
	private static final String FIRST_NAMES_FILE_PATH = "firstNames";
	private static final double SALARY_BASE = 1_000.0;
	private static final double SALARY_SPREAD = 10_000.0;
	private final FileLinesLoader fileLinesLoader;
	private List<String> firstNames;
	private List<String> lastNames;
	private final Random random = new Random();

	public PersonGenerator(FileLinesLoader fileLinesLoader) {
		this.fileLinesLoader = fileLinesLoader;
	}

	public List<Person> generatePersons() {
		return Stream
				.generate(this::generate)
				.limit(10)
				.collect(Collectors.toList());
	}

	private Person generate() {
		Person person = new Person();
		person.setName(getRandomFirstName());
		person.setSecondName(getRandomFirstName());
		person.setSurname(getRandomLastName());
		return person;
	}

	private String getRandomFirstName() {
		return getRandom(getFirstNames());
	}

	private String getRandomLastName() {
		return getRandom(getLastNames());
	}

	private List<String> getLastNames() {
		if (lastNames == null) {
			lastNames = fileLinesLoader.loadLines("lastNames");
		}
		return lastNames;
	}

	private List<String> getFirstNames() {
		if (firstNames == null) {
			firstNames = fileLinesLoader.loadLines(FIRST_NAMES_FILE_PATH);
		}
		return firstNames;
	}

	private String getRandom(List<String> elements) {
		return elements.get(random.nextInt(elements.size()));
	}
}
