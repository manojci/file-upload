package com.banking.rb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.banking.rb.service.FileStorageService;

@SpringBootApplication
public class FileUploaderApplication implements CommandLineRunner {

	@Autowired
	FileStorageService fileStorageService;

	public static void main(String[] args) {
		SpringApplication.run(FileUploaderApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		fileStorageService.deleteAll();
		fileStorageService.init();
	}
}