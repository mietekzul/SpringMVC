package pl.raziel.spring.mvc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Company {
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Employee> employees;

	public Company(String name, List<Employee> employees) {
		this.name = name;
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
