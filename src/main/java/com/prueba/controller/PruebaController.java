package com.prueba.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.entity.Person;
import com.prueba.model.Name;
import com.prueba.model.PersonRequest;
import com.prueba.model.PersonResponse;
import com.prueba.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/prueba")
@CrossOrigin(origins = "*")
@Slf4j
public class PruebaController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/save")
	public ResponseEntity<Void> save(@RequestBody PersonRequest p){
		Person x = new Person();
		x.setName(p.getName());
		x.setLastName(p.getLastName());
		x.setAge(p.getAge());
		log.info(":::: Saving Person ::::");
		log.info(p.getName());
		log.info(p.getLastName());
		log.info(String.valueOf(p.getAge()));
		personService.save(x);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	@SuppressWarnings("null")
	@PostMapping("/retrieve")
	public ResponseEntity<List<PersonResponse>> retrieve(@RequestBody Name name){
		log.info(name.getName());
		if(personService.existsByName(name.getName())) {
			log.debug("hay un: " + name.getName());
			List<Person> x = personService.findByName(name.getName());
			List<PersonResponse> r = new ArrayList<PersonResponse>();
			for(Person e : x) {
				PersonResponse p = new PersonResponse();
				p.setName(e.getName());
				p.setLastName(e.getLastName());
				p.setAge(e.getAge());
				r.add(p);
				log.info("add person to list");
			}
			log.debug("returning something");
			return new ResponseEntity<>(r,HttpStatus.OK);
		}
		log.error("not found anything");
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
