package dao;

import java.util.List;

import model.Book;

public interface IBookDao {
	public void insert(Book book);

	public Book getBookById(int id);

	public List<Book> getAllBooks();

	public void update(Book book);

	public void delete(int id);

	public void deleteAllBooks();
}
