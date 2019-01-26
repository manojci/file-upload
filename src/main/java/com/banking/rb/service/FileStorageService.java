package com.banking.rb.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

	void store(MultipartFile file);

	Resource loadFile(String filename);

	void deleteAll();

	void init();
	
	boolean fileAlreadyExists(String filename) throws IOException;
}
