package test;

import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Book;
import dao.*;

public class SpringJDBCTest {
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		IBookDao bService = ctx.getBean(IBookDao.class);

		// create person object
		Book book1 = new Book(1, "Bilinmeyen Bir Kadının Mektubu", "Stefan Zweig","İş Bankası yayınları","Alman Edebiyatı");

		// insert
		bService.insert(book1);

		// find
		bService.getBookById(1);

		// update
		book1.setBookName("Satranç");
		bService.update(book1);

		// delete
		bService.delete(1);

		Book book2 = new Book(2, "İnsan ne ile yaşar", "Lev Tolstoy","İş Bankası yayınları","Rus Edebiyatı");
		Book book3 = new Book(3, "Kumarbaz", "Dostoyevski","Can yayınları","Rus Edebiyatı");

		bService.insert(book2);
		bService.insert(book3);

		// getAllPersons
		bService.getAllBooks();

		// deleteAllPersons
		bService.deleteAllBooks();

		((ClassPathXmlApplicationContext) ctx).close();

	}
}
