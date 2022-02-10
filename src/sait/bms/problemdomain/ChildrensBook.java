/**
 * 
 */
package sait.bms.problemdomain;

/**
 * 
 * Class description for a CookBook object.
 * 
 * @author Mahdiyeh Abbaspour
 *
 *         7:48:50 p.m.Feb. 4, 2022
 */
public class ChildrensBook extends Book {

	private String author;
	private char format;

	/**
	 * Creates a ChildrensBook object with the default values
	 */
	public ChildrensBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a CookBook object providing the ISBN, call number, available, total,
	 * title and with the default values of the author and format
	 * 
	 * @param isbn       ISBN
	 * @param callNumber call number
	 * @param available  available
	 * @param total      total
	 * @param title      title
	 */
	public ChildrensBook(long isbn, String callNumber, int available, int total, String title) {
		super(isbn, callNumber, available, total, title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a CookBook object providing the ISBN, call number, available, total,
	 * title, publisher and diet
	 * 
	 * @param isbn       ISBN
	 * @param callNumber call number
	 * @param available  available
	 * @param total      total
	 * @param title      title
	 * @param author     author
	 * @param format     format
	 */
	public ChildrensBook(long isbn, String callNumber, int available, int total, String title, String author,
			char format) {
		super(isbn, callNumber, available, total, title);
		this.author = author;
		this.format = format;
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
	 * Returns the format.
	 * 
	 * @return the format
	 */
	public char getFormat() {
		return format;
	}

	/**
	 * According to the character saved in format, the full name of the format is
	 * returned
	 * 
	 * @return String containing the full name of the format
	 */
	public String getLongFormat() {
		switch (Character.toUpperCase(format)) {
		case 'P':
			return "Picture book";
		case 'E':
			return "Early Readers";
		case 'C':
			return "Chapter book";
		default:
			return ("Wrong type of format entred.");
		}

	}

	/**
	 * Sets the format to the format provided.
	 * 
	 * @param format the format to set
	 */
	public void setFormat(char format) {
		this.format = format;
	}
	
	/**
	 * 
	 * @return String appropriate for printing the values in the books.txt file
	 */
	@Override
	public String toStringPrint() {
		return super.getIsbn() + ";" + super.getCallNumber() + ';' + super.getAvailable() + ';' + super.getTotal() + ';'
				+ super.getTitle() + ';' + getAuthor() + ';' + getFormat();

	}

	@Override
	public String toString() {
		return "ISBN:                 " + super.getIsbn() + "\r\n" + "Call Number:          " + super.getCallNumber()
		+ "\r\n" + "Available:            " + super.getAvailable() + "\r\n" + "Total:                "
		+ super.getTotal() + "\r\n" + "Title:                " + super.getTitle() + "\r\n"
		+ "Author:               " + getAuthor() + "\r\n" + "Format:               " + getLongFormat() + "\r\n";
	}

}
