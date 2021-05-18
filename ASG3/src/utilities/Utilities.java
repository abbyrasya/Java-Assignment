package utilities;

import main.Audience;
import main.Main;

import java.util.Scanner;

public class Utilities {

	public static int [] allID = new int[100000];

	public static Scanner scan = new Scanner(System.in);

	public static int findID() {
		int ID;
		System.out.print("Tickets ID [5 digits number]: ");
		ID = Utilities.scan.nextInt();
		Utilities.scan.nextLine();
		return ID;
	}

	public static Boolean checkFriend(int ID) {
		return allID[ID] == 1;
	}

	public static Boolean getHasFriend(String has) {
		return has.equals("yes");
	}

	public static Boolean checkHasFriend(String has) {
		return has.equals("yes") || has.equals("no");
	}

	public static Boolean checkAllIDNumber(int ID) {
		Audience curr = Main.head;

		while(curr != null) {
			if(curr.getID() == ID) {
				return false;
			}
			curr = curr.next;
		}

		return true;
	}

	public static Boolean checkIDNumber(Integer ID) {
		String tempID = ID.toString();
		int len = tempID.length();

		if(len > 5) {
			return false;
		}

		if(allID[ID] == 0 && checkAllIDNumber(ID)) {
			allID[ID] = 1;
			return true;
		}
		return false;
	}

	public static Boolean checkName(String name) {
		return name.length() >= 2 && name.length() <= 20;
	}

}
