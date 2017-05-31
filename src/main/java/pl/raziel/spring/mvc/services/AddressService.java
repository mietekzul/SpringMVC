package pl.raziel.spring.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.raziel.spring.mvc.domain.Address;
import pl.raziel.spring.mvc.repositories.AddressesRepository;

import java.util.List;

/**
 * Created by dlok on 31/05/2017.
 */
@Component
public class AddressService {
	@Autowired
	private AddressesRepository repository;

	public List<Address> getAddresses() {
		return repository.findAll();
	}

}
