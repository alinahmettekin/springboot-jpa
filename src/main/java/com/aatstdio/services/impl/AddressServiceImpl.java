package com.aatstdio.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aatstdio.dto.DtoAddress;
import com.aatstdio.entities.Address;
import com.aatstdio.repository.AddressRepository;
import com.aatstdio.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	AddressRepository addressRepository;

	@Override
	public DtoAddress saveAddress(String insertAddress) {
		DtoAddress dtoResponse = new DtoAddress();
		Address address = new Address();
		address.setAddressDescription(insertAddress);
		Address dbAddress = addressRepository.save(address);
		BeanUtils.copyProperties(dbAddress, dtoResponse);
		return dtoResponse;
	}
}
