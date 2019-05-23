package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.BookDAO;
import com.uca.capas.domain.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookDAO bookDao;

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Override
	public List<Book> findbyCriteria(int criteria, String term) {
		switch(criteria) {
			case 0: return bookDao.findByCriteria("title", term);
			case 1: return bookDao.findByCriteria("author", term);
			case 2: return bookDao.findByCriteria("isbn", term);
			case 3: return bookDao.findByCriteria("genre", term);
			default: return bookDao.findAll();
		}
	}

	@Override
	public Book findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAuthors() {
		return bookDao.countAuthors();
	}
	
	public int sumStock() {
		return bookDao.sumBooks();
	}

}
