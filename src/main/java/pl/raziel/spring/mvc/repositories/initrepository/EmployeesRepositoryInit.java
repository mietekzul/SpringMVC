package pl.raziel.spring.mvc.repositories.initrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.raziel.spring.mvc.repositories.EmployeesRepository;

/**
 * Created by dlok on 31/05/2017.
 */
@Component
public class EmployeesRepositoryInit implements CommandLineRunner {

	@Autowired
	private EmployeesRepository employeesRepository;

	@Override
	public void run(String... args) throws Exception {
	}
}
