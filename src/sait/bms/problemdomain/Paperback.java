package sait.bms.problemdomain;

/**
 * Class description for Paperback object
 * @author Mahdiyeh abbaspour
 *
 * 7:48:50 a.m.Feb. 4, 2022
 */
public class Paperback extends Book {

	private String author;
	private int year;
	private char genre;

	/**
	 * Creates a Paperback object with the default values
	 */
	public Paperback() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a Paperback object providing the ISBN, call number, available, total, title and the default values of author, year and genre
	 * @param isbn ISBN
	 * @param callNumber call number
	 * @param available available
	 * @param total total 
	 * @param title title
	 */
	public Paperback(long isbn, String callNumber, int available, int total, String title) {
		super(isbn, callNumber, available, total, title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a Paperback object providing the ISBN, call number, available, total, title, author, year and genre
	 * @param isbn ISBN
	 * @param callNumber call number
	 * @param available available
	 * @param total total 
	 * @param title title
	 * @param author author
	 * @param year year
	 * @param genre genre
	 */
	public Paperback(long isbn, String callNumber, int available, int total, String title, String author, int year,
			char genre) {
		super(isbn, callNumber, available, total, title);
		this.author = author;
		this.year = year;
		this.genre = genre;
	}

	/**
	 * Returns the author.
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the author to the author provided.
	 * 
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Returns the author.
	 * 
	 * @return the author
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year to the year provided.
	 * 
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Returns the author.
	 * 
	 * @return the author
	 */
	public char getGenre() {
		return genre;
	}

	/**
	 * According to the character saved in genre, the full name of the genre is
	 * returned
	 * 
	 * @return String containing the full name of the genre
	 */
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


	/**
	 * Sets the genre to the genre provided.
	 * 
	 * @param genre the genre to set
	 */
	public void setGenre(char genre) {
		this.genre = genre;
	}

	/**
	 * 
	 * @return String appropriate for printing the values in the books.txt file
	 */
	@Override
	public String toStringPrint() {
		return super.getIsbn() + ";" + super.getCallNumber() + ';' + super.getAvailable() + ';' + super.getTotal() + ';'
				+ super.getTitle() + ';' + getAuthor() + ';' + getYear() + ';' + getGenre();
	}
	
	@Override
	public String toString() {
		return "ISBN:                 " + super.getIsbn() + "\r\n" + "Call Number:          " + super.getCallNumber()
				+ "\r\n" + "Available:            " + super.getAvailable() + "\r\n" + "Total:                "
				+ super.getTotal() + "\r\n" + "Title:                " + super.getTitle() + "\r\n"
				+ "Author:               " + getAuthor() + "\r\n" + "Year:                 " + getYear() + "\r\n"
				+ "Genre:                " + getLongGenre() + "\r\n";
	}

}
