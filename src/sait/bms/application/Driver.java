package sait.bms.application;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import sait.bms.managers.Manager;
import sait.bms.problemdomain.Book;

/**
 * Driver class for the ABCBooks Assignment
 * @author abbas
 * @version 2022-02-02 3:13 PM
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		try {
			Manager m = new Manager();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
