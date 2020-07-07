package br.com.springbootcourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springbootcourse.exception.ResourceNotFoundException;
import br.com.springbootcourse.model.Person;
import br.com.springbootcourse.repository.PersonRepository;

@Service
public class PersonServices {
		
	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public List<Person> findAll() throws Exception{
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
	}
	
	public Person update(Person person) {
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddres(person.getAddres());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
		repository.delete(entity);
	}
}
