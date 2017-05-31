package pl.raziel.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.raziel.spring.mvc.domain.Address;
import pl.raziel.spring.mvc.domain.Employee;
import pl.raziel.spring.mvc.services.EmployeeService;

import java.util.List;

/**
 * Created by dlok on 31/05/2017.
 */
@RestController
@RequestMapping(path = "/employee")
public class EmployeesController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/getEmployees")
	public ResponseEntity<List<Employee>> getEmployees() {
		final List<Employee> allEmployees = employeeService.getAllEmployees();

		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}

	@PostMapping(value = "/addEmployee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {

		return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}/addAddress")
	public ResponseEntity<String> addAddressToEmployee(@PathVariable("id") Long id, @RequestBody Address address) {
		employeeService.addAddressToEmployee(id, address);

		return new ResponseEntity<>("Employee updated",HttpStatus.OK);
	}
}
