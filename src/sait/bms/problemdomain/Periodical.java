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

	public String toStringPrint() {
		return "ISBN:                 " + super.getIsbn() + "\r\n" + "Call Number:          " + super.getCallNumber()
				+ "\r\n" + "Available:            " + super.getAvailable() + "\r\n" + "Total:                "
				+ super.getTotal() + "\r\n" + "Title:                " + super.getTitle() + "\r\n" + "Frequency:            "
				+ getLongFrequency() + "\r\n";
	}

	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}


	@Override
	public String toString() {
		return
		super.getIsbn()+
		";"+
		super.getCallNumber()+
		';'+
		super.getAvailable()+
		';'+
		super.getTotal()+
		';'+
		super.getTitle()+
		';'+
		getFrequency();

	}

}
