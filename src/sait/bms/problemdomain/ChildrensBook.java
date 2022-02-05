/**
 * 
 */
package sait.bms.problemdomain;

/**
 * @author abbas
 *
 * 3:59:19 p.m. Feb. 2, 2022
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

	public void setFormat(char format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "ChildrensBook [author=" + author + ", format=" + format + ", toString()=" + super.toString() + "]";
	}

}
