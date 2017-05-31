package pl.raziel.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.raziel.spring.mvc.domain.Address;
import pl.raziel.spring.mvc.domain.Employee;
import pl.raziel.spring.mvc.repositories.AddressesRepository;
import pl.raziel.spring.mvc.repositories.EmployeesRepository;

import java.util.List;

/**
 * Created by dlok on 31/05/2017.
 */
@Component
public class EmployeeService {

	@Autowired
	private EmployeesRepository employeesRepository;

	@Autowired
	private AddressesRepository addressesRepository;

	public List<Employee> getAllEmployees() {
		return employeesRepository.findAll();
	}

	public String addEmployee(Employee employee) {
		employeesRepository.save(employee);
		return "Employee added";
	}

	public void addAddressToEmployee(Long id, Address address) {

		final Employee employee = employeesRepository.findOne(id);
		final List<Address> employeeAddresses = employee.getAddresses();
		final Address entity = new Address();
		entity.setCountry(address.getCountry());
		entity.setNumber(address.getNumber());
		entity.setPostCode(address.getPostCode());
		entity.setStreet(address.getStreet());
		entity.setTown(address.getTown());
		employeeAddresses.add(entity);
		addressesRepository.save(entity);
		employeesRepository.save(employee);
	}


}
