package com.codingdojo.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.relationships.models.Person;
import com.codingdojo.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	public List<Person> allPerson() {
		return (List<Person>) personRepository.findAll();
	}

	public Person findPerson(long n) {
		Optional<Person> optionalPerson = personRepository.findById(n);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
}