package br.com.springbootcourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springbootcourse.data.model.Person;
import br.com.springbootcourse.data.vo.v1.PersonVO;
import br.com.springbootcourse.exception.ResourceNotFoundException;
import br.com.springbootcourse.parser.DozerParser;
import br.com.springbootcourse.repository.PersonRepository;

@Service
public class PersonServices {
		
	@Autowired
	PersonRepository repository;

	public PersonVO create(PersonVO person) {
		var entity = DozerParser.parseObject(person, Person.class);
		var vo = DozerParser.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public List<PersonVO> findAll() throws Exception{
		return DozerParser.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		return DozerParser.parseObject(repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID")), PersonVO.class);
	}
	
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerParser.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	@Transactional
	public PersonVO desablePerson(Long id) {
		repository.desablePerson(id);
		return DozerParser.parseObject(repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID")), PersonVO.class);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID"));
		repository.delete(entity);
	}
}
