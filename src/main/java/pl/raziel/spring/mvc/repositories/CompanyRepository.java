package pl.raziel.spring.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.raziel.spring.mvc.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	Company findByName(String name);
}
