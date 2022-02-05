package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrensBook;
import sait.bms.problemdomain.Cookbook;
import sait.bms.problemdomain.Paperback;
import sait.bms.problemdomain.Periodical;

/**
 * checkoutBook ! 
 * findBooksbyTitle ! 
 * displayBooksbyType 
 * produceRandomBookList
 * loadBooksListFromFile 
 * menu 
 * SaveAndExit
 * 
 * @author abbas
 *
 *         5:56:19 a.m.Feb. 5, 2022
 */
public class Manager {

	ArrayList<Book> books = new ArrayList<Book>();
	private final static String FILENAME = "res/books.txt";

	public Manager() throws FileNotFoundException {
		loadBooksListFromFile();
		SaveAndExit();
	}

	/**
	 * Displays the menu of options
	 * 
	 * @return option chosen by user
	 */
	public int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Welcome in ABC Book Company: How May We Assist You?\r\n" + "1	Checkout Book\r\n"
				+ "2	Find Books by Title\r\n" + "3	Display Books by Type\r\n" + "4	Produce Random Book List\r\n"
				+ "5	Save & Exit\r\n" + "\r\n" + "Enter option: " + "");

		int option = sc.nextInt();
		sc.close();
		return option;
	}

	/**
	 * Loads the books from an input file into a list.
	 * 
	 * @throws FileNotFoundException if file cannot be found.
	 * @return Arraylist loaded from the txt file
	 */
	public ArrayList<Book> loadBooksListFromFile() throws FileNotFoundException {
		Scanner in = new Scanner(new File(FILENAME));
		while (in.hasNext()) {
			String line = in.nextLine();
			String[] fields = line.split(";");
			char lastChar = fields[0].charAt(12);
			switch (lastChar) {
			case '0':
			case '1':
				// ChildrensBook(long isbn 0, String callNumber 1, int available 2 , int total
				// 3, String title 4, String author 5,
				// char format 6)
				books.add(new ChildrensBook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[0].charAt(0)));
				break;
			case '2':
			case '3':
				// Cookbook(long isbn 0, String callNumber 1, int available 2, int total 3,
				// String title 4 , String publisher 5, char diet 6)
				books.add(new Cookbook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[0].charAt(0)));
				break;
			case '4':
			case '5':
			case '6':
			case '7':
				// Paperback(long isbn 0, String callNumber 1, int available 2, int total 3,
				// String title 4, String author 5, int year 6,
				// char genre 7)
				books.add(new Paperback(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]),
						fields[7].charAt(0)));
				break;
			case '8':
			case '9':
				// Periodical(long isbn 0, String callNumber 1, int available 2, int total 3,
				// String title 4, char frequency 5)
				books.add(new Periodical(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5].charAt(0)));
				break;
			}
		}
		in.close();
		return books;
	}

	public void SaveAndExit() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(FILENAME);
		for (Book book : books) {
			if(book instanceof ChildrensBook) {
				//how to write ChildrensBook
				printWriter.print(book.getIsbn());
				printWriter.print(';');
				printWriter.print(book.getCallNumber());
				printWriter.print(';');
				printWriter.print(book.getAvailable());
				printWriter.print(';');
				printWriter.print(book.getTotal());
				printWriter.print(';');
				printWriter.print(book.getTitle());
				printWriter.print(';');
				printWriter.print(((ChildrensBook)book).getAuthor());
				printWriter.print(';');
				printWriter.print(((ChildrensBook)book).getFormat());
				
			} else if (book instanceof Cookbook) {
				//how to write cook book
				printWriter.print(book.getIsbn());
				printWriter.print(';');
				printWriter.print(book.getCallNumber());
				printWriter.print(';');
				printWriter.print(book.getAvailable());
				printWriter.print(';');
				printWriter.print(book.getTotal());
				printWriter.print(';');
				printWriter.print(book.getTitle());
				printWriter.print(';');
				printWriter.print(((Cookbook)book).getPublisher());
				printWriter.print(';');
				printWriter.print(((Cookbook)book).getDiet());
			} else if(book instanceof Paperback) {
				//how to write Paperback
				printWriter.print(book.getIsbn());
				printWriter.print(';');
				printWriter.print(book.getCallNumber());
				printWriter.print(';');
				printWriter.print(book.getAvailable());
				printWriter.print(';');
				printWriter.print(book.getTotal());
				printWriter.print(';');
				printWriter.print(book.getTitle());
				printWriter.print(';');
				printWriter.print(((Paperback)book).getAuthor());
				printWriter.print(';');
				printWriter.print(((Paperback)book).getYear());
				printWriter.print(';');
				printWriter.print(((Paperback)book).getGenre());
			} else  {
				//how to write Periodical
				printWriter.print(book.getIsbn());
				printWriter.print(';');
				printWriter.print(book.getCallNumber());
				printWriter.print(';');
				printWriter.print(book.getAvailable());
				printWriter.print(';');
				printWriter.print(book.getTotal());
				printWriter.print(';');
				printWriter.print(book.getTitle());
				printWriter.print(';');
				printWriter.print(((Periodical)book).getFrequency());

			}
			
			printWriter.println();
		}
		printWriter.close();
	}
	public void CheckoutBook() {

		// prompt the user to enter the ISBN of the book
		System.out.println("Enter ISBN of book: ");
		Scanner sc = new Scanner(System.in);
		Long isbn = sc.nextLong();
		sc.close();
		// find the book using the ISBN the user entered
		for (Book book : books) {
			if (book.getIsbn() == isbn) {
				// Periodical books cannot be checked out
				if (book instanceof Periodical) {
					System.out.println("Periodical books cannot be checked out.");
					return;
				} else {
					// check if the book is available
					if (book.getAvailable() > 0) {
						// decrease the available book by 1
						book.setAvailable(book.getAvailable() - 1);
						System.out.println("The book " + book.getTitle() + " was checked out.");
						System.out.println("It can be located using a call number: " + book.getCallNumber());
					} else {
						System.out.println("The book " + isbn + " is not available.");
					}
				}

			} else {
				System.out.println(
						"The book with an ISBN of " + isbn + " was not found. \nCheck ISBN or try a different book!");
				return;
			}
		}
	}

	public void findBooksbyTitle() {
		System.out.println("Enter title to search for: ");
		Scanner sc = new Scanner(System.in);
		String search = sc.next();

		for (Book book : books) {
			if (book.getTitle().toLowerCase().contains(search.toLowerCase())) {
				System.out.println("Matching books:");
				System.out.println("ISBN:		      " + book.getIsbn());

			}
		}
		sc.close();
	}

	public void displayBooksbyType() {

		Scanner sc = new Scanner(System.in);

		System.out.println("#	Type\r\n" + "1	Children's Books\r\n" + "2	Cookbooks\r\n" + "3	Paperbacks\r\n"
				+ "4	Periodicals\r\n" + "");
		System.out.println("Enter type of book: ");
		int typeOfBook = sc.nextInt();
		
		switch (typeOfBook) {
		
		case 1:
			//1	Children's Books
			System.out.println(
					"Enter a format ( P for Picture book, E for Early Readers, or C for Chapter book): ");
			String format =  sc.next();
			System.out.println("\nMatching books:");
			for (Book book : books) {
				if (book instanceof ChildrensBook) {
					if (((ChildrensBook) book).getFormat() == format.toUpperCase().charAt(0)) {
						
						switch(format.charAt(0)) {
						case 'P': format = "Picture book"; break;
						case 'E': format = "Early Readers"; break;
						case 'C': format = "Chapter book"; break;
						default: System.out.println("Wrong type of format entred.");return;

						}

						System.out.printf("ISBN:		      %d\r\n"
								+ "Call Number:	%s\r\n"
								+ "Available:	      %d\r\n"
								+ "Total:		%d\r\n"
								+ "Title:		%s\r\n"
								+ "Frequency:	      %s\r\n"
								+ "", 
								book.getIsbn(),
								book.getCallNumber(),
								book.getAvailable(),
								book.getTotal(),
								book.getTitle(),
								format);
					}
				}
			}
			break;

		case 2:

			break;
		case 3:

			break;
		case 4:
			//4	Periodicals
			System.out.println(
					"Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly): ");
			String frequency =  sc.next();
			System.out.println("\nMatching books:");
			for (Book book : books) {
				if (book instanceof Periodical) {
					if (((Periodical) book).getFrequency() == frequency.toUpperCase().charAt(0)) {
						
						switch(frequency.charAt(0)) {
						case 'D': frequency = "Daily"; break;
						case 'W': frequency = "Weekly"; break;
						case 'M': frequency = "Monthly"; break;
						case 'B': frequency = "Bi-monthly"; break;
						case 'Q': frequency = "Quarterly"; break;
						default: System.out.println("Wrong type of format entred.");return;
						}

						System.out.printf("ISBN:		      %d\r\n"
								+ "Call Number:	%s\r\n"
								+ "Available:	      %d\r\n"
								+ "Total:		%d\r\n"
								+ "Title:		%s\r\n"
								+ "Frequency:	      %s\r\n"
								+ "", 
								book.getIsbn(),
								book.getCallNumber(),
								book.getAvailable(),
								book.getTotal(),
								book.getTitle(),
								frequency);
					}
				}
			}
			break;

		default:
			System.out.println("Wrong type of book entred.");
		}

		sc.close();
	}
}
