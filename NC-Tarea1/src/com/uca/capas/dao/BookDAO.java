package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Book;

public interface BookDAO {
	
	public List<Book> findAll() throws DataAccessException;
	
	public Book findOne(Integer code) throws DataAccessException;
	
	public List<Book> findByCriteria(String criteria, String term) throws DataAccessException;
	
	public int countAuthors() throws DataAccessException;
	
	public int sumBooks() throws DataAccessException;
}
