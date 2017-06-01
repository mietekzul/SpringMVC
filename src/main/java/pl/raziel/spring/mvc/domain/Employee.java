package pl.raziel.spring.mvc.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by dlok on 31/05/2017.
 */
@Entity
public class Employee {
	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private BigDecimal salary;
	private static long lastEmployeeId = 0;


	public Employee() {
	}

	public Employee(Long id, String firstName, String lastName, BigDecimal salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public static long getNextEmployeeId() {
		return lastEmployeeId++;
	}
}
