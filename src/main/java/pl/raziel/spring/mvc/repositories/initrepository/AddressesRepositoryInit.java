package pl.raziel.spring.mvc.repositories.initrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.raziel.spring.mvc.domain.Address;
import pl.raziel.spring.mvc.repositories.AddressesRepository;

import java.util.Arrays;

/**
 * Created by dlok on 31/05/2017.
 */
@Component
public class AddressesRepositoryInit implements CommandLineRunner {

	@Autowired
	private AddressesRepository addressesRepository;

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address();
		address.setTown("Town");
		address.setStreet("Street");
		address.setPostCode("PostCode");
		address.setNumber((short) 7);
		address.setCountry("PL");

		Arrays.asList(address).forEach(e -> addressesRepository.save(address));
	}
}
