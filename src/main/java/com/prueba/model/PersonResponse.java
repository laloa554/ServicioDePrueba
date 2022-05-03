package com.prueba.model;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {
	
	@NotNull
	private String name;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private int age;

}
