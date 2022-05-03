package com.prueba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findByName(String name);
	boolean existsByName(String name);
	

}
