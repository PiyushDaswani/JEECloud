/**
 * 
 */
package com.cg.booklab.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author admin
 *
 */
public class Book {

	/**
	 * 
	 */
	private BigInteger bookIsbn;
	private String bookTitle;
	private BigDecimal bookPrice;
	private BigInteger authorId;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(BigInteger bookIsbn, String bookTitle, BigDecimal bookPrice, BigInteger authorId) {
		super();
		this.bookIsbn = bookIsbn;
		this.bookTitle = bookTitle;
		this.bookPrice = bookPrice;
		this.authorId = authorId;
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

	public BigInteger getAuthorId() {
		return authorId;
	}

	public void setAuthorId(BigInteger authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Book [bookIsbn=" + bookIsbn + ", bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + ", authorId="
				+ authorId + "]";
	}

	@Override
	public int hashCode() {

		return this.bookIsbn.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}

}
