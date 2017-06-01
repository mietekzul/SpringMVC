package pl.raziel.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.raziel.spring.mvc.domain.Company;
import pl.raziel.spring.mvc.domain.Employee;
import pl.raziel.spring.mvc.repositories.CompanyRepository;
import pl.raziel.spring.mvc.requests.AddEmployeesRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@RequestMapping(value = "${urls.company.root}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
@RestController
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;

	@GetMapping
	List<Company> findAll() {
		return companyRepository.findAll();
	}

	@GetMapping("/{companyName}")
	Company findOne(@PathVariable("companyName") String name) {
		return companyRepository.findByName(name);
	}

	@GetMapping("{companyName}/employees/{firstName:[a-zA-Z]+}")
	List<Employee> findCompanyEmployeesWithFirstName(
			@PathVariable String companyName,
			@PathVariable("firstName") String name) {
		return findOne(companyName)
				.getEmployees()
				.stream()
				.filter(employee -> Objects.equals(employee.getFirstName(), name))
				.collect(Collectors.toList());
	}

	@GetMapping(value = "{companyName}/employees/{employeeId:\\d+}", produces = MediaType.APPLICATION_JSON_VALUE)
	Employee findCompanyEmployeeWithId(
			@PathVariable String companyName,
			@PathVariable long employeeId
	) {
		return findOne(companyName)
				.getEmployees()
				.stream()
				.filter(employee -> employee.getId() == employeeId)
				.findAny()
				.orElse(null);
	}

	@GetMapping("{companyName}/employees/{lastName}/{firstName}")
	List<Employee> findCompanyEmployeesWithLastNameAndFirstName(@PathVariable Map<String, String> pathVariable) {
		return findOne(pathVariable.get("companyName"))
				.getEmployees()
				.stream()
				.filter(employee -> Objects.equals(employee.getLastName(), pathVariable.get("lastName")))
				.filter(employee -> Objects.equals(employee.getFirstName(), pathVariable.get("firstName")))
				.collect(Collectors.toList());
	}

	@PostMapping("{companyName}/employees/create")
	Employee addEmployee(
			@PathVariable String companyName,
			@RequestParam(value = "firstName", required = true) String name,
			@RequestParam String lastName,
			@RequestParam(required = false) BigDecimal salary
	) {
		Company original = companyRepository.findByName(companyName);
		List<Employee> employees = new ArrayList<>(original.getEmployees());
		Employee employee = new Employee(Employee.getNextEmployeeId(), name, lastName, salary);
		employees.add(employee);
		Company newCompany = new Company(original.getName(), employees);
		companyRepository.save(newCompany);
		return employee;
	}

	@PostMapping(value = "{companyName}/employees", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	List<Employee> addEmployees(@PathVariable String companyName, @RequestBody AddEmployeesRequest request) {

		final Company company = companyRepository.findByName(companyName);
		List<Employee> employees = new ArrayList<>(company.getEmployees());
		final List<Employee> newEmployees = createEmployees(request.getEmployees());
		employees.addAll(newEmployees);

		Company newCompany = new Company(company.getName(), employees);
		companyRepository.save(newCompany);

		return newEmployees;
	}

	private List<Employee> createEmployees(List<Employee> employees) {
		return employees
				.stream()
				.map(employee ->
						new Employee(
								employee.getId(),
								employee.getFirstName(),
								employee.getLastName(),
								employee.getSalary()))
				.collect(Collectors.toList());
	}

}