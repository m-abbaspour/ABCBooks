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

	public void setDiet(char diet) {
		this.diet = diet;
	}

	@Override
	public String toString() {
		return "Cookbook [publisher=" + publisher + ", diet=" + diet + ", toString()=" + super.toString() + "]";
	}

}
