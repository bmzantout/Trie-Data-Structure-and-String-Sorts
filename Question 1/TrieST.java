package Assignment4_Q1;
import Assignment1_Q1.Queue;

public class TrieST<Value> {
	
	//-----------------------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout
	// ID: 99227947762
	// Section: 1
	// Assignment: 4
	// Description: This is a Trie class, which has the methods that 
	//              perform basic Trie operations based on the Trie data 
    //              structure. This class also depends on the Queue.java 
	//              class in its implementation
	//-----------------------------------------------------------------
	
	
	
//-------------------------------------------------------
// Attribute: Radix integer "R"
//-------------------------------------------------------		
	
	private static final int R = 256; 
	

//-------------------------------------------------------
// Attribute: root of Trie
//-------------------------------------------------------
		
	private Node root = new Node(); 
	
	
	 
/////////////////////////////////////// NESTED NODE CLASS ///////////////////////////////////////////////
	
	 private static class Node
	 {
		 private Object val;
		 private Node[] next = new Node[R];
	 }
	 
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
	 
	 
	 
	 public boolean contains(String key)
//--------------------------------------------------------
// Summary: Checks if the TrieST contains the given key.
// Precondition: The TrieST is not null. The key is a valid 
//               string.
// Postcondition: Returns true if the key is found, false 
//                otherwise.
//--------------------------------------------------------
	 
	 { 
		 return get(key) != null;
	 }
	 
	 
	 
	 
	 @SuppressWarnings("unchecked")
	public Value get(String key)
//--------------------------------------------------------
// Summary: Retrieves the value associated with the given 
//          key in the TrieST.
// Precondition: The TrieST is not null. The key is a valid 
//               string.
// Postcondition: Returns the value associated with the key,
//                or null if the key is not found.
//--------------------------------------------------------
	
	 {
		 Node x = get(root, key, 0);
		 if (x == null) return null;
		 return (Value) x.val;
	 }
	 
	 
	 private Node get(Node x, String key, int d)
//--------------------------------------------------------
// Summary: Returns the node associated with the key in 
//          the subtrie rooted at x.
// Precondition: The node x is not null. The key is a valid 
//               string. The index d is valid.
// Postcondition: Returns the node associated with the key,
//                or null if the key is not found.
//--------------------------------------------------------
	 { 
		// Return value associated with key in the subtrie rooted at x.
		 if (x == null) 
		 {
			 return null;
		 }
		 
		 if (d == key.length()) 
		 {
			 return x;
		 }
		 
		// Use dth key char to identify subtrie.
		 char c = key.charAt(d); 
		 
		 return get(x.next[c], key, d+1);
	 }
	 
	 
	 
	 public void put(String key, Value val)
//--------------------------------------------------------
// Summary: Inserts or updates a key-value pair in the 
//          TrieST.
// Precondition: The TrieST is not null. The key and value 
//               are valid.
// Postcondition: The key-value pair is added or updated in 
//                the TrieST.
//--------------------------------------------------------
	 
	 { 
		 root = put(root, key, val, 0);
	 }
	 
	 
	 
	 private Node put(Node x, String key, Value val, int d)
//--------------------------------------------------------
// Summary: Inserts or updates a key-value pair in the 
//          subtrie rooted at x.
// Precondition: The node x is not null. The key and value 
//               are valid. The index d is valid.
// Postcondition: The key-value pair is added or updated 
//                in the subtrie rooted at x.
//--------------------------------------------------------
	 { 
		// Change value associated with key if in subtrie rooted at x.
		 if (x == null) x = new Node();
		 
		 if (d == key.length()) 
		 { 
			 x.val = val; return x; 
		 }
		 
		// Use dth key char to identify subtrie.
		 char c = key.charAt(d); 
		 
		 x.next[c] = put(x.next[c], key, val, d+1);
		 
		 return x;
	 } 

	 
	 public Iterable<String> keys() 
//--------------------------------------------------------
// Summary: Returns an iterable of all keys in the TrieST.
// Precondition: The TrieST is not null.
// Postcondition: An iterable of all keys in the TrieST is 
//                returned.
//--------------------------------------------------------
	 
	 { 
		 return keysWithPrefix("");
	 }
	 
	 
	 
	 
	 
	 public Iterable<String> keysWithPrefix(String pre)
//--------------------------------------------------------
// Summary: Returns an iterable of keys that have the given
//          prefix in the TrieST.
// Precondition: The TrieST is not null. The prefix is a 
//               valid string.
// Postcondition: An iterable of keys with the given prefix 
//                is returned.
//--------------------------------------------------------
	 {
		  Queue<String> q = new Queue<String>();
		  collect(get(root, pre, 0), pre, q);
		  return q;
	 }
	 
	 
	 
	 private void collect(Node x, String pre, Queue<String> q) 
//--------------------------------------------------------
// Summary: Collects keys in the subtrie rooted at x that 
//          have the given prefix.
// Precondition: The node x is not null. The prefix is a 
//               valid string. The queue q is not null.
// Postcondition: The keys with the given prefix are 
//                collected in the queue q.
//--------------------------------------------------------
	 
	 {
		  if (x == null) 
		  {
			  return;
		  }
		  
		  if (x.val != null) 
		  {
			  q.enqueue(pre);
		  }
		  
		  for (char c = 0; c < R; c++)
		  {
			  collect(x.next[c], pre + c, q);
		  }
	 }

	 
	 public Iterable<String> keysWithSuffix(String suffix)
//--------------------------------------------------------
// Summary: Returns an iterable of strings in the Trie that
//          have the given suffix.
// Precondition: The TrieST is not null. The suffix is a 
//               valid string.
// Postcondition: An iterable of strings with the given 
//                suffix is returned.
//--------------------------------------------------------
    
	 {
		 Queue<String> q = new Queue<String>();
		 collectSuffix(root, "", suffix, q);
		 return q;
	}

	 
	 
		private void collectSuffix(Node x, String prefix, String suffix, Queue<String> q)
//--------------------------------------------------------
// Summary: Collects strings from the Trie that have the 
//          given suffix.
// Precondition: The TrieST is not null. The prefix and 
//               suffix are valid strings.
// Postcondition: The strings with the given suffix are 
//                added to the queue.
//--------------------------------------------------------
		    
		{
		
		    // Check if the current node is null
		    if (x == null) {
		        return;
		    }
		    
		    // Check if the suffix length is 0
		    if (suffix.length() == 0) {
		        // Check if the current node has a value
		        if (x.val != null) {
		            q.enqueue(prefix); // Enqueue the prefix to the queue
		        }
		        
		        // Recursively collect suffixes from child nodes
		        for (char c = 0; c < R; c++) {
		            collectSuffix(x.next[c], prefix + c, suffix, q);
		        }
		    } else {
		        // Recursively collect suffixes from child nodes
		        for (char c = 0; c < R; c++) {
		            collectSuffix(x.next[c], prefix + c, suffix, q);
		        }
		        
		        // Check if the current node has a value and the prefix ends with the suffix
		        if (x.val != null && prefix.endsWith(suffix)) {
		            q.enqueue(prefix); // Enqueue the prefix to the queue
		        }
		    }
		}

}
