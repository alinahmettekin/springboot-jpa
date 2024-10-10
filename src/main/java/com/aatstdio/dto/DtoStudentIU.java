package com.aatstdio.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {

	@NotEmpty(message = "Firstname cannot be empty")
	@NotBlank(message = "Firstname cannot be blank")
	@Size(min = 3, max = 30)
	private String firstName;

	@NotEmpty(message = "Lastname cannot be empty")
	@NotBlank(message = "Lastname cannot be blank")
	@Size(min = 3, max = 30)
	private String lastName;

	@Null()
	@NotBlank(message = "Birth Date cannot be blank")
	private Date birthOfDate;

}
