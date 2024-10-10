package com.aatstdio.controller;

import com.aatstdio.dto.DtoCustomer;
import com.aatstdio.dto.DtoCustomerIU;

public interface ICustomerController {

	public DtoCustomer getCustomerById(Long id);

	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
