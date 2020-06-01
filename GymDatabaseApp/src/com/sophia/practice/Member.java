package com.sophia.practice;
import java.util.Scanner;

public class Member {
	
	private String firstName;
	private String lastName;
	private String tier; // 60 + will be in tier A, 18 + will be in Tier B, kids < 18 will be in tier C.
	private String memberId; // this will be a unique combination of their Tier + the incremented Id.
	private String enrolledClasses = "";
	private double monthlyDues = 0;
	private static double costOfClasses = 100; // if something is static, this property is not specific to an object, but belongs to all objects (it's not just true for the instance of the object)
	private static int id = 1000; // in the case of our static memberId, the value will increase by 1 every time
	
	// Constructor: this prompts user to enter NAME and AgeTier
	public Member() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your first name: ");
		this.firstName = scan.nextLine();
		
		System.out.println("Enter your last name: ");
		this.lastName = scan.nextLine();
		
		System.out.println("Enter your age: ");
		int age = scan.nextInt();
		
		if (age >= 65) {
			this.tier = "A";
		} else if(age >= 18) {
			this.tier = "B";
		} else {
			this.tier = "C";
		}
		
		
//  	every time we create a new member, the Id will increment by 1, then we concatenate the tier to it.
//		id++;
//		this.memberId = this.tier + id; // we could instead make this a method (to Generate a unique Id);        
// 		...Make this a method!
		setMemberId();
		
		System.out.println("Your first and last name is " + this.firstName + " " + this.lastName + ", you are in tier " + this.tier + " and your memberId is: " + this.memberId + ".");
		// then go to Driver and prove that this works.
		
		
	}

	//1.  method to Generate an ID
	private void setMemberId() {
		id++;
		this.memberId = this.tier + id;
	}
	
	//2. method Enroll in courses
	public void enroll() {
		
		Scanner scan = new Scanner(System.in);
		
		boolean asking = true;

		do {
			System.out.println("Enter an exercise class to enroll in (Q to quit): ");
			String exerciseClass = scan.nextLine();
			
			if(!exerciseClass.equals("Q")) { // change this to .toUpperCase
				this.enrolledClasses += "\n " + exerciseClass; // this forma
				this.monthlyDues += costOfClasses; // show this.monthlyDues = this.monthlyDues + costOfClasses;
			} else {
				asking = false;
			}
			
		} while(asking);
		
		System.out.println("ENROLLED IN: " + this.enrolledClasses);
		System.out.println("MONTHLY DUES: $" + this.monthlyDues);
		
	}
	
	// 3. method to view balance
	public void viewMonthlyDues() {
		System.out.println("Your balance left on Monthly Dues is " + this.monthlyDues + ".");
	}
	
	// 4. method to pay tuition
	public void payMonthlyDues(double payment) {
		this.monthlyDues -= payment;
		System.out.println("Thank you for your payment of $" + payment);
		// then incorporate the view Monthly Dues:
		viewMonthlyDues();
		
	}
	
	// 5. Show Info 
	public void showInfo() {
		System.out.println("\nName: " + this.firstName + " " + this.lastName +  
				"\nMember ID: " + this.memberId + 
				"\nClasses enrolled in: " + this.enrolledClasses + 
				"\nMonthly Dues: " + this.monthlyDues);
		
	}
	
	
}
