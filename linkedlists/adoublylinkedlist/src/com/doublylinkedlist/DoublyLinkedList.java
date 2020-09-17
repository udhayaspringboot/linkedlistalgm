package com.doublylinkedlist;

import java.util.Scanner;



public class DoublyLinkedList {

		class Node {
			int data;
			Node previous;
			Node next;

			public Node(int data) {

				this.data = data;

			}

		}

		// add Element
		public Node head = null;
		public Node tail = null;

		public void addNode(int data) {
			Node node = new Node(data);

			if (head == null) {
				tail = node;
				head = tail;
				head.previous = null;
				tail.next = null;
			} else {
				tail.next = node;
				node.previous = tail;
				tail = node;
				tail.next = null;

			}
		}

		// search element

		public void searchNode(int data) {
			Node current = head;
			boolean flag = false;
			if (head == null) {
				System.out.println("List is empty");
			}
			int i = 0;
			while (current != null) {
				if (current.data == data) {
					flag = true;
					break;
				}
				current = current.next;
				i++;
			}

			if (flag) {
				System.out.println("The Element " + data + " is found at " + (i + 1) + " position");
			} else {
				System.out.println("The Element is not found");
			}
		}

		// delete node

		public void deleteFromStart()

		{
			if (head == null) {
				System.out.println("List Empty");
			} else {
				if (head != tail) {
					head = head.next;
					head.previous = null;
				} else {
					tail = null;
					head = null;
				}

			}
		}

		// update
		public void updatePos(int position, int data) {
			try
			{
			if (head == null) {
				System.out.println("List is empty");
			}
			Node current = head;

			int i = 0;
			
			if(position==1)
			{
				head.data=data;
			}
			while (i < position) {

				if (i == (position - 1)) {
					current.data = data;

				}
				current = current.next;
				i++;
			}}catch(NullPointerException ne)
			{
				System.err.println("Invalid position at updatePos()");
			}
		}
		// update after element

		public void updateAfter(int position, int data) {
			
			try
			{
			if (head == null) {
				System.out.println("List is empty");
			}

			int i = 0;
			Node current = head;
			while (i <= position) {
				if (position == 0) {
					head.data = data;
					break;
				} else {
					current = current.next;
					if (i == (position - 1)) {
						current.data = data;
					}
				}
				i++;
			}
			}catch(NullPointerException ne)
			{
				System.err.println("Invalid position at updateAffter()");
			}
		}


		// update Before

		public void updateBefore(int position, int data) {
			try
			{
			if (head == null) {
				System.out.println("List is Empty");

			}
			int i = 0;
			Node current = head;
			while (i <= position) {
				current = current.next;
				if ((position - 1) == 0) {
					head.data = data;
					break;
				} else {
					if (i == (position - 1)) {
						current.previous.previous.data = data;
					}
				}
				i++;
			}}catch(NullPointerException ne)
			{
				System.err.println("Invalid position at updateBefore()()");
			}
		}

		// delete from last

		public void deleteFromEnd() {
			if (head == null) {
				System.out.println("List is empty");
			} else {
				if (head == tail) {
					tail = head = null;
				} else if (tail != null) {
					tail = tail.previous;
					tail.next = null;
				}
			}
		}

		//reverse
		
		
		public void reverseDList()
		{
			Node temp = null; 
	        Node current = head; 
	        
	       
	  
	        /* swap next and prev for all nodes of  
	         doubly linked list */
	        while (current != null) { 
	            temp = current.previous; 
	            current.previous = current.next; 
	            current.next = temp; 
	            current = current.previous; 
	        }
	        
	        if (temp != null) { 
	            head = temp.previous; 
	        } 
		}
		
		// traverse or display all values

		public void display() {
			Node current = head;
			if (head == null) {
				System.out.println("List is Empty");
			}

			System.out.println("Nodes in Doubly Linked List");
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();
		}

		public static void main(String[] args) {

			char ch;
			DoublyLinkedList dls = new DoublyLinkedList();

			dls.addNode(2);
			dls.addNode(6);
			dls.addNode(1);
			dls.addNode(8);
			dls.addNode(4);
			dls.addNode(4);
			dls.display();
			dls.reverseDList();
			dls.display();

			do {
				System.out.println("Enter the order number to perform operation on LinkedList : ");
				System.out.println(".........................1.Display Nodes................................");
				System.out.println(".........................2.Add element.................................");
				System.out.println(".........................3.Search Node.................................");
				System.out.println(".........................4.reverse elements.....................");
				System.out.println(".........................5.Update element at position......................");
				System.out.println(".........................6.Delete Node from start.......................");
				System.out
						.println(".........................7.Delete Node from end................");
				
				System.out.println(
						".........................8.update element before to the specified position.................");
				System.out.println(
						".........................9.update element after to the specified position.................");
				

				Scanner sc = new Scanner(System.in);

				int x = sc.nextInt();

				switch (x) {

				case 1:
					dls.display();
					break;
				case 2:
					System.out.println("Add Elements");
					Scanner scc = new Scanner(System.in);
					dls.addNode(scc.nextInt());
					break;
				case 3:
					System.out.println("Enter Element to Search ");
					Scanner scm = new Scanner(System.in);
					dls.searchNode(scm.nextInt());
					break;
					
				case 4:System.out.println("reverse elements ");
				        dls.reverseDList();
				        dls.display();
				        break;
					
				case 5:
					System.out.println("Enter Position and Element to update ");
					Scanner scg = new Scanner(System.in);
					dls.updatePos(scg.nextInt(), scg.nextInt());break;
					
				case 6:dls.deleteFromStart(); System.out.println("Node deleted from start");break;
				case 7:dls.deleteFromEnd();System.out.println("Node deleted from end");break;
					
				case 8:
					System.out.println("Enter Position and Element to update ");
					Scanner svx = new Scanner(System.in);
					dls.updateBefore(svx.nextInt(), svx.nextInt());break;
				case 9:
					System.out.println("Enter Position and Element to update ");
					Scanner sza = new Scanner(System.in);
					dls.updateAfter(sza.nextInt(), sza.nextInt());break;
				default:
					System.out.println("Wrong input\n");
					
				}
				System.out.println("Do you want to continue ? (Y/N)");
				
				Scanner acb = new Scanner(System.in);
				ch = acb.next().charAt(0);
			} while (ch == 'y' || ch == 'Y');

		}

	


}
