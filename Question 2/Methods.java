public class Methods {

	
	//-----------------------------------------------------------------
	// Title: Question 2
	// Description: This is the class that is used by the main class and
	//              has all the required methods to perform the sorting
        //              operations over the given string arrays
	//-----------------------------------------------------------------
	
	
	public static String [] SORT_ARRAYS (String [] First_array , String [] Second_array)
//----------------------------------------------------------------
// Summary: sorts an array of strings based on proposed rules
// Precondition: takes the input string arrays as parameters
// Postcondition: returns the Sorted string array 
// 
// Note: check the other methods below for implementation details
//----------------------------------------------------------------
	
	{
		// Initialize the "Sorted" array with the same size as the 
		// "First" array to be sorted 

		String [] Sorted_array = new String [First_array.length];
		
		// For every string in the array
		
		for (int i = 0 ; i < First_array.length ; i++)
		{
			// Calculate the Integer value of the string in the First 
			// and Second arrays
			
			long first_integer = Calculate_Integer_Value(First_array[i]);
			long second_integer = Calculate_Integer_Value(Second_array[i]);
			
			// Find the absolute difference between both values
			// If the result is even call the "even" method that 
			// sorts the string in a specific way
			
			if ((Math.abs(first_integer - second_integer) % 2) == 0)
			{
				Sorted_array[i] = even(First_array[i], Second_array[i]);
			}
			
			// Else, if the result is odd call the "odd" method that 
			// sorts the string in another specific way
			
			else 
			{
				Sorted_array[i] = odd(First_array[i]);
			}
		}
		
		return Sorted_array;
	}
	
	
	
	
	public static String even (String first, String second) 
//--------------------------------------------------------
// Summary: Sorts the input string based on the given
//          character order.
// Precondition: The input and order strings are not null. 
//               The order string contains unique characters.
// Postcondition: Returns the sorted string based on the 
//                character order.
//--------------------------------------------------------
	{
	        // Convert the input string to a character array 
		    // for sorting
		
	        char[] chars = first.toCharArray();

	        // Implement a custom sorting algorithm based on 
	        // character priority
	        
	        for (int i = 0; i < chars.length - 1; i++)
	        {
	            for (int j = i + 1; j < chars.length; j++) 
	            {
	                char char1 = chars[i];
	                char char2 = chars[j];
	                int index1 = second.indexOf(char1);
	                int index2 = second.indexOf(char2);

	                // If char1 or char2 is not found in the order string, 
	                // assign it a higher index
	                
	                if (index1 == -1) 
	                {
	                    index1 = second.length() + first.indexOf(char1);
	                }
	                
	                if (index2 == -1) 
	                {
	                    index2 = second.length() + first.indexOf(char2);;
	                }

	                // Swap the characters if their indices are out of order
	                
	                if (index1 > index2) 
	                {
	                    chars[i] = char2;
	                    chars[j] = char1;
	                }
	            }
	        }

	        // Convert the sorted character array back to a string
	        return new String(chars);
	    }

	
	
	private static String odd(String first)
//------------------------------------------------------------
// Summary: Sorts the input string in ascending order.
// Precondition: The input string is not null.
// Postcondition: Returns the sorted string in ascending order.
//------------------------------------------------------------
	
	{
	      // Convert the input string to a character array for sorting
		
        char[] chars = first.toCharArray();

        // Implement the bubble sort algorithm
        
        int n = chars.length;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (chars[j] > chars[j + 1])
                {
                    // Swap characters
                	
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }

        // Convert the sorted character array back to a string
        
        return new String(chars);
	}
	
	
	
	
	private static long Calculate_Integer_Value(String word)
//------------------------------------------------------------
// Summary: Calculates the integer value of a given string 
// Precondition: Takes the string as parameter
// Postcondition: Returns a long which holds the value of
//                the given string
//------------------------------------------------------------
	
	{
		
        long value_of_string = 0;
		
        // In a for-loop, read each character in the string 
        
		for (int x = 0 ; x < word.length() ; x++)
		{
			// Get the integer value of the character 
			
			int value_of_char = word.charAt(x) - 96;
			
			// If the character's integer value is a 2-digit number, 
			// multiply the total value by 100 and add it 
			
			if (value_of_char >= 10)
			{
				value_of_string *= 100;
				value_of_string += value_of_char;
			}
			
			// Else, if the character's integer value is a 1-digit number, 
			// multiply the total value by 10 and add it 
			
			else 
			{
				value_of_string *= 10;
				value_of_string += value_of_char;
			}
			
							
		}
		
		return value_of_string;
		
	}

	
}
