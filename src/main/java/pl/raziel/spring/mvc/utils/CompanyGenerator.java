package pl.raziel.spring.mvc.utils;

import org.springframework.stereotype.Service;
import pl.raziel.spring.mvc.domain.Company;
import pl.raziel.spring.mvc.domain.Person;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CompanyGenerator {
	private static final int MAX_NUMBER_OF_COMPANIES_MINUS_ONE = 5;
	private static final int MIN_NUMBER_OF_COMPANIES = 1;
	private static final int MIN_NUMBER_OF_EMPLOYEES = 1;
	private static final int MAX_NUMBER_OF_EMPLOYEES_MINUS_ONE = 10;
	private final FileLinesLoader fileLinesLoader;
	private final PersonGenerator employeeGenerator;
	private static final Random random = new Random();

	public CompanyGenerator(FileLinesLoader fileLinesLoader, PersonGenerator employeeGenerator) {
		this.fileLinesLoader = fileLinesLoader;
		this.employeeGenerator = employeeGenerator;
	}

	public List<Company> generate() {
		return fileLinesLoader
				.loadLinesShuffled("companies")
				.stream()
				.limit(randomNumberOfCompanies())
				.map(this::generateCompany)
				.collect(Collectors.toList());
	}

	private Company generateCompany(String name) {
		return new Company(name, generateEmployees());
	}

	private List<Person> generateEmployees() {
		return employeeGenerator.generatePersons();
	}

	private int randomNumberOfEmployees() {
		return MIN_NUMBER_OF_EMPLOYEES + random.nextInt(MAX_NUMBER_OF_EMPLOYEES_MINUS_ONE);
	}

	private long randomNumberOfCompanies() {
		return MIN_NUMBER_OF_COMPANIES + random.nextInt(MAX_NUMBER_OF_COMPANIES_MINUS_ONE);
	}

	private String generateName() {
		return null;
	}
}

