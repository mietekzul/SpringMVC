package pl.raziel.spring.mvc.requests;

import pl.raziel.spring.mvc.domain.Employee;

import java.util.List;

/**
 * Created by dlok on 01/06/2017.
 */
public class AddEmployeesRequest {
	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
