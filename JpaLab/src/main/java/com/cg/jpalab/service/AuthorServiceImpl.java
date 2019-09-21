package com.cg.jpalab.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.cg.jpalab.dao.AuthorDao;
import com.cg.jpalab.dao.AuthorDaoImpl;
import com.cg.jpalab.dto.Author;
import com.cg.jpalab.dto.Book;

public class AuthorServiceImpl implements AuthorService{

	AuthorDao dao = new AuthorDaoImpl();

	public AuthorServiceImpl() {
		super();
	}

	@Override
	public Author saveAuthor(Author author) {
		return dao.saveAuthor(author);
	}

	@Override
	public Author findAuthor(BigInteger authorId) {
		// TODO Auto-generated method stub
		return dao.findAuthor(authorId);
	}

	@Override
	public Author removeAuthor(BigInteger authorId) {
		// TODO Auto-generated method stub
		return dao.removeAuthor(authorId);
	}

	@Override
	public List<Author> findAllAuthor() {
		// TODO Auto-generated method stub
		return dao.findAllAuthor();
	}

	@Override
	public Book saveBook(Book book) {
		return dao.saveBook(book);
	}

	@Override
	public Book findBook(BigInteger bookID) {
		return dao.findBook(bookID);
	}

	@Override
	public List<Book> findAllBook() {
		return dao.findAllBook();
	}

	@Override
	public List<Book> findBookWithPrice(BigDecimal min, BigDecimal max) {
		
		return dao.findBookWithPrice(min, max);
	}

	@Override
	public List<Book> findBookByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		return dao.findBookByAuthorName(authorName);
	}

	@Override
	public List<String> findAuthorByBook(BigInteger bookIsbn) {
		// TODO Auto-generated method stub
		return dao.findAuthorByBook(bookIsbn);
	}

}
