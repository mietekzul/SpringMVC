package pl.raziel.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.raziel.spring.mvc.domain.Employee;
import pl.raziel.spring.mvc.repositories.EmployeesRepository;

import java.util.List;

/**
 * Created by dlok on 31/05/2017.
 */
@Component
public class EmployeeService {

	@Autowired
	private EmployeesRepository employeesRepository;

	public List<Employee> getAllEmployees() {
		return employeesRepository.findAll();
	}

	public String addEmployee(Employee employee) {
		employeesRepository.save(employee);
		return "Employee added";
	}
}
