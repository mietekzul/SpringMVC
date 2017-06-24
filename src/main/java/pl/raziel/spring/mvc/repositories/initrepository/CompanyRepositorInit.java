package pl.raziel.spring.mvc.repositories.initrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.raziel.spring.mvc.domain.Company;
import pl.raziel.spring.mvc.repositories.CompanyRepository;
import pl.raziel.spring.mvc.utils.CompanyGenerator;

import java.util.List;

@Component
public class CompanyRepositorInit implements CommandLineRunner {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private CompanyGenerator companyGenerator;

	@Override
	public void run(String... args) throws Exception {

		List<Company> companies = companyGenerator.generate();

		companies.forEach(company -> companyRepository.save(company));

		System.out.println(companyRepository.findAll());

	}
}
