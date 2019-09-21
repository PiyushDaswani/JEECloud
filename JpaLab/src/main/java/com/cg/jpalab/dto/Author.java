package com.cg.jpalab.dto;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lab_author")
public class Author {
	@Id
	@Column(name = "author_id")
	private BigInteger authorId;
	@Column(name = "author_fname")
	private String authorFirstName;
	@Column(name = "author_mname")
	private String authorMiddleName;
	@Column(name = "author_lname")
	private String authorLastName;
	@Column(name = "author_pno")
	private BigInteger authorPhoneNo;
	@ManyToMany(mappedBy = "author",cascade = CascadeType.PERSIST)
	private List<Book> bookList;

	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(BigInteger authorId, String authorFirstName, String authorMiddleName, String authorLastName,
			BigInteger authorPhoneNo, List<Book> bookList) {
		super();
		this.authorId = authorId;
		this.authorFirstName = authorFirstName;
		this.authorMiddleName = authorMiddleName;
		this.authorLastName = authorLastName;
		this.authorPhoneNo = authorPhoneNo;
		this.bookList = bookList;
	}

	public BigInteger getAuthorId() {
		return authorId;
	}

	public void setAuthorId(BigInteger authorId) {
		this.authorId = authorId;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public String getAuthorMiddleName() {
		return authorMiddleName;
	}

	public void setAuthorMiddleName(String authorMiddleName) {
		this.authorMiddleName = authorMiddleName;
	}

	public String getAuthorLastName() {
		return authorLastName;
	}

	public void setAuthorLastName(String authorLastName) {
		this.authorLastName = authorLastName;
	}

	public BigInteger getAuthorPhoneNo() {
		return authorPhoneNo;
	}

	public void setAuthorPhoneNo(BigInteger authorPhoneNo) {
		this.authorPhoneNo = authorPhoneNo;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorFirstName=" + authorFirstName + ", authorMiddleName="
				+ authorMiddleName + ", authorLastName=" + authorLastName + ", authorPhoneNo=" + authorPhoneNo
				+ "]";
	}

}
