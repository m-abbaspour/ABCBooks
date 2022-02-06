package sait.bms.application;

import java.io.FileNotFoundException;
import java.util.Scanner;

import sait.bms.managers.Manager;

/**
 * Driver class for the ABCBooks Assignment
 * @author abbas
 * @version 2022-02-02 3:13 PM
 *
 */
public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			Manager m = new Manager(sc);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.close();
		
	}
}
