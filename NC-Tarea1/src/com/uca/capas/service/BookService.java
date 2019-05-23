package com.uca.capas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uca.capas.domain.Book;

@Service
public interface BookService{
	
	public List<Book> findAll();
	
	public List<Book> findbyCriteria(int criteria, String term);
	
	public int countAuthors();
	
	public int sumStock();
	
	public Book findOne(Integer id);
}
