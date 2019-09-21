package com.cg.jpalab.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lab_book")
public class Book {

	@Id
	@Column(name = "book_isbn")
	private BigInteger bookIsbn;
	@Column(name = "book_title")
	private String bookTitle;
	@Column(name = "book_price")
	private BigDecimal bookPrice;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn(name = "book_fk"), inverseJoinColumns = @JoinColumn(name = "author_fk"))
	private List<Author> author;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(BigInteger bookIsbn, String bookTitle, BigDecimal bookPrice, List<Author> author) {
		super();
		this.bookIsbn = bookIsbn;
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
		this.author = author;
	}

	public BigInteger getBookIsbn() {
		return bookIsbn;
	}

	public void setBookIsbn(BigInteger bookIsbn) {
		this.bookIsbn = bookIsbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [bookIsbn=" + bookIsbn + ", bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + ", author="
				+ author + "]";
	}

}
