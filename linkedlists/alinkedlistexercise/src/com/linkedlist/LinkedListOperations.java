package com.linkedlist;

import java.util.Scanner;

import com.linkedlist.LinkedListOperations.Node;

public class LinkedListOperations {

	class Node {
		int data;

		Node next;

		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}

	}

	public Node head = null;
	public Node tail = null;

	// addElement
	public void addNode(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;

		}

	}

	// search Element

	public void searchElement(int data) {

		int pos = 0;
		Node current = head;

		boolean flag = false;

		if (head == null) {
			System.out.println("List is Empty at search operation");

		}

		else {
			while (current != null) {
				if (current.data == data) {
					flag = true;
					break;
				} else {
					pos++;
					current = current.next;
				}
			}
		}

		if (flag) {
			System.out.println("The Element " + data + " at position " + (pos + 1) + " is found successfully");
		} else {
			System.out.println("The Element" + data + " not found");
		}
	}

//delete node
	public void deleteNode(int position) {

		if (head == null) {
			System.out.println("list is empty");
		}

		Node temp = head;

		if (position == 1) {
			head = temp.next;

		}

		for (int i = 2; temp != null && i < position; i++) {
			temp = temp.next;
		}

		if (temp == null || temp.next == null)

		{
			System.err.println("position is more than number of nodes ");
		} else {

			Node next = temp.next.next;

			temp.next = next;

		}
	}

//update at position

	public void updatePos(int position, int data) {
		try {

			if (head == null) {
				System.out.println("List is empty at updatePos()");
			}

			int i = 0;
			Node current = head;

			if ((position - 1) == 0) {
				head.data = data;

			} else {
				while (i <= (position - 1)) {

					if (i == (position - 1)) {

						current.data = data;
					}
					current = current.next;
					i++;
				}
			}
		} catch (NullPointerException ne) {
			System.err.println("Invalid position");
		}
	}

	// reverse the values
	public void reverse() {
		Node temp = head;
		Node previous = null;
		Node current = null;

		while (temp != null) {
			current = temp;
			temp = temp.next;

			current.next = previous;
			previous = current;
			head = current;

		}
	}

	// mergesort list
	public Node mergeTwoLinkList(Node lis1, Node lis2) {
		if (lis1 == null) {
			return lis2;

		}
		if (lis2 == null) {
			return lis1;

		}

		if (lis1.data < lis2.data) {
			lis1.next = mergeTwoLinkList(lis1.next, lis2);

			return lis1;
		} else {
			lis2.next = mergeTwoLinkList(lis1, lis2.next);
			return lis2;
		}
	}

	// bubblesort data

	public void bubbleSort() {

		Node current = head;
		Node nodeNext = null;
		int temp;
		if (head == null) {
			System.out.println("list is empty");
		}

		else {

			while (current != null) {
				nodeNext = current.next;
				while (nodeNext != null) {

					if (current.data > nodeNext.data) {
						temp = current.data;
						current.data = nodeNext.data;
						nodeNext.data = temp;

					}
					nodeNext = nodeNext.next;

				}
				current = current.next;

			}
		}
	}
	// referreence val

	public void refer(int position) {
		try
		{
		Node current = head;
		int i = 0;
		if (position == 1) {
			System.out.println("reference object data at position " + position + " is " + head.next);
		} else {
			while (i < position) {
				if (i == (position - 1)) {
					System.out.println("reference object data at position " + position + " is " + current.next +"hash code ");
				}
				current = current.next;
				i++;
			}
		}
		}catch (Exception e) {
			System.out.println("null");
		}

	}

	// display nodes
	public void display() {

		Node current = head;
		try {
			if (head == null) {
				System.out.println("List is empty at display");
				return;
			}
			System.out.println("Nodes of singly linked list: ");
			while (current != null) {

				System.out.print(current.data + " ");

				current = current.next;
			}
			System.out.println();
		} catch (Exception e) {
			System.err.println("null values");
		}
	}
	
	//findind and removing looping
	
	// Function that detects loop in the list 
    int detectAndRemoveLoop(Node node) 
    { 
        Node slow = node, fast = node; 
        while (slow != null && fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
  
            // If slow and fast meet at same point then loop is present 
            if (slow == fast) { 
                removeLoop(slow, node); 
                return 1; 
            } 
        } 
        return 0; 
    } 
  
    // Function to remove loop 
    void removeLoop(Node loop, Node curr) 
    { 
        Node ptr1 = null, ptr2 = null; 
  
        /* Set a pointer to the beginning of the Linked List and 
         move it one by one to find the first node which is 
         part of the Linked List */
        ptr1 = curr; 
        while (1 == 1) { 
  
            /* Now start a pointer from loop_node and check if it ever 
             reaches ptr2 */
            ptr2 = loop; 
            while (ptr2.next != loop && ptr2.next != ptr1) { 
                ptr2 = ptr2.next; 
            } 
  
            /* If ptr2 reahced ptr1 then there is a loop. So break the 
             loop */
            if (ptr2.next == ptr1) { 
                break; 
            } 
  
            /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
            ptr1 = ptr1.next; 
        } 
  
        /* After the end of loop ptr2 is the last node of the loop. So 
         make next of ptr2 as NULL */
        ptr2.next = null; 
    } 
    
    // Function to print the linked list 
    void printList(Node node) 
    { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
  
  
   
	public static void main(String[] args) {

		char ch;

		LinkedListOperations llo = new LinkedListOperations();
		LinkedListOperations llo2 = new LinkedListOperations();
		// LinkListeOperationsTwo lpt = new LinkListeOperationsTwo();

		llo.addNode(5);

		llo.addNode(9);
		llo.addNode(7);
		llo.addNode(9);
		llo.addNode(17);
		llo2.addNode(35);

		llo2.addNode(9);
		llo2.addNode(27);
		 
		
		// llo.refer(2);
		// llo.reverse();
		// System.out.println("reverse order");

		
		do {
			System.out.println("Enter the order number to perform operation on LinkedList : ");
			System.out.println(".........................1.Display Nodes................................");
			System.out.println(".........................2.Add element.................................");
			System.out.println(".........................3.Search Node.................................");
			System.out.println(".........................4.Update element at position......................");
			System.out.println(".........................5.Delete element at position.......................");
			System.out.println(".........................6.Finding reference for position................");
			System.out.println(".........................7.Reversing the elements.........................");
			System.out.println(".........................8.Sorting Linked List using Bubble sort...........");
			System.out.println(".........................9.Merging of sorted Linked List.................");
			System.out.println(".........................10.Finding and removing cycles.................");
			
			Scanner sc = new Scanner(System.in);
			
			int x = sc.nextInt();

			switch (x) {

			case 1:
				llo.display();
				break;
			case 2:
				System.out.println("Add Elements");
				Scanner scc = new Scanner(System.in);
				llo.addNode(scc.nextInt());
				break;
			case 3:
				System.out.println("Enter Element to Search ");
				Scanner scm = new Scanner(System.in);
				llo.searchElement(scm.nextInt());
				break;
			case 4:
				System.out.println("Enter Position and Element to update ");
				Scanner scg = new Scanner(System.in);
				llo.updatePos(scg.nextInt(), scg.nextInt());
				break;

			case 5:
				System.out.println("Enter the position to delete");
				Scanner scx = new Scanner(System.in);
				llo.deleteNode(scx.nextInt());
				break;
			case 6:
				System.out.println("Enter the position to get reference object");
				Scanner scx1 = new Scanner(System.in);
				llo.refer(scx1.nextInt());
				break;	
			case 7:
				System.out.println("Elements in reverse order is !..");
				
				llo.reverse();
				llo.display();
				break;	
			case 8:
				System.out.println("Elemets in sorted list");
				llo.bubbleSort();
				llo.display();
				break;	
				
			case 9:
				System.out.println("Merge sorted lists ..");
				llo.head = llo.mergeTwoLinkList(llo.head, llo2.head);
				llo.display();
				break;		
			case 10:
				System.out.println("finding and removing cycles from linked list..");
				llo.display();
				//Node no = llo.head;
				llo.head.next.next.next.next.next = llo.head.next.next; 
				
				llo.detectAndRemoveLoop(llo.head);
				
				 System.out.println("Linked List after removing loop : ");
				 
				llo.display();
				break;		
			default:
				System.out.println("Wrong input\n");
			}
			System.out.println("Do you want to continue ? (Y/N)");
			Scanner acb = new Scanner(System.in);
			ch = acb.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');
	}

}
