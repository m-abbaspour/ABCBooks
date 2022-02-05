package sait.bms.problemdomain;

/**
 * @author abbas
 *
 */
public class Periodical extends Book {

	private char frequency;


	public Periodical() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Periodical(long isbn, String callNumber, int available, int total, String title) {
		super(isbn, callNumber, available, total, title);
		// TODO Auto-generated constructor stub
	}

	public Periodical(long isbn, String callNumber, int available, int total, String title, char frequency) {
		super(isbn, callNumber, available, total, title);
		this.frequency = frequency;
	}
	
	public char getFrequency() {
		return frequency;
	}

	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}


	@Override
	public String toString() {
		return "Periodical [frequency=" + frequency + ", toString()=" + super.toString() + "]";
	}

}
