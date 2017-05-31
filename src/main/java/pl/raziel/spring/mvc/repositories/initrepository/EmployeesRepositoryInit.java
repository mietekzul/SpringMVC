package pl.raziel.spring.mvc.repositories.initrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.raziel.spring.mvc.domain.Address;
import pl.raziel.spring.mvc.domain.Employee;
import pl.raziel.spring.mvc.domain.Person;
import pl.raziel.spring.mvc.repositories.EmployeesRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dlok on 31/05/2017.
 */
@Component
public class EmployeesRepositoryInit implements CommandLineRunner {

	@Autowired
	private EmployeesRepository employeesRepository;

	@Override
	public void run(String... args) throws Exception {

		final Employee employee = new Employee();

		final Person person = new Person();
		person.setName("Name");
		person.setSecondName("SecondName");
		person.setSurname("Surname");
		person.setBirthDate("21-06-1986");
		employee.setPerson(person);

		final List<Address> addresses = new ArrayList<>();
		Address address = new Address();
		address.setCountry("PL");
		address.setNumber((short) 24);
		address.setPostCode("91-328");
		address.setStreet("Limanka Street");
		address.setTown("Lodz");
		addresses.add(address);
		employee.setAddresses(addresses);

		Arrays.asList(employee).forEach(e -> employeesRepository.save(e));
	}
}
