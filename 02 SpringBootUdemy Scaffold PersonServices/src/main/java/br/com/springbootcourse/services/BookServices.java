package br.com.springbootcourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springbootcourse.data.model.Book;
import br.com.springbootcourse.data.vo.v1.BookVO;
import br.com.springbootcourse.exception.ResourceNotFoundException;
import br.com.springbootcourse.parser.DozerParser;
import br.com.springbootcourse.repository.BookRepository;

@Service
public class BookServices {

	@Autowired
	BookRepository repository;
	
	public BookVO create(BookVO book) {
		var entity = DozerParser.parseObject(book, Book.class);
		var vo = DozerParser.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	public Page<BookVO> findAll(Pageable pageable) throws Exception{
		var page = repository.findAll(pageable);
		return page.map(this::convertToBookVO);
	}
	
	private BookVO convertToBookVO(Book entity) {
		return DozerParser.parseObject(entity, BookVO.class);
	}

	public BookVO findById(Long id) {
		var entity = DozerParser.parseObject(repository.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("No records found for this ID"))
				, BookVO.class);
		return entity;
	}
	
	public BookVO update(BookVO book) {
		var entity = repository.findById(book.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		return DozerParser.parseObject(repository.save(entity), BookVO.class);
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}

}
