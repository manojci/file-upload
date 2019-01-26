package com.banking.rb.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.banking.rb.service.CustomerService;
import com.banking.rb.service.FileStorageService;
import com.banking.rb.vo.Customer;

@RestController
public class FileUploadController {

	@Autowired
	FileStorageService fileStorageService;
	@Autowired
	CustomerService customerService;

	List<String> files = new ArrayList<String>();

	@RequestMapping(name = "/upload", method = RequestMethod.POST)
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			fileStorageService.store(file);
			files.add(file.getOriginalFilename());

			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

	@RequestMapping(name = "/display-data", method = RequestMethod.GET)
	public ResponseEntity<Object> getCustomerData(@RequestParam String fileName) throws IOException {
		Resource file = fileStorageService.loadFile(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
		List<Customer> list = customerService.fetchCustomerList(br.lines());
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
}
