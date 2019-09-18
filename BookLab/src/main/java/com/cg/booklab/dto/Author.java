package com.cg.booklab.dto;

import java.math.BigInteger;

public class Author {

	private BigInteger authorId;
	private String authorFirstName;
	private String authorMiddleName;
	private String authorLastName;
	private BigInteger authorPhoneNo;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(BigInteger authorId, String authorFirstName, String authorMiddleName, String authorLastName,
			BigInteger authorPhoneNo) {
		super();
		this.authorId = authorId;
		this.authorFirstName = authorFirstName;
		this.authorMiddleName = authorMiddleName;
		this.authorLastName = authorLastName;
		this.authorPhoneNo = authorPhoneNo;
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

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorFirstName=" + authorFirstName + ", authorMiddleName="
				+ authorMiddleName + ", authorLastName=" + authorLastName + ", authorPhoneNo=" + authorPhoneNo + "]";
	}

	@Override
	public int hashCode() {
		return this.authorId.intValue();
	}

	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}
	

}
