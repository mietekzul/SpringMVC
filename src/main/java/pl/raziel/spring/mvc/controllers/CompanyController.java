package pl.raziel.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.raziel.spring.mvc.domain.Company;
import pl.raziel.spring.mvc.domain.Employee;
import pl.raziel.spring.mvc.domain.Person;
import pl.raziel.spring.mvc.repositories.CompanyRepository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RequestMapping("companies")
@RestController
public class CompanyController {
	@Autowired
	private final CompanyRepository companyRepository;

	//    @Autowired
	public CompanyController(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@GetMapping
	List<Company> findALl() {
		return companyRepository.findAll();
	}

	@GetMapping("/{companyName}")
	Company findOne(@PathVariable("companyName") String name) {
		return companyRepository.findByName(name);
	}

	@GetMapping("{companyName}/employees/{firstName}")
	List<Person> findCompanyEmployeesWithFirstName(
			@PathVariable String companyName,
			@PathVariable("firstName") String name) {
		return findOne(companyName)
				.getEmployees()
				.stream()
				.filter(person -> Objects.equals(person.getName(), name))
				.collect(Collectors.toList());
	}

	@GetMapping("{companyName}/employees/{lastName}/{firstName}")
	List<Person> findCompanyEmployeesWithLastNameAndFirstName(@PathVariable Map<String, String> pathVariable) {
		return findOne(pathVariable.get("companyName"))
				.getEmployees()
				.stream()
				.filter(person -> Objects.equals(person.getSurname(), pathVariable.get("lastName")))
				.filter(person -> Objects.equals(person.getName(), pathVariable.get("firstName")))
				.collect(Collectors.toList());
	}
}