package Assignment4_Q1;

public class Methods {

	//-----------------------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout
	// ID: 99227947762
	// Section: 1
	// Assignment: 4
	// Description: This is the class that is used by the main class and
	//              has all the required methods to perform the three
    //              main operations over the strings on Trie
	//-----------------------------------------------------------------
	
	
	public static boolean Search (String arg, TrieST<Integer> Trie)
//----------------------------------------------------------
// Summary: searches the Trie for a given string
// Precondition: takes the input string and the Trie tree as 
//               parameters
// Postcondition: calls the "contains" method from the TrieST
//                class and returns true if the string was
//                found and false, otherwise 
// 
// Note: check the "contains" method in the "Trie" class for
//       implementation details
//----------------------------------------------------------
	
	{
		if (Trie.contains(arg))
		{
			return true;
		}
		
		return false;
		
	}
	
	
	public static void countPrefix(TrieST<Integer> Trie, String [] words, int [] prefix_count)
//--------------------------------------------------------------
// Summary: checks if a string is a prefix of any other string
//          in the Trie
// Precondition: takes the Strings array, the Trie tree and the 
//               "prefix_count" as parameters
// Postcondition: takes the Strings from the "words" array in the 
//                same order they were read in and calls the 
//                "keysWithPrefix" method from theTrieST class 
//                 then counts the number of occurrences of
//                 each string and assigns the number to the 
//                 "prefix_count" array, accordingly
// 
// Note: check the "keysWithPrefix" method in the "Trie" class 
//       for implementation details
//--------------------------------------------------------------
	
	{
		
		for (int i = 0 ; i < words.length ; i++)
		{
			
			
			for (String s : Trie.keysWithPrefix(words[i]))
			{
				prefix_count[i]++;
			}
			
			prefix_count[i]--;
		}	
		
	}
	
	
	public static void reverseFind (String suffix, TrieST<Integer> Trie)
//----------------------------------------------------------
// Summary: prints all strings end with given suffix in your 
//         	Trie, lexicographically.
// Precondition: takes the input suffix and the Trie tree as 
//               parameters
// Postcondition: calls the "keysWithSuffix" method from the 
//                TrieST class and does the following:  
//                (1) It counts the number of words with
//                the given suffix and (2) creates an array 
//                according to the count number. Then, it 
//                (3) adds the suffixes to the initiated array
//                by calling the "keysWithSuffix" again in a 
//                for-each loop. Next, it (4) sorts the array 
//                using insertion sort and prints out the 
//                strings if there exists any strings
// 
// Note: check the "contains" method in the "Trie" class for
//       implementation details
//----------------------------------------------------------

	{
		// (1)
		
		int count = 0; 
		
		for (String s : Trie.keysWithSuffix(suffix))
		{
			count++;
		}

		// (2)
		
		String [] Strings_lexicographic  = new String[count];
		
		// (3)
		count = 0;
		
		for (String s : Trie.keysWithSuffix(suffix))
		{
			Strings_lexicographic[count] = s;
			count++;
		}
		
		
		// (4)
		
		if (count == 0)
		{
			System.out.println("No result");
		}
		
		else
		{
			insertionSort(Strings_lexicographic);
			
			for (int i = 0 ; i < count ; i++)
			{
				System.out.print(Strings_lexicographic[i] + " ");
			}
		}

		
	}
	
	
	
	private static void insertionSort(String[] strings) 
//--------------------------------------------------------
// Summary: Sorts an array of strings using the insertion 
//          sort algorithm.
// Precondition: The strings array is not null.
// Postcondition: The strings array is sorted in 
//                lexicographic order.
//--------------------------------------------------------
	{   
        int n = strings.length;
        
        // Iterate through each element in the array
        for (int i = 1; i < n; i++) {
            String key = strings[i];
            int j = i - 1;
            
            // Compare the key with previous elements and shift them if needed
            while (j >= 0 && strings[j].compareTo(key) > 0) {
                strings[j + 1] = strings[j];
                j--;
            }
            
            // Place the key in its correct position
            strings[j + 1] = key;
        }
    }

	
}















