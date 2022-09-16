/* ACSIS Name: Suraj Mittal
* Lab Professor Name: Mike Norman
* Assessment: Lab 06
* File: Staff
*/

package LibraryManagementSystem;

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Staff class
 * 
 * This class extends person class.
 * This class has methods to read and print information specific to staff.
 * @author suraj
 *
 */
public class Staff extends Person{
	
	// instance variables
	private long staffID;
	//private String name;
	private String floor;
	private String section;
	
	//default constructor
	public Staff() {
		
	}
	
	// parameterized constructor
	public Staff(int id, String floor, String section) {
		staffID = id;
		this.floor = floor;
		this.section = section;
	}

	// setters and getters for the staff class
	public long getStaffID() {
		return staffID;
	}
	
    /**
     * this method reads details related to staff
     * @param input - Scanner object
     * @throws InputMismatchException
     */
	public void readDetails(Scanner input) throws InputMismatchException {
		System.out.println("Enter a staff ID");
		staffID = input.nextLong();
		input.nextLine();
		System.out.println("Enter name of staff");
		name = input.nextLine();
		System.out.println("Enter working floor of the staff");
		floor = input.nextLine();
		System.out.println("Enter working section of the staff");
		section = input.nextLine();
	}
	
	/**
	 * this method prints details related to staff
	 */
	public void printDetails() {
		System.out.printf("%10d | %9s | %10s | %10s |\n", staffID, name, floor, section);
	}

}//class ends
