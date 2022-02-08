package sait.bms.problemdomain;

/**
 * 
 * Class description for a Periodical object.
 * 
 * @author Mahdiyeh Abbaspour
 *
 *         7:48:50 p.m.Feb. 4, 2022
 */
public class Periodical extends Book {

	private char frequency;

	/**
	 * Creates a Periodical object with the default values
	 */
	public Periodical() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a Periodical object providing the ISBN, call number, available,
	 * total, title and with the default values of frequency.
	 * 
	 * @param isbn       ISBN
	 * @param callNumber call number
	 * @param available  available
	 * @param total      total
	 * @param title      title
	 */
	public Periodical(long isbn, String callNumber, int available, int total, String title) {
		super(isbn, callNumber, available, total, title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a Periodical object providing the ISBN, call number, available,
	 * total, title and frequency.
	 * 
	 * @param isbn       ISBN
	 * @param callNumber call number
	 * @param available  available
	 * @param total      total
	 * @param title      title
	 * @param frequency  frequency
	 */
	public Periodical(long isbn, String callNumber, int available, int total, String title, char frequency) {
		super(isbn, callNumber, available, total, title);
		this.frequency = frequency;
	}

	/**
	 * Returns the frequency.
	 * 
	 * @return the frequency
	 */
	public char getFrequency() {
		return frequency;
	}

	/**
	 * According to the character saved in frequency, the full name of the frequency
	 * is returned
	 * 
	 * @return String containing the full name of the frequency
	 */
	public String getLongFrequency() {
		switch (Character.toUpperCase(frequency)) {
		case 'D':
			return "Daily";
		case 'W':
			return "Weekly";
		case 'M':
			return "Monthly";
		case 'B':
			return "Bi-monthly";
		case 'Q':
			return "Quarterly";
		default:
			return ("Wrong type of format entred.");
		}

	}

	/**
	 * Sets the frequency to the frequency provided.
	 * 
	 * @param frequency the frequency to set
	 */
	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}
	
	
	/**
	 * 
	 * @return String appropriate for printing the values in the books.txt file
	 */
	public String toStringPrint() {
		return super.getIsbn() + ";" + super.getCallNumber() + ';' + super.getAvailable() + ';' + super.getTotal() + ';'
				+ super.getTitle() + ';' + getFrequency();
		
		
	}


	@Override
	public String toString() {
		return "ISBN:                 " + super.getIsbn() + "\r\n" + "Call Number:          " + super.getCallNumber()
		+ "\r\n" + "Available:            " + super.getAvailable() + "\r\n" + "Total:                "
		+ super.getTotal() + "\r\n" + "Title:                " + super.getTitle() + "\r\n"
		+ "Frequency:            " + getLongFrequency() + "\r\n";

	}

}
