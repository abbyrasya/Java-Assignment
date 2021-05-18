package main;

import utilities.Utilities;

public class Audience {

	private String name;
	private int ID;
	private Boolean hasFriend;
	private int friendID;

	public Audience prev, next;

	public Audience() {
		setName();
		setID();
		setHasFriend();
	}

	public void setFriendID() {
		do {
			System.out.print("Friend's Ticket ID [5 digits number]: ");
			friendID = Utilities.scan.nextInt();
			Utilities.scan.nextLine();
		}while(!Utilities.checkFriend(friendID));
	}

	public void setHasFriend() {
		String temp;
		do {
			System.out.print("Do you have a friend in the queue [yes / no]: ");
			temp = Utilities.scan.nextLine();
		}while(!Utilities.checkHasFriend(temp));
		hasFriend = Utilities.getHasFriend(temp);
		if(hasFriend) {
			setFriendID();
		}

		else {
			friendID = -1;
		}
	}

	public void setName() {
		do {
			System.out.print("Audience Name [2 - 20 Characters]: ");
			name = Utilities.scan.nextLine();
		}while(!Utilities.checkName(name));
	}

	public void setID() {
		do {
			System.out.print("Tickets ID [5 digits number]: ");
			ID = Utilities.scan.nextInt();
			Utilities.scan.nextLine();
		}while(!Utilities.checkIDNumber(ID));
	}

	public Boolean getHasFriend() {
		return hasFriend;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return ID;
	}

	public int getFriendID() {
		return friendID;
	}

}
