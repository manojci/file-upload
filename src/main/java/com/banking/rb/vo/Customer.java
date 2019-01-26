package com.banking.rb.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	private String firstName;
	private String lastName;
	private int issuesCount;
	private LocalDate dateOfBirth;

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", issuesCount=" + issuesCount
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}
}
