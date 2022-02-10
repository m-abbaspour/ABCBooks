package sait.bms.problemdomain;

/**
 * 
 * Class description for a CookBook object.
 * 
 * @author Mahdiyeh Abbaspour
 *
 *         7:48:50 p.m.Feb. 4, 2022
 */
public class Cookbook extends Book {

	private String publisher;
	private char diet;

	/**
	 * Creates a CookBook object with the default values
	 */
	public Cookbook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a CookBook object providing the ISBN, call number, available, total,
	 * title and with the default values of the publisher and diet
	 * 
	 * @param isbn       ISBN
	 * @param callNumber call number
	 * @param available  available
	 * @param total      total
	 * @param title      title
	 */
	public Cookbook(long isbn, String callNumber, int available, int total, String title) {
		super(isbn, callNumber, available, total, title);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a CookBook object providing ISBN, call number, available, total,
	 * title, publisher, diet
	 * 
	 * @param isbn       ISBN
	 * @param callNumber call number
	 * @param available  available
	 * @param total      total
	 * @param title      title
	 * @param publisher  publisher
	 * @param diet       diet
	 */
	public Cookbook(long isbn, String callNumber, int available, int total, String title, String publisher, char diet) {
		super(isbn, callNumber, available, total, title);
		this.publisher = publisher;
		this.diet = diet;
	}

	/**
	 * Returns the publisher.
	 * 
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * Sets the publisher to the publisher provided.
	 * 
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * Returns the diet.
	 * 
	 * @return the diet
	 */
	public char getDiet() {
		return diet;
	}

	/**
	 * According to the character saved in diet, the full name of the diet is
	 * returned
	 * 
	 * @return String containing the full name of the diet
	 */
	public String getLongDiet() {
		switch (Character.toUpperCase(diet)) {
		case 'D':
			return "Diabetic";
		case 'V':
			return "Vegetarian";
		case 'G':
			return "Gluten-free";
		case 'I':
			return "International";
		case 'N':
			return "None";
		default:
			return ("Wrong type of format entred.");
		}
	}


	/**
	 * Sets the diet to the diet provided.
	 * 
	 * @param diet the diet to set
	 */
	public void setDiet(char diet) {
		this.diet = diet;
	}
	

	/**
	 * 
	 * @return String appropriate for printing the values in the books.txt file
	 */
	@Override
	public String toStringPrint() {
		return super.getIsbn() + ";" + super.getCallNumber() + ';' + super.getAvailable() + ';' + super.getTotal() + ';'
				+ super.getTitle() + ';' + getPublisher() + ';' + getDiet();
	}
	

	@Override
	public String toString() {
		
		return "ISBN:                 " + super.getIsbn() + "\r\n" + "Call Number:          " + super.getCallNumber()
				+ "\r\n" + "Available:            " + super.getAvailable() + "\r\n" + "Total:                "
				+ super.getTotal() + "\r\n" + "Title:                " + super.getTitle() + "\r\n"
				+ "Publisher:            " + getPublisher() + "\r\n" + "Diet:                 " + getLongDiet()
				+ "\r\n";
	}

}
