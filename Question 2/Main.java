import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//-----------------------------------------------------------------
		// Title: Question 2
		// Description: This is the main class for Question 2 which calls 
		//              the methods that are needed to perform the sorting 
	        //              operations on some given String arrays.
		//-----------------------------------------------------------------
		
		
//-------------------------------------------------------
// Creating a Scanner object named "scan"   
//-------------------------------------------------------
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("First Array:");
		
//-------------------------------------------------------
// Reading the first line of text and assigning it to 
// the String array named "First_array"
//-------------------------------------------------------

		String first = scan.nextLine();
		
		String [] First_array = first.split(" ");
		
		
		
		
		
		
		System.out.println("Second Array:");
		
//-------------------------------------------------------
// Reading the second line of text and assigning it to 
// the String array named "Second_array"
//-------------------------------------------------------

		String second = scan.nextLine();
		
		String [] Second_array = second.split(" ");
		

		
		
		
		System.out.println("Sorted Array:");
		
//-------------------------------------------------------
// Calling the "SORT_ARRAYS" method in the "Methods" class
// which sorts the array based on the proposed rules. The 
// method returns the Sorted string whose values are 
// printed to the console
//
// Note: check the "Methods" class for implementation 
//       details
//-------------------------------------------------------
	
		String [] Sorted_array = Methods.SORT_ARRAYS(First_array, Second_array);
		
		for (String s : Sorted_array)
		{
			System.out.print(s + " ");
		}
	
		
		
//-------------------------------------------------------
// Closing the scanner
//-------------------------------------------------------
		
		scan.close();
		
	}

}
