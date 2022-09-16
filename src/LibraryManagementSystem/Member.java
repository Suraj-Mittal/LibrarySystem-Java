/* ACSIS Name: Suraj Mittal
* Lab Professor Name: Mike Norman
* Assessment: Lab 06
* File: Member
*/

package LibraryManagementSystem;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Member class
 * 
 * this class extends Person class
 * this class has methods to read, print and manage information reltaed to members
 * @author suraj
 *
 */
public class Member extends Person {
	
	// instance variables
	private long memberID;
	//private String name;
	private int age;
	private double fine = 0;
	private ArrayList<Book> books = new ArrayList<Book>();
	
	// no-arg constructor
	public Member() {}
	
	// parameterized constructor
	public Member(long memberID, int age) {
		this.memberID = memberID;
		this.age = age;
	}
	
	// setters and getters for the member class
	public long getMemberID() {
		return memberID;
	}
	
    public int getAge() {
		return age;
	}

	public double getFine() {
		return fine;
	}

	/**
     * this method reads all the details of a member object
     * @param input - Scanner Object
     * @throws InputMismatchException
     */
	public void readDetails(Scanner input) throws InputMismatchException {
		System.out.println("Enter a member ID");
		memberID = input.nextLong();
		input.nextLine();
		System.out.println("Enter name of member");
		name = input.nextLine();
		System.out.println("Enter age of member");
		age = input.nextInt();
		input.nextLine();
	}
	
	/**
	 * this method adds a book to the member's inventory when they borrow one
	 * @param b - book object
	 */
	public void addBook(Book b) {
		if (books.size() < 5) {
			books.add(b);
			System.out.println("Book borrowed successfully");
		}
		else {
			System.out.println("***You have reached your maximum limit of 5 books.***");
		}
	}
	
	/**
	 * this method returns the book as requested by the member
	 * @param input - Scanner object
	 * @throws InputMismatchException
	 */
	public void returnBook(Scanner input) throws InputMismatchException {
		if (books.size() != 0) {
			printBooks();
			System.out.println("Enter the id of the book you want to return");
			int bid = input.nextInt();
			input.nextLine();
			if (validBookID(bid)) {
				for (Book b: books) {
					System.out.println("How many days you want to skip?");
					long skip = input.nextLong();
					books.remove(b);
					//b.calculateDaysBorrowed(skip);
					fine = fine + b.calculateFine(skip);
					break;
				}
			}
			
		}
		else {
			System.out.println("No books available for return");
		}
	}
	
	/**
	 * this method prints all the details of a member
	 */
	public void printDetails() {
		System.out.printf("%15d | %10s | %8s | %10s |\n", memberID, name, age, fine);
	}
	
	/**
	 * this method prints all the books a member has borrowed
	 */
	public void printBooks() {
		Library.printLine(110);
		if (books.size() != 0) {
			System.out.printf("%s Book ID |%20s Book Name | %12s Author | %5s Category | %4s Genre | %2s Published |\n", " ", " ", " ", " ", " ", " ");
			Library.printLine(110);
			for (int i = 0; i < books.size(); i++) {
				books.get(i).printDetails();
			}
		}
		else {
			System.out.println("This user has no borrowed books.");
		}
		Library.printLine(105);
	}
	
	/**
	 * this method validates a book object in the member's inventory
	 * @param bookid - id of a book object to validate
	 * @return boolean if valid then true
	 */
	public boolean validBookID(int bookid) {
		boolean valid = false;
		for (Book b : books) {
			if (b.getID() == bookid) {
				valid = true;
				break;
			}
			else {
				System.out.println("No records found... please try again.");
			}
		}
		return valid;
	}

} // class ends
