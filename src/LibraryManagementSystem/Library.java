/* ACSIS Name: Suraj Mittal
* Lab Professor Name: Mike Norman
* Assessment: Lab 06
* File: Library
*/

package LibraryManagementSystem;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

/**
 * Library class
 * 
 * This class has methods and variables to support everything related to the library system
 * @author suraj
 *
 */
public class Library {
	
	// instance variables
	public String name;
	private boolean cont = true;
	private int option = 0;
	private ArrayList<Book> inventory = new ArrayList<Book>();
	private ArrayList<Staff> staff = new ArrayList<Staff>();
	private ArrayList<Member> members= new ArrayList<Member>();
	
	// no-arg constructor
	public Library() {};
	
	// parameterized constructor
	public Library(String name) {
		this.name = name;
	}
	
	/**
	 * this method invokes the staff menu with options for a staff user.
	 * @param input - Scanner object
	 */
	public void staffMenu(Scanner input) {
	    do {
	    	
	    	do {
				// exception handling for the menu system
				try {
					Library.printLine(105); //print line method to print a line symbolic character
					System.out.println("1. Add a book using keyboard \n2. Add books from file \n3. Remove a book \n4. Add member \n5. Remove member \n6. Add Staff \n7. Remove Staff \n8. Return to main menu");
					Library.printLine(105);
					System.out.print("Enter your choice: ");
					option = input.nextInt();
					input.nextLine();
					cont = false;
				}
				catch (InputMismatchException ie) {
					System.err.println("Input should be a positive integer from 1-8... please try again");
					input.nextLine();
				}
			} while (cont);
	    	
	    	switch (option) {
	    	
	    	case 1:
	    		inventory.add(inventory.size(), new Book());
	    		inventory.get(inventory.size() - 1).readDetails(input);
	    		break;
	    		
	    	case 2:
	    		readBooksFromFile();
	    		System.out.println("Books added");
	    		break;
	    		
	    	case 3:
	    		boolean cont = true;
	    		do {
	    			try {
	    				printInventory();
	    	    		System.out.println("Enter id of the book you want to remove");
	    	    		int rid = input.nextInt();
	    	    		if (validBookID(rid)) {
	    	    			for (Book b: inventory) {
	    		    			if (b.getID() == rid) {
	    		    				inventory.remove(b);
	    		    				System.out.println("Book removed");
	    		    				break;
	    		    			}
	    	    		    }
	    	    		}
	    	    		cont = false;
	    	    		break;
		    		}
		    		catch (InputMismatchException ie) {
		    			System.err.println("Enter a valid ID... please try again");
						input.nextLine();
		    		}
	    		} while (cont);
	    		break;
	    		
	    		
	    	case 4:
	    		boolean cont2 = true;
	    		do {
	    			try {
	    				members.add(members.size(), new Member());
	    	    		members.get(members.size() - 1).readDetails(input);
	    	    		System.out.println("User added successfully");
	    	    		cont2 = false;
	    	    		break;
		    		}
		    		catch (InputMismatchException ie) {
		    			System.err.println("Enter a valid ID... please try again");
						input.nextLine();
		    		}
	    		} while (cont2);
	    		break;
	    		
	    		
	    	case 5:
	    		boolean cont3 = true;
	    		do {
	    			try {
	    				printMember();
	    	    		System.out.println("Enter ID of the member you want to remove");
	    	    		int memid = input.nextInt();
	    	    		input.nextLine();
	    	    		if (validMemberID(memid)) {
	    	    			for (Member m: members) {
	    		    			if (m.getMemberID() == memid) {
	    		    				members.remove(m);
	    		    				System.out.println("Member removed successfully");
	    		    				break;
	    		    			}
	    		    		}
	    	    		}
	    	    		cont3 = false;
	    	    		break;
		    		}
		    		catch (InputMismatchException ie) {
		    			System.err.println("Enter a valid ID... please try again");
						input.nextLine();
		    		}
	    		} while (cont3);
	    		break;
	    		
	    		
	    	case 6:
	    		boolean cont4 = true;
	    		do {
	    			try {
	    				staff.add(staff.size(), new Staff());
	    	    		staff.get(staff.size() - 1).readDetails(input);
	    	    		System.out.println("Staff added successfully");
	    	    		cont4 = false;
	    	    		break;
		    		}
		    		catch (InputMismatchException ie) {
		    			System.err.println("Enter a valid ID... please try again");
						input.nextLine();
		    		}
	    		} while (cont4);
	    		break;
	    		
	    		
	    	case 7:
	    		boolean cont5 = true;
	    		do {
	    			try {
	    				printStaff();
	    	    		System.out.println("Enter ID of the staff you want to remove");
	    	    		int staffid = input.nextInt();
	    	    		input.nextLine();
	    	    		if (validStaffID(staffid)) {
	    	    			for (Staff s: staff) {
	    		    			if (s.getStaffID() == staffid) {
	    		    				staff.remove(s);
	    		    				System.out.println("Staff removed successfully");
	    		    				break;
	    		    			}
	    	    		    }
	    	    		}
	    	    		cont5 = false;
	    	    		break;
		    		}
		    		catch (InputMismatchException ie) {
		    			System.err.println("Enter a valid ID... please try again");
						input.nextLine();
		    		}
	    		} while (cont5);
	    		break;
	    		
	    		
	    	case 8:
	    		System.out.println("Going back to main menu");
	    		break;
	    		
	    	default:
	    		System.out.println("Enter valid inputs.... please try again");
	    		break;
	    	
	    	}
		
	    } while (option != 8);
	}
	
	/**
	 * this method invoked member's menu with options for a member
	 * @param input
	 */
	public void memberMenu(Scanner input) {
		
        do {
	    	
	    	do {
				// exception handling for the menu system
				try {
					Library.printLine(105);
					System.out.println("1. Loan a book \n2. Return a book \n3. Print books borrowed by the member \n4. Print member information \n5. Return to main menu");
					Library.printLine(105);
					System.out.print("Enter your choice: ");
					option = input.nextInt();
					input.nextLine();
					cont = false;
				}
				catch (InputMismatchException ie) {
					System.err.println("Input should be a positive integer from 1-4... please try again");
					input.nextLine();
				}
			} while (cont);
	    	
	    	switch (option) {
	    	
	    	case 1:
	    		boolean cont = true;
	    		do {
	    			try {
		    			printInventory();
			    		loanBook(input);
			    		cont = false;
			    		break;
		    		}
		    		catch (InputMismatchException ie) {
		    			System.err.println("Enter a valid ID... please try again");
						input.nextLine();
		    		}
	    		} while (cont);
	    		break;
	    		
	    		
	    		
	    	case 2:
	    		boolean cont2 = true;
	    		do {
	    			try {
		    			returnBook(input);
		    			cont2 = false;
			    		break;
		    		}
		    		catch (InputMismatchException ie) {
		    			System.err.println("Enter a valid ID... please try again");
						input.nextLine();
		    		}
	    		} while(cont2);
	    		break;
	    		
	    	case 3:
	    		boolean cont3 = true;
	    		do {
	    			try {
		    			printMemberBooks(input);
		    			cont3 = false;
			    		break;
		    		}
		    		catch (InputMismatchException ie) {
		    			System.err.println("Enter a valid ID... please try again");
						input.nextLine();
		    		}
	    		} while (cont3);
	    		break;
	    		
	    	case 4:
	    		boolean cont4 = true;
	    		do {
	    			try {
		    			printMemberInformation(input);
		    			cont4 = false;
			    		break;
		    		}
		    		catch (InputMismatchException ie) {
		    			System.err.println("Enter a valid ID... please try again");
						input.nextLine();
		    		}
	    		} while(cont4);
	    		break;
	    		
	    	case 5:
	    		System.out.println("Returning to the main menu...");
	    		break;
	    		
	    	default:
	    		System.out.println("Enter valid inputs... please try again");
	    		break;
	    	}
		
	    } while (option != 5);
	}
	
	/**
	 * this method prints all the books in the Library's inventory
	 */
	public void printInventory() {
		Library.printLine(110);
		printTitle();
		Library.printLine(110);
		if (inventory.size() != 0) {
			System.out.printf("%s Book ID |%20s Book Name | %12s Author | %5s Category | %4s Genre | %2s Published |\n", " ", " ", " ", " ", " ", " ");
			Library.printLine(110);
			for (int i = 0; i < inventory.size(); i++) {
				inventory.get(i).printDetails();
			}
		}
		else {
			System.out.println("");
			System.out.println("The library has no books available at the moment. :(");
		}
		Library.printLine(110);
	}
	
	/**
	 * this method prints all the members of the Library
	 */
	public void printMember() {
		Library.printLine(54);
		System.out.printf("%5s Member ID |%6s Name | %4s Age | %s Fine ($) |\n", " ", " ", " ", " ");
		Library.printLine(54);
		for (int i = 0; i < members.size(); i++) {
			members.get(i).printDetails();
		}
	}
	
	/**
	 * this method prints all the staff users of the Library
	 */
	public void printStaff() {
		Library.printLine(50);
		System.out.printf("%s Staff ID |%5s Name | %4s Floor | %2s Section |\n", " ", " ", " ", " ");
		Library.printLine(50);
		for (int i = 0; i < staff.size(); i++) {
			staff.get(i).printDetails();
		}
	}
	
	/**
	 * this method prints all the books of a specific member
	 * @param input - Scanner object
	 * @throws InputMismatchException
	 */
	public void printMemberBooks(Scanner input) throws InputMismatchException {
		System.out.println("Enter your member ID");
		long memID = input.nextLong();
		if (validMemberID(memID)) {
			for (Member m: members) {
				if (m.getMemberID() == memID) {
					m.printBooks();
					break;
				}
			}
		}
		else {
			System.out.println("No records found... please try again.");
		}
		
	}
	
	/**
	 * this method lets a member to take a book from library's inventory
	 * @param input - Scanner object
	 * @throws InputMismatchException
	 */
	public void loanBook(Scanner input) throws InputMismatchException {
		if (inventory.size() != 0) {
			Book loanedBook = new Book();
			System.out.println("Enter the ID of the book you want to borrow");
			int bid = input.nextInt();
			input.nextLine();
			
			if (validBookID(bid)) {
				for (Book b: inventory) {
					if (b.getID() == bid) {
						inventory.remove(b);
						loanedBook = b;
						break;
					}
				}
				System.out.println("Enter your member ID");
				long memid = input.nextInt();
				if (validMemberID(memid)) {
					for (Member m: members) {
						if (memid == m.getMemberID()) {
							loanedBook.setLoaned(LocalDate.now());
							m.addBook(loanedBook);
							break;
						}
					}
				}
				
			}
			else {
				System.out.println("No records found... please try again.");
			}
			
		}
		else {
			System.out.println("Inventory of the library is empty");
		}
		
	}
	
	/**
	 * this method let a member to return one of their borrowed books
	 * @param input - Scanner object
	 * @throws InputMismatchException
	 */
	public void returnBook(Scanner input) throws InputMismatchException {
		System.out.println("Enter your member ID:");
		int memid = input.nextInt();
		if (validMemberID(memid)) {
			for (Member m: members) {
				if (m.getMemberID() == memid) {
					m.returnBook(input);
					System.out.println("Book returned");
					break;
				}
			}
		}
		else {
			System.out.println("No records found... please try again.");
		}
	}
	
	/**
	 * this method prints all the information of a specific member
	 * @param input - Scanner object
	 * @throws InputMismatchException
	 */
	public void printMemberInformation(Scanner input) throws InputMismatchException {
		System.out.println("Enter your memberID");
		int memid = input.nextInt();
		if (validMemberID(memid)) {
			for (Member m: members) {
				System.out.println("Member's ID: " + m.getMemberID());
				System.out.println("Member's name: " + m.getName());
				System.out.println("Member's age: " + m.getAge());
				System.out.println("Member's fine: $" + m.getFine() );
				break;
			}
		}
		else {
			System.out.println("No records found... please try again.");
		}
	}
	
	/**
	 * this method reads information from a file and create book objects
	 */
    public void readBooksFromFile() {
		
    	String file = "src\\LibraryManagementSystem\\Books.txt";
		BufferedReader reader = null;
		String line = ""; 
    	
	    try {
				
	    reader = new BufferedReader(new FileReader(file));
		while((line = reader.readLine()) != null) {
		String[] row = line.split(",");
		int id = Integer.parseInt(row[0]);
        inventory.add(new Book(id, row[1], row[2], row[3], row[4], row[5]));
		}
			}
		catch (Exception e) {
				System.out.println(e);
		}
	}
    
    /**
     * this method validates a member ID
     * @param memid
     * @return boolean - true if valid
     */
    public boolean validMemberID(long memid) {
		boolean valid = false;
		for (Member m : members) {
			if (m.getMemberID() == memid) {
				valid = true;
				break;
			}
		}
		return valid;
	}
	
    /**
     * this method validates a staff ID
     * @param staffid
     * @return boolean - true if valid
     */
	public boolean validStaffID(long staffid) {
		boolean valid = false;
		for (Staff s : staff) {
			if (s.getStaffID() == staffid) {
				valid = true;
				break;
			}
		}
		return valid;
	}
	
	/**
	 * this method validates a book ID
	 * @param bookid
	 * @return boolean - true if valid
	 */
	public boolean validBookID(int bookid) {
		boolean valid = false;
		for (Book b : inventory) {
			if (b.getID() == bookid) {
				valid = true;
				break;
			}
		}
		return valid;
	}
    
	/**
	 * this method prints the title of the Library
	 */
    public void printTitle() {
    	System.out.println("                                 ****" + name + "'s Library Inventory****");
    }
    
    /**
     * this method prints a symbolic character for visual purposes
     * @param num - to specify how many characters in a line
     */
    public static void printLine(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print("=");
		}
		System.out.println();
	}
}// class ends