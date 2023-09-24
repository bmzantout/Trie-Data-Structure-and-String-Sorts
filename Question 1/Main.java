package Assignment4_Q1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//-----------------------------------------------------------------
		// Title: Question 1
		// Author: Basme Zantout
		// ID: 99227947762
		// Section: 1
		// Assignment: 4
		// Description: This is the main class for Question 1 which calls 
		//              the methods that are needed to perform 3 basic 
	    //              on the tree structure.
		//-----------------------------------------------------------------
		
		
		System.out.println("Enter");
		
		
//-------------------------------------------------------
// Creating a Scanner object named "scan"   
//-------------------------------------------------------
	
		Scanner scan = new Scanner(System.in);
		
		
//-------------------------------------------------------
// Reading the number of strings that will be input  
//-------------------------------------------------------
	
		int input_no = scan.nextInt();
		
		
//-------------------------------------------------------
// Initializing a Trie's Data Structure Object   
//-------------------------------------------------------
	
		TrieST<Integer> Trie = new TrieST<Integer>();
		
		
//-------------------------------------------------------
// Initializing a String array to store the input strings.
// This array will be used for later methods in order to 
// retrieve the words by the same order they are written
//-------------------------------------------------------
	
		String [] words = new String [input_no]; 
		
		
//-------------------------------------------------------
// Reading the strings from the input and adding them 
// the String array and Trie's tree 
//-------------------------------------------------------
	
		for (int i = 0 ; i < input_no ; i++)
		{
			String word = scan.next();
			Trie.put(word, i);
			words[i] = word;
		}
		
		
		
//-------------------------------------------------------
// Printing out the required messages to the user, so 
// he/she chooses one of the 3 methods that he/she wants 
// to apply on the given input strings
//-------------------------------------------------------
	
		System.out.println("Choose the function you want to use:");
		System.out.println();
		System.out.println("1) Search");
		System.out.println("2) Count Prefix");
		System.out.println("3) Find Reverse");

		
		
//-------------------------------------------------------
// In a switch-case statement, we check the input number 
// from the user and call the required method based 
// on the chosen case number
//-------------------------------------------------------
	
		switch (scan.nextInt())
		{
		
		
		case 1: 
			
		//-------------------------------------------------------
		// If the input is 1, we implement the first case which 
		// is "Search". So, we call the "Search" method in the 
		// "Methods" class and print out "true" if the keyword 
		// was found in the Trie tree and false otherwise
		//
		// Note: check the "Methods" class for implementation 
		//       details
		//-------------------------------------------------------
			
			if (Methods.Search(scan.next(), Trie))
			{
				System.out.println("True");
			}
			
			else 
			{
				System.out.println("False");
			}
			
		break;
			
			
		
		case 2: 
			
		//-------------------------------------------------------
		// If the input is 2, we implement the second case which 
		// is "Count Prefix". So, we call the "countPrefix" method 
		// in the "Methods" class which takes all the strings by 
		// the same order they were read (from the words array) 
		// and checks if a string is a prefix of any other string
		// in Trie. It assigns the number of occurrences for each 
		// string to the "prefix_count" and its values are then 
		// printed out.
		//
		// Note: check the "Methods" class for implementation 
		//       details
		//-------------------------------------------------------
				
			int [] prefix_count = new int [input_no];
			
			Methods.countPrefix(Trie, words, prefix_count);
			
			for (int count : prefix_count)
			{
				System.out.print(count + " ");
			}
			
		break;
			
			
		case 3: 
			
			//-------------------------------------------------------
			// If the input is 3, we implement the third case which 
			// is "Find Reverse". So, we call the "reverseFind" method 
			// in the "Methods" class which prints all the strings
			// that end with the given suffix in the Trie tree, 
		    // lexicographically. 
			//
			// Note: check the "Methods" class for implementation 
			//       details
			//-------------------------------------------------------
		
			Methods.reverseFind(scan.next(), Trie);
			
			break;
		}
		
		
		
//-------------------------------------------------------
// Closing the scanner
//-------------------------------------------------------
		
		scan.close();
		
	}

}
