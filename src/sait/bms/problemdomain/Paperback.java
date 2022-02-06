package sait.bms.problemdomain;

/**
 * @author abbas
 *
 */
public class Paperback extends Book {

	private String author;
	private int year;
	private char genre;

	public Paperback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paperback(long isbn, String callNumber, int available, int total, String title) {
		super(isbn, callNumber, available, total, title);
		// TODO Auto-generated constructor stub
	}

	public Paperback(long isbn, String callNumber, int available, int total, String title, String author, int year,
			char genre) {
		super(isbn, callNumber, available, total, title);
		this.author = author;
		this.year = year;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public char getGenre() {
		return genre;
	}

	public String getLongGenre() {
		switch (Character.toUpperCase(genre)) {
		case 'A':
			return "Adventure";
		case 'D':
			return "Drama";
		case 'E':
			return "Education";
		case 'C':
			return "Classsic";
		case 'F':
			return "Fantasy";
		case 'S':
			return "Science Fiction";
		default:
			return ("Wrong type of format entred.");
		}
	}

	public String toStringPrint() {
		return "ISBN:                 " + super.getIsbn() + "\r\n" + "Call Number:          " + super.getCallNumber()
				+ "\r\n" + "Available:            " + super.getAvailable() + "\r\n" + "Total:                "
				+ super.getTotal() + "\r\n" + "Title:                " + super.getTitle() + "\r\n"
				+ "Author:               " + getAuthor() + "\r\n" + "Year:                 " + getYear() + "\r\n"
				+ "Genre:                " + getLongGenre() + "\r\n";
	}

	public void setGenre(char genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return super.getIsbn() + ";" + super.getCallNumber() + ';' + super.getAvailable() + ';' + super.getTotal() + ';'
				+ super.getTitle() + ';' + getAuthor() + ';' + getYear() + ';' + getGenre();
	}

}
