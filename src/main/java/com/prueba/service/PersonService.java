package com.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.entity.Person;
import com.prueba.repository.PersonRepository;

@Service
@Transactional
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
    public List<Person> list(){
        return personRepository.findAll();
    }

    public List<Person> findByName(String name){
        return personRepository.findByName(name);
    }

    public void save(Person person){
    	personRepository.save(person);
    }

    public void delete(long id){
    	personRepository.deleteById(id);
    }

    public boolean existsById(long id){
        return personRepository.existsById(id);
    }

    public boolean existsByName(String name){
        return personRepository.existsByName(name);
    }
}
