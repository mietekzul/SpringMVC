package pl.raziel.spring.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.raziel.spring.mvc.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
