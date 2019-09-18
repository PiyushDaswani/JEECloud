package com.cg.booklab.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.cg.booklab.dto.Author;
import com.cg.booklab.dto.Book;
import com.cg.booklab.exception.BookException;

public interface BookDao {

	public Book addBook(Book book) throws BookException;

	public Book searchBook(BigInteger bookIsbn) throws BookException;

	public Integer removeBook(BigInteger bookIsbn) throws BookException;

	public List<Book> listAllBooks() throws BookException;

	public Integer updateBook(Book book) throws BookException;

	public Author addAuthor(Author author) throws BookException;

	public Author searchAuthor(BigInteger authorId) throws BookException;

	public Integer removeAuthor(BigInteger authorId) throws BookException;

	public List<Author> listAllAuthors() throws BookException;

	public Integer updateAuthor(Author author) throws BookException;

	public List<String> getBookTitle(BigInteger authorId) throws BookException;

	public Integer updateBookPrice(BigDecimal price, String authorFirstName) throws BookException;

}
