package pl.raziel.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.raziel.spring.mvc.domain.Address;
import pl.raziel.spring.mvc.services.AddressService;

import java.util.List;

/**
 * Created by dlok on 31/05/2017.
 */
@RestController
@RequestMapping("/demo")
public class AddressesController {

	@Autowired
	private AddressService service;

	@RequestMapping(value = "/getAddresses", method = RequestMethod.GET)
	public List<Address> getAddresses() {
		return service.getAddresses();
	}
}
