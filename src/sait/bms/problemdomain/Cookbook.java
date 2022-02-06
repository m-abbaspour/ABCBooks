package sait.bms.problemdomain;

/**
 * @author abbas
 *
 */
public class Cookbook extends Book {

	private String publisher;
	private char diet;

	public Cookbook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cookbook(long isbn, String callNumber, int available, int total, String title) {
		super(isbn, callNumber, available, total, title);
		// TODO Auto-generated constructor stub
	}

	public Cookbook(long isbn, String callNumber, int available, int total, String title, String publisher, char diet) {
		super(isbn, callNumber, available, total, title);
		this.publisher = publisher;
		this.diet = diet;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public char getDiet() {
		return diet;
	}

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

	public String toStringPrint() {
		return "ISBN:                 " + super.getIsbn() + "\r\n" + "Call Number:          " + super.getCallNumber()
				+ "\r\n" + "Available:            " + super.getAvailable() + "\r\n" + "Total:                "
				+ super.getTotal() + "\r\n" + "Title:                " + super.getTitle() + "\r\n"
				+ "Publisher:            " + getPublisher() + "\r\n" + "Diet:                 " + getLongDiet() + "\r\n";
	}

	public void setDiet(char diet) {
		this.diet = diet;
	}

	@Override
	public String toString() {
		return super.getIsbn() + ";" + super.getCallNumber() + ';' + super.getAvailable() + ';' + super.getTotal() + ';'
				+ super.getTitle() + ';' + getPublisher() + ';' + getDiet();
	}

}
