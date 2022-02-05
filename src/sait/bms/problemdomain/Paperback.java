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

	public void setGenre(char genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Paperback [author=" + author + ", year=" + year + ", genre=" + genre + ", toString()="
				+ super.toString() + "]";
	}

}
