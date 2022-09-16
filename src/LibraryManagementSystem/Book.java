/* ACSIS Name: Suraj Mittal
* Lab Professor Name: Mike Norman
* Assessment: Lab 06
* File: Book
*/

package LibraryManagementSystem;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Book class
 * 
 * this class has methods to read, print and calculate fines related to books.
 * @author suraj
 *
 */
public class Book {
	
	private int id;
	private String name;
	private String author;
	private String category;
	private String genre;
	private String published;
	private LocalDate loaned;
	private LocalDate returned;
	private final static double FINE_PER_DAY = 1;
	
	// no-ard contructor
	public Book() {};
	
	// parameterized constructor
	public Book(int id, String name, String author, String category, String genre, String published) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.category = category;
		this.genre = genre;
		this.published = published;
	}
	
	// setters and getters for the instance variables
	public int getID() {
		return id;
	}
	
	public void setLoaned(LocalDate loaned) {
		this.loaned = loaned;
	}

	/**
	 * this method read all the details of a book object
	 * @param input - Scanner object
	 */
	public void readDetails(Scanner input) {
		
		try {
			
			boolean cont = true;
			
			do {
				System.out.println("Enter book id (above 100)");
				id = input.nextInt();
				input.nextLine();
				if (id < 101) {
					System.out.println("Enter an integer greater than 100");
				}
			} while (id < 101);
			
    		
    		System.out.println("Enter name of the book.");
    		name = input.nextLine();
    		
    		System.out.println("Enter the name of author");
    		author = input.nextLine();
    		
    		do {
    			
    			System.out.println("Select category of the book \n1. Fiction \n2. Non-fiction");
	    		int catoption = input.nextInt();
	    		switch (catoption) {
	    		
	    		case 1: 
	    			category = "Fiction";
	    			cont = false;
	    			break;
	    			
	    		case 2:
	    			category = "Non-Fiction";
	    			cont = false;
	    			break;
	    		
	    		default:
	    			System.out.println("Input should be a positive integer from 1-2... please try again");
	    		}
    			
    		} while (cont);
    		
    		cont = true;
    		int genoption = 0;
    		
            do {
    			if (category.equals("Fiction")) {
    				System.out.println("Select genre of the book \n1. Comic \n2. Fantasy");
    				genoption = input.nextInt();
    	    		switch (genoption) {
    	    		
    	    		case 1: 
    	    			genre = "Comic";
    	    			cont = false;
    	    			break;
    	    			
    	    		case 2:
    	    			genre = "Fantasy";
    	    			cont = false;
    	    			break;
    	    		
    	    		default:
    	    			System.out.println("Input should be a positive integer from 1-2... please try again");
    	    		}
    				
    			}
    			else if (category.equals("Non-Fiction")) {
    				System.out.println("Select genre of the book \n1. Science \n2. History \n3. Biography");
    				genoption = input.nextInt();
    	    		switch (genoption) {
    	    		
    	    		case 1: 
    	    			genre = "Science";
    	    			cont = false;
    	    			break;
    	    			
    	    		case 2:
    	    			genre = "History";
    	    			cont = false;
    	    			break;
    	    			
    	    		case 3:
    	    			genre = "Biography";
    	    		    cont = false;
    	    		    break;
    	    		
    	    		default:
    	    			System.out.println("Input should be a positive integer from 1-3... please try again");
    	    		}
    			}
	    		
    			
    		} while (cont);
            
            cont = true;
            
            try {
            	do {
                	System.out.println("Enter the published date of book (YYYY-MM-DD)");
                	input.nextLine();
                	published = input.nextLine();
                	cont = false;
                } while (cont);
            }
            catch (InputMismatchException ie) {
            	System.out.println("enter valid input... please try again");
            }
            
    		System.out.println("Book has been added successfully.");
			
		}
		catch (InputMismatchException ie) {
			
		}
		catch (Exception e) {
			
		}
	}
	
	/**
	 * this method calculates for how many days a book was borrowed
	 * @param skip - number of days
	 */
	public void calculateDaysBorrowed(long skip) {
		returned = loaned.plusDays(skip);
	}
	
	/**
	 * this method calculates the applicable fine on the book return
	 * @return double
	 */
	public double calculateFine() {
		long numDaysBetween = DAYS.between(returned, loaned);
		double fine = 0;
		if (numDaysBetween > 14) {                         // 14 is the maximum number of days one can borrow a book without being fined
			fine = (numDaysBetween - 14) * FINE_PER_DAY;
		}
		else {
			fine = 0;
		}
		return fine;
	}
	
	/**
	 * this overloaded method calculates the applicable fine on the book
	 * @param numDaysBetween - manually entered days
	 * @return double
	 */
	public double calculateFine(long numDaysBetween) {
		double fine = 0;
		if (numDaysBetween > 14) {
			fine = (numDaysBetween - 14) * FINE_PER_DAY;
		}
		else {
			fine = 0;
		}
		return fine;
	}
	
	/**
	 * this method print details of a book object
	 */
	public void printDetails() {
		System.out.printf("%9d | %29s | %19s | %14s | %10s | %11s |\n", id, name, author, category, genre, published);
	}
}// class ends
