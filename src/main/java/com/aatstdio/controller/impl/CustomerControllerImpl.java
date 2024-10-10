package com.aatstdio.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aatstdio.controller.ICustomerController;
import com.aatstdio.dto.DtoCustomer;
import com.aatstdio.dto.DtoCustomerIU;
import com.aatstdio.services.IAddressService;
import com.aatstdio.services.ICustomerService;

@RestController
@RequestMapping(path = "rest/api/customer")
public class CustomerControllerImpl implements ICustomerController {

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private IAddressService addressService;

	@GetMapping(path = "/{id}")
	public DtoCustomer getCustomerById(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}

	@Override
	@PostMapping(path = "/save")
	public DtoCustomer saveCustomer(@RequestBody DtoCustomerIU dtoCustomerIU) {

		addressService.saveAddress(dtoCustomerIU.adress);
		return customerService.saveCustomer(dtoCustomerIU);

	}

}
