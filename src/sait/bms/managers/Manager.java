package sait.bms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrensBook;
import sait.bms.problemdomain.Cookbook;
import sait.bms.problemdomain.Paperback;
import sait.bms.problemdomain.Periodical;

/**
 * 
 * Manager class to contain the following methods: 
 * menu
 * loadBooksListFromFile
 * CheckoutBook 
 * FindBook
 * DisplayBookByType 
 * RandomBookList
 * 
 * @author abbas
 *
 */
public class Manager {

	ArrayList<Book> books = new ArrayList<Book>();
	
	public Manager() throws FileNotFoundException{
		loadBooksListFromFile();
		for(int i=0; i < books.size(); i++) {
		System.out.println(books.get(i));
		}
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
		Scanner in = new Scanner(new File("res/books.txt"));
		while (in.hasNext()) {
			String line = in.nextLine();
			String[] fields = line.split(";");
			char lastChar = fields[0].charAt(12);
			switch (lastChar) {
			case '0':
			case '1':
				//ChildrensBook(long isbn 0, String callNumber 1, int available 2 , int total 3, String title 4, String author 5,
				//char format 6)
				books.add(new ChildrensBook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
						fields[4], fields[5], fields[0].charAt(0)));
				break;
			case '2':
			case '3':
				//Cookbook(long isbn 0, String callNumber 1, int available 2, int total 3, String title 4 , String publisher 5, char diet 6)
				books.add(new Cookbook(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
						fields[4], fields[5], fields[0].charAt(0)));
				break;
			case '4':
			case '5':
			case '6':
			case '7':
				//Paperback(long isbn 0, String callNumber 1, int available 2, int total 3, String title 4, String author 5, int year 6,
				//char genre 7)
				books.add(new Paperback(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
						fields[4], fields[5], Integer.parseInt(fields[6]), fields[7].charAt(0)));
				break;
			case '8':
			case '9':
				//Periodical(long isbn 0, String callNumber 1, int available 2, int total 3, String title 4, char frequency 5)
				books.add(new Periodical(Long.parseLong(fields[0]), fields[1], Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
						fields[4], fields[5].charAt(0)));
				break;
			}
		}
		in.close();
		return books;
	}
	
	public void CheckoutBook() {
		
		//prompt the user to enter the ISBN of the book
		System.out.println("Enter ISBN of book: ");
		Scanner sc = new Scanner(System.in);
		Long isbn = sc.nextLong();
		sc.close();
		//find the book using the ISBN the user entered
	    for ( Book book : books ) {
	    	if(book.getIsbn() == isbn) {
	    		//Periodical books cannot be checked out
	    		if (book instanceof Periodical) {
	    			System.out.println("Periodical books cannot be checked out.");
	    			return;
	    		} else {
	    			//check if the book is available
	    			if(book.getAvailable() > 0) {
	    				//decrease the available book by 1
	    				book.setAvailable(book.getAvailable() -1);
	    				System.out.println("The book " + book.getTitle()+ " was checked out.");
	    				System.out.println("It can be located using a call number: " + book.getCallNumber());
	    			} else {
	    				System.out.println("The book "+ isbn + " is not available.");
	    			}
	    		}
	    		
	    	} else {
	    		System.out.println("The book with an ISBN of " + isbn + " was not found. \nCheck ISBN or try a different book!");
	    		return;
	    	}
	    }
	}
	
	public void findBooksbyTitle() {
		System.out.println("Enter title to search for: ");
		Scanner sc = new Scanner(System.in);
		String search = sc.next();
		
		for(Book book : books) {
			if(book.getTitle().toLowerCase().contains(search.toLowerCase())) {
				System.out.println("Matching books:");
				System.out.println("ISBN:		      "+book.getIsbn());
				
			}
		}
	}
}
