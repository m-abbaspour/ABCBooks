
package sait.bms.problemdomain;


/**
 * Class description for Book object
 * @author Mahdiyeh abbaspour
 *
 * 7:48:50 a.m.Feb. 4, 2022
 */
public class Book {

	private long isbn;
	private String callNumber;
	private int available;
	private int total;
	private String title;

	/**
	 * Creates book with default values
	 */
	public Book() {
		super();
	}

	/**
	 * Creates a book object providing the ISBN, callNumber, available, total and title
	 * @param isbn ISBN of the book
	 * @param callNumber call number to locate a book after checking it out
	 * @param available number of available book to checkout
	 * @param total total number of the book
	 * @param title of the book
	 */
	public Book(long isbn, String callNumber, int available, int total, String title) {
		super();
		this.isbn = isbn;
		this.callNumber = callNumber;
		this.available = available;
		this.total = total;
		this.title = title;
	}

	/**
	 * returns the ISBN of the book
	 * @return the ISBN of the book
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * sets the ISBN to the ISBN provided
	 * @param isbn the ISBN to set
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	/**
	 * returns the call number of the book
	 * @return the call number 
	 */
	public String getCallNumber() {
		return callNumber;
	}

	/**
	 * seta the call number to the call number provided
	 * @param callNumber the call number to set
	 */
	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	/**
	 * Returns the available number of books left
	 * @return the available 
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * Sets the Available to the available provided
	 * 
	 * @param available the available to set
	 */
	public void setAvailable(int available) {
		this.available = available;
	}

	/**
	 * Returns the total
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Sets the total to the total provided
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * Returns the title
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title to the title provided
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	
	/**
	 * 
	 * @return String appropriate for printing the values in the books.txt file
	 */
	public String toStringPrint() {
		return getIsbn() + ";" + getCallNumber() + ';' + getAvailable() + ';' + getTotal() + ';'
				+ getTitle();
	}
	
	
	@Override
	public String toString() {
		return "ISBN:                 " + getIsbn() + "\r\n" + "Call Number:          " + getCallNumber()
				+ "\r\n" + "Available:            " + getAvailable() + "\r\n" + "Total:                "
				+ getTotal() + "\r\n" + "Title:                " + getTitle() + "\r\n";
	}

	
}
