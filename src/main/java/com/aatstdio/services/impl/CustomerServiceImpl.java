package com.aatstdio.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aatstdio.dto.DtoAddress;
import com.aatstdio.dto.DtoCustomer;
import com.aatstdio.dto.DtoCustomerIU;
import com.aatstdio.entities.Customer;
import com.aatstdio.repository.CustomerRepository;
import com.aatstdio.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public DtoCustomer getCustomerById(Long id) {
		DtoCustomer dtoResponse = new DtoCustomer();
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isPresent()) {
			BeanUtils.copyProperties(optional.get(), dtoResponse);
			return dtoResponse;
		}
		return dtoResponse;
	}

	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
		DtoCustomer dtoResponse = new DtoCustomer();

		DtoAddress dtoAddress = new DtoAddress();
		Customer customer = new Customer();

		return dtoResponse;
	}

}
