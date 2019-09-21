package com.cg.jpalab.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.cg.jpalab.dto.Author;
import com.cg.jpalab.dto.Book;

public interface AuthorDao {

	public Author saveAuthor(Author author);
	public Author findAuthor(BigInteger authorId);
	public Author removeAuthor(BigInteger authorId);
	public List<Author> findAllAuthor();
	public Book saveBook(Book book);
	public Book findBook(BigInteger bookID);
	public List<Book> findAllBook();
	public List<Book> findBookWithPrice(BigDecimal min, BigDecimal max);
	public List<Book> findBookByAuthorName(String authorName);
	public List<String> findAuthorByBook(BigInteger bookIsbn);
	
}
