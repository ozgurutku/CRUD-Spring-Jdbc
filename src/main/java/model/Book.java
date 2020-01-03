package model;

public class Book {

	private int id;
	private String bookName;
	private String authorName;
	private String publsihingHouse;
	private String bookType;

	public Book(int id, String bookName, String authorName, String publsihingHouse, String bookType) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publsihingHouse = publsihingHouse;
		this.bookType = bookType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublsihingHouse() {
		return publsihingHouse;
	}

	public void setPublsihingHouse(String publsihingHouse) {
		this.publsihingHouse = publsihingHouse;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", publsihingHouse="
				+ publsihingHouse + ", bookType=" + bookType + "]";
	}

}
