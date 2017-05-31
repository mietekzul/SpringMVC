package pl.raziel.spring.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.raziel.spring.mvc.domain.Employee;

import javax.transaction.Transactional;

/**
 * Created by dlok on 31/05/2017.
 */
@Transactional
public interface EmployeesRepository extends JpaRepository<Employee, Long> {
}
