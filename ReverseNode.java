package com.divisiblity.rajat;

class Node{
	 Node next;
	 int value;
}
	// Time complexity: O(n) 
	// Space complexity: O(1)  
public class ReverseNode {

	public Node reverse(Node head)
	{
		  Node end = null;
		    Node current = head;
		    while (current != null) {
		        Node nextNode = current.next;
		        current.next = end ;
		        end  = current ;
		        current = nextNode;
		    }
		    return end;
	}	
}
