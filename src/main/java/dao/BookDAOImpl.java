package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;

import javax.sql.DataSource;

public class BookDAOImpl implements IBookDao {
	private final static String INSERT_PERSON = "insert into book (idBOOK, BOOKNAME, AUTHORNAME,PUBLİSHİNGHOUSE,BOOKTYPE) values (?, ?, ?,?,?)";
	private final static String SELECT_BYID = "select * from book where idBOOK=?";
	private final static String ALL_SELECT = "select * from book";
	private final static String UPDATE_PERSON = "update book set BOOKNAME=? , AUTHORNAME=? , PUBLİSHİNGHOUSE=?, BOOKTYPE=? where idBOOK=?";
	private final static String DELETE_PERSON = "delete from book where idBOOK=?";
	private final static String DELETE_PERSON_ALL = "delete from book";

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	public void insert(Book book) {

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSON);
			preparedStatement.setInt(1, book.getId());
			preparedStatement.setString(2, book.getBookName());
			preparedStatement.setString(3, book.getAuthorName());
			preparedStatement.setString(4, book.getPublsihingHouse());
			preparedStatement.setString(5, book.getBookType());
			preparedStatement.executeUpdate();
			preparedStatement.close();

			// logging
			System.out.println("Book is inserted..." + book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public Book getBookById(int id) {
		Book book = null;
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BYID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String bookName = resultSet.getString("bookName");
				String authorName = resultSet.getString("authorName");
				String publishingHouse = resultSet.getString("publishingHouse");
				String bookType = resultSet.getString("bookType");
				book = new Book(id, bookName, authorName, publishingHouse,bookType);

				// logging
				System.out.println("Book is found..." + book);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;

	}

	
	public List<Book> getAllBooks() {

		List<Book> bookList = new ArrayList<Book>();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(ALL_SELECT);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("idBOOK");
				String bookName = resultSet.getString("bookName");
				String authorName = resultSet.getString("authorName");
				String publishingHouse = resultSet.getString("publishingHouse");
				String bookType = resultSet.getString("bookType");
				Book book = new Book(id, bookName, authorName, publishingHouse,bookType);
				bookList.add(book);
			}
			// logging
			System.out.println("Book list...");
			for (Book book : bookList) {
				System.out.println(book);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bookList;

	}

	
	public void update(Book book) {

		try {

			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSON);
			preparedStatement.setString(1, book.getBookName());
			preparedStatement.setString(2, book.getAuthorName());
			preparedStatement.setString(3,book.getPublsihingHouse());
			preparedStatement.setString(4,book.getBookType());
			preparedStatement.setInt(5, book.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();

			// logging
			System.out.println("Book is updated..." + book);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(int id) {

		try {

			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSON);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();

			// logging
			System.out.println("Book is deleted... Id : " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void deleteAllBooks() {
		try {

			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSON_ALL);
			preparedStatement.executeUpdate();
			preparedStatement.close();

			// logging
			System.out.println("All Books are deleted...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
