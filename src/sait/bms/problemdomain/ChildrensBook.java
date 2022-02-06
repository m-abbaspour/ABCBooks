/**
 * 
 */
package sait.bms.problemdomain;

/**
 * @author abbas
 *
 *         3:59:19 p.m. Feb. 2, 2022
 */
public class ChildrensBook extends Book {

	private String author;
	private char format;

	public ChildrensBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChildrensBook(long isbn, String callNumber, int available, int total, String title) {
		super(isbn, callNumber, available, total, title);
		// TODO Auto-generated constructor stub
	}

	public ChildrensBook(long isbn, String callNumber, int available, int total, String title, String author,
			char format) {
		super(isbn, callNumber, available, total, title);
		this.author = author;
		this.format = format;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public char getFormat() {
		return format;
	}

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

	public String toStringPrint() {
		return "ISBN:                 " + super.getIsbn() + "\r\n" + "Call Number:          " + super.getCallNumber()
				+ "\r\n" + "Available:            " + super.getAvailable() + "\r\n" + "Total:                "
				+ super.getTotal() + "\r\n" + "Title:                " + super.getTitle() + "\r\n"
				+ "Author:               " + getAuthor() + "\r\n" + "Format:               " + getLongFormat() + "\r\n";
	}

	public void setFormat(char format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return super.getIsbn() + ";" + super.getCallNumber() + ';' + super.getAvailable() + ';' + super.getTotal() + ';'
				+ super.getTitle() + ';' + getAuthor() + ';' + getFormat();

	}

}
