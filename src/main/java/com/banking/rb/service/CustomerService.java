package com.banking.rb.service;

import java.util.List;
import java.util.stream.Stream;

import com.banking.rb.vo.Customer;

@FunctionalInterface
public interface CustomerService {
	List<Customer> fetchCustomerList(Stream<String> stream);
}
