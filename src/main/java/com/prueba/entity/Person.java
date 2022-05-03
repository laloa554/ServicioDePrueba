package com.prueba.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "PEOPLE")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "NAME", nullable = false, length = 150)
	private String name;
	
	@Column(name = "LAST_NAME", nullable = false, length = 150)
	private String lastName;
	
	@Column(name = "AGE", nullable = false, length = 150)
	private int age;
}
