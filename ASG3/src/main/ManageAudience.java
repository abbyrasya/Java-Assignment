package main;

import utilities.Utilities;

public class ManageAudience {

	private static Audience createNode() {
		Audience newNode = new Audience();
		newNode.next = newNode.prev = null;
		return newNode;
	}

	public static void viewAll() {
		Audience curr = Main.head;
		while(curr != null) {
			System.out.printf("%-25s %05d\n", curr.getName(), curr.getID());
			curr = curr.next;
		}
		System.out.println();
	}

	public static void insertAudience() {

		Audience head = Main.head, tail = Main.tail;

		Audience newNode = createNode();

		if(head == null) {
			Main.head = Main.tail = newNode;
		}

		else if(newNode.getHasFriend()) {
			if(head.getID() == newNode.getFriendID()) {
				if(head == tail) {
					tail.next = newNode;
					newNode.prev = tail;
					Main.tail = newNode;
					return;
				}

				head.next.prev = newNode;
				newNode.next = head.next;

				head.next = newNode;
				newNode.prev = head;
			}

			else if(tail.getID() == newNode.getFriendID()) {
				tail.next = newNode;
				newNode.prev = tail;
				Main.tail = newNode;
			}

			else {
				Audience curr = head;

				while(curr.getID() != newNode.getFriendID()) {
					curr = curr.next;
				}

				curr.next.prev = newNode;
				newNode.next = curr.next;

				curr.next = newNode;
				newNode.prev = curr;
			}

		}

		else {
			tail.next = newNode;
			newNode.prev = tail;
			Main.tail = newNode;
		}

	}

	public static void popHead() {
		if(Main.head == null) {
			System.out.println("No Audience");
			return;
		}

		Audience head = Main.head, tail = Main.tail;

		System.out.println(head.getName() + " enter the Concert Hall");

		if(head == tail) {
			Main.head = Main.tail = null;
		}

		else {
			head = head.next;
			head.prev = null;
			Main.head = head;
		}
	}

	public static void searchQueue() {
		if(Main.head == null) {
			System.out.println("No Audience");
			return;
		}

		int ID = Utilities.findID();

		Audience curr = Main.head;

		for(int i = 1; curr != null; i++) {
			if(curr.getID() == ID) {
				System.out.println("Queue Number: " + i);
				return;
			}
			curr = curr.next;
		}
		System.out.println("Queue Number Not Found");
	}

	public static void updateAudience() {
		if(Main.head == null) {
			System.out.println("No Audience");
			return;
		}

		int ID = Utilities.findID();

		Audience curr = Main.head;

		while(curr.getID() != ID) {
			curr = curr.next;
			if(curr == null) {
				System.out.println("ID not Found");
				return;
			}
		}

		curr.setName();
	}

	public static void removeAll() {
		Audience head = Main.head;
		while(head != null) {
			Audience next = head.next;
			head.prev = head.next = null;
			head = next;
		}
		Main.head = Main.tail = null;
	}

}
