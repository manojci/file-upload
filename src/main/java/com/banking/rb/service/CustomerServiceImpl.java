package com.banking.rb.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.banking.rb.constants.AppConstants;
import com.banking.rb.util.FileUploadUtility;
import com.banking.rb.vo.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public List<Customer> fetchCustomerList(Stream<String> stream) {
		return stream.skip(1).map(val -> {
			String[] customerData = val.split(AppConstants.COMMA_SEPARATOR);
			return new Customer(customerData[0].replaceAll("[^A-Za-z]", ""),
					customerData[1].replaceAll("[^A-Za-z]", ""), Integer.parseInt(customerData[2]),
					FileUploadUtility.formatDate(customerData[3]));
		}).sorted(Comparator.comparing(Customer::getIssuesCount)).collect(Collectors.toList());
	}
}
