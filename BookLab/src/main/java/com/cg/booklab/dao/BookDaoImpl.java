package com.cg.booklab.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.booklab.dto.Author;
import com.cg.booklab.dto.Book;
import com.cg.booklab.exception.BookException;
import com.cg.booklab.util.DbUtil;

public class BookDaoImpl implements BookDao {

	private static Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private static Logger myLogger;

	static {

		Properties props = System.getProperties();
		String userDir = props.getProperty("user.dir") + "/src/main/resources/";
		System.out.println("Current working directory is " + userDir);
		PropertyConfigurator.configure(userDir + "log4j.properties");
		myLogger = Logger.getLogger("DbUtil.class");
	}

	static {
		try {
			connection = DbUtil.getConnection();
			myLogger.info("Connection obtained");
		} catch (BookException e) {
			// TODO Auto-generated catch block
			myLogger.error("Connection not obtained at Employee Dao");
			System.out.println("Connection not obtained at Employee Dao" + e);
		}
	}

	public BookDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Book addBook(Book book) throws BookException {
		// TODO Auto-generated method stub
		String sql = "insert into book(book_title, book_price, author_id) values(?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, book.getBookTitle());
			preparedStatement.setBigDecimal(2, book.getBookPrice());
			preparedStatement.setLong(3, book.getAuthorId().longValue());
			preparedStatement.executeUpdate();
			BigInteger generatedId = BigInteger.valueOf(0L);
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				generatedId = BigInteger.valueOf(resultSet.getLong(1));
				System.out.println("Auto generated id : " + generatedId);
			}
			book.setBookIsbn(generatedId);
			System.out.println("Added book to the database with id as : " + generatedId);
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new BookException("The author id entered doesnt exist!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error at add Book Dao method: " + e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error at add Book Dao method: " + e);
				}
			}
		}
		return book;
	}

	@Override
	public Book searchBook(BigInteger bookIsbn) throws BookException {
		String sql = "Select * from book where book_ISBN = ?";
		Book book = new Book();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, bookIsbn.longValue());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				book.setBookIsbn(BigInteger.valueOf(resultSet.getLong("book_ISBN")));
				book.setBookTitle(resultSet.getString("book_title"));
				book.setBookPrice(resultSet.getBigDecimal("book_price"));
				book.setAuthorId(BigInteger.valueOf(resultSet.getLong("author_id")));
			} else {
				book = null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error at search Book Dao method: " + e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error at search Book Dao method: " + e);
				}
			}
		}
		return book;
	}

	@Override
	public Integer removeBook(BigInteger bookIsbn) {
		// TODO Auto-generated method stub
		String sql = "delete from book where book_ISBN=?";
		int noOfRec = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, bookIsbn.longValue());

			noOfRec = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" Error at delete book Dao method : " + e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println(" Error at delete book Dao method : " + e);
				}
			}
		}
		return noOfRec;
	}

	@Override
	public List<Book> listAllBooks() {
		// TODO Auto-generated method stub
		String sql = "select * from book";
		List<Book> bookList = new ArrayList<Book>();
		try {
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// for select queries we have executeQuery method which returns ResultSet
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// create book obj
				Book book = new Book();
				// get the value from resultSet and set to book obj
				book.setBookIsbn(BigInteger.valueOf(resultSet.getLong("book_ISBN")));
				book.setBookTitle(resultSet.getString("book_title"));
				book.setBookPrice(resultSet.getBigDecimal("book_price"));
				book.setAuthorId(BigInteger.valueOf(resultSet.getLong("author_id")));
				// add the book obj to empList
				bookList.add(book);

			}
		} catch (SQLException e) {
			System.out.println(" Error at list all book Dao method : " + e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println(" Error at list all book Dao method : " + e);
				}
			}
		}
		return bookList;
	}

	@Override
	public Integer updateBook(Book book) {
		// TODO Auto-generated method stub
		String sql = "update book set book_price=? AND book_title=? AND author_id = ? where book_ISBN=?";
		int noOfRec = 0;
		try {

			// transaction boundary starts
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(2, book.getBookTitle());
			preparedStatement.setBigDecimal(1, book.getBookPrice());
			preparedStatement.setLong(3, book.getAuthorId().longValue());
			preparedStatement.setLong(4, book.getBookIsbn().longValue());

			noOfRec = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(" Error at updateBook Dao method : " + e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println(" Error at updateBook Dao method : " + e);
				}
			}
		}
		return noOfRec;
	}

	@Override
	public Author addAuthor(Author author) throws BookException {
		// TODO Auto-generated method stub
		String sql = "insert into author(author_fname, author_mname, author_lname, author_phone) values(?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, author.getAuthorFirstName());
			preparedStatement.setString(2, author.getAuthorMiddleName());
			preparedStatement.setString(3, author.getAuthorLastName());
			preparedStatement.setLong(4, author.getAuthorPhoneNo().longValue());
			preparedStatement.executeUpdate();
			BigInteger generatedId = BigInteger.valueOf(0L);
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				generatedId = BigInteger.valueOf(resultSet.getLong(1));
				System.out.println("Auto generated id : " + generatedId);
			}
			author.setAuthorId(generatedId);
			System.out.println("Added Author to the database with id as : " + generatedId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error at add author Dao method: " + e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error at add author Dao method: " + e);
				}
			}
		}
		return author;
	}

	@Override
	public Author searchAuthor(BigInteger authorId) throws BookException {
		// TODO Auto-generated method stub
		String sql = "Select * from author where author_id = ?";
		Author author = new Author();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, authorId.longValue());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				author.setAuthorId(BigInteger.valueOf(resultSet.getLong("author_id")));
				author.setAuthorFirstName(resultSet.getString("author_fname"));
				author.setAuthorMiddleName(resultSet.getString("author_mname"));
				author.setAuthorLastName(resultSet.getString("author_lname"));
				author.setAuthorPhoneNo(BigInteger.valueOf(resultSet.getLong("author_phone")));
			} else {
				author = null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error at search Book Dao method: " + e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error at search author Dao method: " + e);
				}
			}
		}
		return author;
	}

	@Override
	public Integer removeAuthor(BigInteger authorId) throws BookException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> listAllAuthors() throws BookException {
		// TODO Auto-generated method stub
		String sql = "select * from author";
		List<Author> authorList = new ArrayList<Author>();
		try {
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// for select queries we have executeQuery method which returns ResultSet
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// create employee obj
				Author author = new Author();
				// get the value from resultSet and set to book obj
				author.setAuthorId(BigInteger.valueOf(resultSet.getLong("author_id")));
				author.setAuthorFirstName(resultSet.getString("author_fname"));
				author.setAuthorMiddleName(resultSet.getString("author_mname"));
				author.setAuthorLastName(resultSet.getString("author_lname"));
				author.setAuthorPhoneNo(BigInteger.valueOf(resultSet.getLong("author_phone")));
				// add the book obj to empList
				authorList.add(author);

			}
		} catch (SQLException e) {
			System.out.println(" Error at list all author Dao method : " + e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println(" Error at list all author Dao method : " + e);
				}
			}
		}
		return authorList;
	}

	@Override
	public Integer updateAuthor(Author author) throws BookException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getBookTitle(BigInteger authorId) throws BookException {
		// TODO Auto-generated method stub
		String sql = "select book_title from book join author on book.author_id = author.author_id where author.author_id = ?";
		List<String> bookList = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, authorId.longValue());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bookList.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error occured at list book title: " + e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println(" Error at list all book title Dao method : " + e);
				}
			}
		}

		return bookList;
	}

	@Override
	public Integer updateBookPrice(BigDecimal price, String authorFirstName) throws BookException {
		String sql = "update book set book_price = ? where book_ISBN in (select book_ISBN from (Select Distinct book.book_ISBN from book join author on book.author_id = author.author_id where author.author_fname = ?) as c)";
		Integer output = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, price.longValue());
			preparedStatement.setString(2, authorFirstName);
			output = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(" Error at list all book title Dao method : " + e);
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					System.out.println(" Error at list all book title Dao method : " + e);
				}
			}
		}
		return output;
	}

}
