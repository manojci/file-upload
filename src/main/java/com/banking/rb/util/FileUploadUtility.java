package com.banking.rb.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileUploadUtility {

	public static LocalDate formatDate(String dateString) {
		return LocalDate.parse(dateString.replaceAll("[^T0-9-]", "").split("T")[0],
				DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
}
