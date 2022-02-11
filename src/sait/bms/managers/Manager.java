package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrensBook;
import sait.bms.problemdomain.Cookbook;
import sait.bms.problemdomain.Paperback;
import sait.bms.problemdomain.Periodical;

/**
 * Manager class to display the following: Displays the menu of options Checkout
 * a Book Find Books by Title Display Books by Type Produces a Random Book List
 * Saves changes & Exits the program
 * 
 * @author Mahdiyeh abbaspour
 *
 *         5:56:19 a.m. Feb. 5, 2022
 */
public class Manager {

	private ArrayList<Book> books = new ArrayList<Book>();
	private final static String FILENAME = "res/books.txt";

	/**
	 * Creates a Manger object.
	 * 
	 * @param sc which is passed to the menu()
	 * @throws FileNotFoundException if there are any problems opening file.
	 */
	public Manager(Scanner sc) throws FileNotFoundException {
		loadBooksListFromFile();
		menu(sc);
	}

	/**
	 * Displays the menu of options
	 * 
	 * @param sc standard scanner object, which is passed to all of the methods
	 * @throws FileNotFoundException if the file cannot be found
	 */
	public void menu(Scanner sc) throws FileNotFoundException {
		int option = 0;
		while (option != 5) {
			try {
				System.out.print("\r\nWelcome in ABC Book Company: How May We Assist You?\r\n" + "1	Checkout Book\r\n"
						+ "2	Find Books by Title\r\n" + "3	Display Books by Type\r\n"
						+ "4	Produce Random Book List\r\n" + "5	Save & Exit\r\n" + "\r\n" + "Enter option: " + "");

				option = sc.nextInt();
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
				case 5:
					break;
				default:
					System.out.println("Wrong type of input. try again.");	

				}
			} catch (Exception e) {
				sc.next();
				if (e instanceof InputMismatchException) {
				   System.out.println("Wrong type of input. try again.");
				} else {
					System.out.println("An unknown Exception Occure. please report it. :"+e.getMessage());
				}
			}
		}
		System.out.println("Thanks for being with us!\r\nHave a nice day!");
		SaveAndExit();
	}

	/**
	 * Loads the books from an input file into a list.
	 * 
	 * @throws FileNotFoundException if file cannot be found.
	 * @return Arraylist loaded from the txt file containing the books
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
	 * Allows a patron to checkout a book
	 * 
	 * @param sc to read the ISBN of the book from the reader
	 */
	public void CheckoutBook(Scanner sc) {

		// prompt the user to enter the ISBN of the book
		System.out.print("Enter ISBN of book: ");
		String isbnString=sc.next();
		while (isbnString.length()!=13 || !isbnString.matches("(\\d*)")) {
			System.out.println("Wrong ISBN Enterd! please try again.");
			isbnString=sc.next();
		}
		Long isbn = new Long(isbnString);
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
	 * Prompts the user patron to enter a title, performs a case-insensitive search
	 * of books that containing the entered title, and displays them.
	 * 
	 * @param sc to read the title of the book from the user
	 */
	public void findBooksbyTitle(Scanner sc) {
		System.out.print("Enter title to search for: ");
		String search = sc.next();
		for (Book book : books) {
			if (book.getTitle().toLowerCase().contains(search.toLowerCase())) {
				System.out.println(book.toString());
			}
		}
	}

	/**
	 * Allows a patron to view a list of books with a specific type. The user will
	 * also enter a format, diet, genre, or frequency (depending on the type of
	 * book) and the book list will be narrowed down further.
	 * 
	 * @param sc to read the inputs from the user
	 */
	public void displayBooksbyType(Scanner sc) {

		System.out.println("#	Type\r\n" + "1	Children's Books\r\n" + "2	Cookbooks\r\n" + "3	Paperbacks\r\n"
				+ "4	Periodicals\r\n" + "");
		System.out.print("Enter type of book: ");
		String typeOfBook = sc.next();

		switch (typeOfBook) {

		case "1":
			// 1 Children's Books
			System.out.println("Enter a format ( P for Picture book, E for Early Readers, or C for Chapter book): ");
			String format = sc.next();
			while (!format.equalsIgnoreCase("p") 
					&&!format.equalsIgnoreCase("e") 
					&&!format.equalsIgnoreCase("c")){
				System.out.println("wrong type entred. Please try again.");
				format = sc.next();
			}
			System.out.println("\nMatching books:");
			for (Book book : books) {
				if (book instanceof ChildrensBook) {
					if (((ChildrensBook) book).getFormat() == format.toUpperCase().charAt(0)) {
						System.out.println(((ChildrensBook) book).toString());
					}
				}
			}
			break;

		case "2":
			// 2 Cookbook
			System.out.println(
					"Enter a Diet (D for Diabetic, V for Vegetarian, G for Gluten-free, I for International, or N for None): ");
			String diet = sc.next();
			while (!diet.equalsIgnoreCase("v") 
					&&!diet.equalsIgnoreCase("d") 
					&&!diet.equalsIgnoreCase("g") 
					&&!diet.equalsIgnoreCase("i") 
					&&!diet.equalsIgnoreCase("n")){
				System.out.println("wrong type entred. Please try again.");
				diet = sc.next();
			}
			System.out.println("\nMatching books:");
			for (Book book : books) {
				if (book instanceof Cookbook) {
					if (((Cookbook) book).getDiet() == diet.toUpperCase().charAt(0)) {
						System.out.println(((Cookbook) book).toString());
					}
				}
			}
			break;
		case "3":
			// 3 Paperbacks
			System.out.println(
					"Enter a Genre (A for Adventure, D for Drama, E for Education, C for Classic, F for Fantasy, or S for Science Fiction): ");
			String genre = sc.next();
			while (!genre.equalsIgnoreCase("a") 
					&&!genre.equalsIgnoreCase("d") 
					&&!genre.equalsIgnoreCase("e") 
					&&!genre.equalsIgnoreCase("c") 
					&&!genre.equalsIgnoreCase("s") 
					&&!genre.equalsIgnoreCase("f")) {
				System.out.println("wrong type entred. Please try again.");
				genre = sc.next();
			}
			System.out.println("\nMatching books:");
			for (Book book : books) {
				if (book instanceof Paperback) {
					if (((Paperback) book).getGenre() == genre.toUpperCase().charAt(0)) {
						System.out.println(((Paperback) book).toString());
					}
				}
			}
			break;
		case "4":
			// 4 Periodicals
			System.out.println(
					"Enter a frequency (D for Daily, W for Weekly, M for Monthly, B for Biweekly, or Q for Quarterly): ");
			String frequency = sc.next();
			while (!frequency.equalsIgnoreCase("d") 
					&&!frequency.equalsIgnoreCase("w") 
					&&!frequency.equalsIgnoreCase("m") 
					&&!frequency.equalsIgnoreCase("b") 
					&&!frequency.equalsIgnoreCase("q")) {
				System.out.println("wrong type entred. Please try again.");
				frequency = sc.next();
			}
			System.out.println("\nMatching books:");
			for (Book book : books) {
				if (book instanceof Periodical) {
					if (((Periodical) book).getFrequency() == frequency.toUpperCase().charAt(0)) {
						System.out.println(((Periodical) book).toString());
					}
				}
			}
			break;

		default:
			System.out.println("Wrong type of book entred.");
		}

	}

	/**
	 * Prompts the user to enter a number and the program displays that number of
	 * random books. The books can be any type.
	 * 
	 * @param sc to read the inputs from the user
	 */
	public void produceRandomBookList(Scanner sc) {
		// TODO Auto-generated method stub
		Collections.shuffle(books);
		System.out.print("Enter number of books: ");
		String randomBooksString=sc.next();
		while ( !randomBooksString.matches("(\\d*)")) {
			System.out.println("Wrong Number of Books Enterd! please try again.");
			randomBooksString=sc.next();
		}
		int randomBooks = Integer.parseInt(randomBooksString);
		for (int i = 0; i < randomBooks && i< books.size(); i++) {
			System.out.println(books.get(i).toString());
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
			printWriter.print(book.toStringPrint());
			printWriter.println();
		}
		printWriter.close();
	}
}
