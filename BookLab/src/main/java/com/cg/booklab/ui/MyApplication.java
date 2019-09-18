package com.cg.booklab.ui;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import com.cg.booklab.dao.BookDao;
import com.cg.booklab.dao.BookDaoImpl;
import com.cg.booklab.dto.Author;
import com.cg.booklab.dto.Book;
import com.cg.booklab.exception.BookException;

public class MyApplication {

	public MyApplication() {
		// TODO Auto-generated constructor stub
	}

	private static BookDao bookDao;
	static {
		bookDao = new BookDaoImpl();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x;
		System.out.println("Choose what you wanna do");
		System.out.println("1. Add a Book");
		System.out.println("2. List all books");
		System.out.println("3. Add an author");
		System.out.println("4. List all authors");
		System.out.println("5. Find books by an author");
		System.out.println("6. Change price of books by a single author");
		System.out.println("0. Exit");
		x = sc.nextInt();
		while (x != 0) {
			switch (x) {
			case 1: {
				System.out.println("Enter the book Title : ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.println("Enter the book price: ");
				BigDecimal price = sc.nextBigDecimal();
				System.out.println("Enter the Author ID : ");
				BigInteger authorId = sc.nextBigInteger();
				Book book = new Book();
				book.setBookTitle(title);
				book.setBookPrice(price);
				book.setAuthorId(authorId);
				try {
					if (bookDao.addBook(book) == null) {
						System.out.println("Database is FULL! CANNOT ADD MORE ITEMS!!");
					}
				} catch (BookException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			}
			case 2: {
				List<Book> books;
				try {
					books = bookDao.listAllBooks();
					for (Book book : books) {
						System.out.println(book);
					}
				} catch (BookException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

				break;
			}
			case 3: {
				System.out.println("Enter the Author First Name : ");
				sc.nextLine();
				String fname = sc.nextLine();
				System.out.println("Enter the Author Middle Name :");
				String mname = sc.nextLine();
				System.out.println("Enter the Author Last Name : ");
				String lname = sc.nextLine();
				System.out.println("Enter the Author Phone No. : ");
				BigInteger authorPhoneNo = sc.nextBigInteger();
				Author author = new Author();
				author.setAuthorFirstName(fname);
				author.setAuthorMiddleName(mname);
				author.setAuthorLastName(lname);
				author.setAuthorPhoneNo(authorPhoneNo);
				try {
					if (bookDao.addAuthor(author) == null) {
						System.out.println("Database is full");
					}
				} catch (BookException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			}
			case 4: {
				List<Author> authors;
				try {
					authors = bookDao.listAllAuthors();
					for (Author author : authors) {
						System.out.println(author);
					}
				} catch (BookException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

				break;
			}
			case 5: {
				System.out.println("Enter the id of the author: ");
				BigInteger authorId = sc.nextBigInteger();
				try {
					List<String> bookTitles = bookDao.getBookTitle(authorId);
					if (!bookTitles.isEmpty()) {
						for (String bookTitle : bookTitles) {
							System.out.println(bookTitle);
						}
					} else {
						System.out.println("No books found for the given author!");
					}
				} catch (BookException e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			}
			case 6: {
				System.out.println("Enter the name of the author : ");
				sc.nextLine();
				String authorFirstName = sc.nextLine();
				System.out.println("Enter the price for the books : ");
				BigDecimal price = sc.nextBigDecimal();
				try {
					int numberOfLines = bookDao.updateBookPrice(price, authorFirstName);
					if (numberOfLines > 0) {
						System.out.println(numberOfLines + " rows have been updated in the book table");
					} else {
						System.out.println("No lines were updated");
					}
				} catch (BookException e) {
					System.out.println(e.getMessage());
				}

			}
			case 0: {
				x = 0;
				break;
			}
			default: {
				System.out.println("Enter Valid Input!");
			}
			}
			System.out.println("Choose what you wanna do");
			System.out.println("1. Add a Book");
			System.out.println("2. List all books");
			System.out.println("3. Add an author");
			System.out.println("4. List all authors");
			System.out.println("5. Find books by an author");
			System.out.println("6. Change price of books by a single author");
			System.out.println("0. Exit");
			x = sc.nextInt();
		}
		sc.close();
	}
}
