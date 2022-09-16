/* ACSIS Name: Suraj Mittal
* Lab Professor Name: Mike Norman
* Assessment: Lab 06
* File: LibraryManagement
*/

package LibraryManagementSystem;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * LibraryManagement
 * 
 * This is a testing class for library system, with a main method,
 * @author suraj
 *
 */
public class LibraryManagement {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); //declaring a scanner object
		
		// declaring variables
		String name;
		int option = 0;
		boolean cont = true;
		
		System.out.println("Enter the name of library: ");
		name = input.nextLine();
		
		Library l1 = new Library(name); //creating a library object
		
		do {
			do {
				// exception handling for the menu system
				try {
					Library.printLine(105);      // prints a symbolic character line
					System.out.println("1. Member's Menu \n2. Staff's Menu \n3. Print library inventory \n4. Print Members detail \n5. Print Staff details \n6. Exit");
					Library.printLine(105);
					System.out.print("Enter your choice: ");
					option = input.nextInt();
					input.nextLine();
					cont = false;
				}
				catch (InputMismatchException ie) {
					System.err.println("Input should be a positive integer from 1-6... please try again");
					input.nextLine();
				}
			} while (cont);
			
			cont = true; // to re-use cont in other loops
			
			switch (option) {
			
			case 1:
				l1.memberMenu(input);
				break;
				
			case 2:
				l1.staffMenu(input);
				break;
				
			case 3:
				l1.printInventory();
				break;
				
			case 4:
				l1.printMember();
				break;
				
			case 5:
				l1.printStaff();
				break;
				
			case 6:
				System.out.println("Goodbye... have a nice day! \nProgram by Suraj Mittal");
				break;
				
			default:
				System.err.println("Invalid choice... choice should be a positive integer from 1-6... please try again");
				
			}
		
		} while (option != 6);
		
		input.close();

	} //main method ends

}// class ends
