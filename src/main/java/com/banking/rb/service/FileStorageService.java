package com.banking.rb.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

	public void store(MultipartFile file);

	public Resource loadFile(String filename);

	public void deleteAll();

	public void init();
}
