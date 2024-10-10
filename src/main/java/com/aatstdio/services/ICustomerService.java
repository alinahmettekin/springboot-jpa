package com.aatstdio.services;

import com.aatstdio.dto.DtoCustomer;
import com.aatstdio.dto.DtoCustomerIU;

public interface ICustomerService {

	public DtoCustomer getCustomerById(Long id);

	public DtoCustomer saveCustomer(DtoCustomerIU customerIU);
}
