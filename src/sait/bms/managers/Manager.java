package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrensBook;
import sait.bms.problemdomain.Cookbook;
import sait.bms.problemdomain.Paperback;
import sait.bms.problemdomain.Periodical;

/**
 * checkoutBook() findBooksbyTitle() displayBooksbyType()
 * produceRandomBookList() loadBooksListFromFile() menu() SaveAndExit()
 * 
 * @author abbas
 *
 * 5:56:19 a.m. Feb. 5, 2022
 */
public class Manager {

	ArrayList<Book> books = new ArrayList<Book>();
	private final static String FILENAME = "res/books.txt";

	//The Manager Class Constructor
	public Manager(Scanner sc) throws FileNotFoundException {
		loadBooksListFromFile();
		menu(sc);
	}

	/**
	 * Displays the menu of options
	 * 
	 * @return option chosen by user
	 * @throws FileNotFoundException
	 */
	public void menu(Scanner sc) throws FileNotFoundException {
		System.out.print("Welcome in ABC Book Company: How May We Assist You?\r\n" + "1	Checkout Book\r\n"
				+ "2	Find Books by Title\r\n" + "3	Display Books by Type\r\n" + "4	Produce Random Book List\r\n"
				+ "5	Save & Exit\r\n" + "\r\n" + "Enter option: " + "");

		int option = sc.nextInt();
		while (option != 5) {
			switch (option) {
			case 1:
				CheckoutBook(sc);
				break;
			case 2:
				findBooksbyTitle(sc);
				break;
			case 3:
				displayBooksbyType(sc);
				break;
			case 4:
				produceRandomBookList(sc);
				break;
			}
			System.out.println("Choose an option");
			option = sc.nextInt();
		}
		System.out.println("Thanks for being with us!\r\nHave a nice day!");
		SaveAndExit();
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
				// ChildrensBook
				books.add(new ChildrensBook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[6].charAt(0)));
				break;
			case '2':
			case '3':
				// Cookbook
				books.add(new Cookbook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], fields[6].charAt(0)));
				break;
			case '4':
			case '5':
			case '6':
			case '7':
				// Paperback
				books.add(new Paperback(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5], Integer.parseInt(fields[6]),
						fields[7].charAt(0)));
				break;
			case '8':
			case '9':
				// Periodical
				books.add(new Periodical(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]),
						Integer.parseInt(fields[3]), fields[4], fields[5].charAt(0)));
				break;
			}
		}
		in.close();
		return books;
	}

	

	/**
	 * allows a patron to checkout a book
	 */
	public void CheckoutBook(Scanner sc) {

		// prompt the user to enter the ISBN of the book
		System.out.println("Enter ISBN of book: ");
		Long isbn = sc.nextLong();
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
				return;
			}
		}
		System.out
				.println("The book with an ISBN of " + isbn + " was not found. \nCheck ISBN or try a different book!");
	}

	/**
	 * prompts the user patron to enter a title, performs a case-insensitive search
	 * of books that containing the inputted title, and displays them.
	 */
	public void findBooksbyTitle(Scanner sc) {
		System.out.println("Enter title to search for: ");
		String search = sc.next();
		for (Book book : books) {
			if (book.getTitle().toLowerCase().contains(search.toLowerCase())) {
				if (book instanceof ChildrensBook) {
					System.out.println(((ChildrensBook) book).toStringPrint());
				} else if (book instanceof Cookbook) {
					System.out.println(((Cookbook) book).toStringPrint());
				} else if (book instanceof Paperback) {
					System.out.println(((Paperback) book).toStringPrint());
				} else {
					System.out.println(((Periodical) book).toStringPrint());

				}
			}
		}
	}

	/**
	 * Allows a patron to view a list of books with a specific type. The user will
	 * also enter a format, diet, genre, or frequency (depending on the type of
	 * book) and the book list will be narrowed down further.
	 * 
	 * @param 
	 */
	public void displayBooksbyType(Scanner sc) {

		System.out.println("#	Type\r\n" + "1	Children's Books\r\n" + "2	Cookbooks\r\n" + "3	Paperbacks\r\n"
				+ "4	Periodicals\r\n" + "");
		System.out.println("Enter type of book: ");
		int typeOfBook = sc.nextInt();

		switch (typeOfBook) {

		case 1:
			// 1 Children's Books
			System.out.println("Enter a format ( P for Picture book, E for Early Readers, or C for Chapter book): ");
			String format = sc.next();
			System.out.println("\nMatching books:");
			for (Book book : books) {
				if (book instanceof ChildrensBook) {
					if (((ChildrensBook) book).getFormat() == format.toUpperCase().charAt(0)) {
						System.out.println(((ChildrensBook) book).toStringPrint());
					}
				}
			}
			break;

		case 2:
			// 2 Cookbook
			System.out.println(
					"Enter a Diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None): ");
			String diet = sc.next();
			System.out.println("\nMatching books:");
			for (Book book : books) {
				if (book instanceof Cookbook) {
					if (((Cookbook) book).getDiet() == diet.toUpperCase().charAt(0)) {
						System.out.println(((Cookbook) book).toStringPrint());
					}
				}
			}
			break;
		case 3:
			// 3 Paperbacks
			// prompt the user to enter a genre
			System.out.println(
					"Enter a Genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction): ");
			String genre = sc.next();
			System.out.println("\nMatching books:");
			for (Book book : books) {
				if (book instanceof Paperback) {
					if (((Paperback) book).getGenre() == genre.toUpperCase().charAt(0)) {
						System.out.println(((Paperback) book).toStringPrint());
					}
				}
			}
		case 4:
			// 4 Periodicals
			System.out.println(
					"Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly): ");
			String frequency = sc.next();
			System.out.println("\nMatching books:");
			for (Book book : books) {
				if (book instanceof Periodical) {
					if (((Periodical) book).getFrequency() == frequency.toUpperCase().charAt(0)) {
						System.out.println(((Periodical) book).toStringPrint());
					}
				}
			}
			break;

		default:
			System.out.println("Wrong type of book entred.");
		}

	}
	
	/**
	 * 
	 * @param sc
	 */
	public void produceRandomBookList(Scanner sc) {
		// TODO Auto-generated method stub
		Collections.shuffle(books);
		System.out.print("Enter number of books: ");
		int randomBooks = sc.nextInt();
		for(int i=0; i<randomBooks; i++) {
			if (books.get(i) instanceof ChildrensBook) {
				System.out.println(((ChildrensBook) books.get(i)).toStringPrint());
			} else if (books.get(i) instanceof Cookbook) {
				System.out.println(((Cookbook) books.get(i)).toStringPrint());
			} else if (books.get(i) instanceof Paperback) {
				System.out.println(((Paperback) books.get(i)).toStringPrint());
			} else {
				System.out.println(((Periodical) books.get(i)).toStringPrint());
			}
		}
	}
	
	/**
	 * Saves the changes done throughout the program
	 * 
	 * @throws FileNotFoundException if the file containing the books was not found
	 */
	public void SaveAndExit() throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter(FILENAME);
		for (Book book : books) {
			printWriter.print(book.toString());
			printWriter.println();
		}
		printWriter.close();
	}
}
