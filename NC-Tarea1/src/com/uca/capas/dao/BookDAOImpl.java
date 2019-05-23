package com.uca.capas.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	
	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.book");
		Query query = entityManager.createNativeQuery(sb.toString(),Book.class);
		List<Book> resultset = query.getResultList();
		return resultset;
	}

	@Override
	public Book findOne(Integer code) throws DataAccessException {
		Book student = entityManager.find(Book.class, code);
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByCriteria(String criteria, String term) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.book where lower("+criteria+") like lower(concat('%', ?1 ,'%')) order by id_book");
		Query query = entityManager.createNativeQuery(sb.toString(), Book.class);
		query.setParameter(1, term);
		
		List<Book> books = query.getResultList();
		return books;
	}

	@Override
	public int countAuthors() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) as authors FROM (select distinct author from public.book) AS temp");
		Query query = entityManager.createNativeQuery(sb.toString());
		return ((BigInteger) query.getSingleResult()).intValue();
	}
	
	@Override
	public int sumBooks() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select sum(stock) from public.book");
		Query query = entityManager.createNativeQuery(sb.toString());
		return ((BigInteger) query.getSingleResult()).intValue();
	}

}
