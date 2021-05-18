package main;

import utilities.Utilities;

public class Main {

	public static Audience head = null, tail = null;

	void registerAudience() {
		ManageAudience.insertAudience();
	}

	void enterConcertHall() {
		ManageAudience.popHead();
	}

	void searchQueueNumber() {
		ManageAudience.viewAll();
		ManageAudience.searchQueue();
	}

	void updateAudienceData() {
		ManageAudience.viewAll();
		ManageAudience.updateAudience();
	}

	void removeAllAudience() {
		ManageAudience.removeAll();
	}

	void menu(){
		ManageAudience.viewAll();
		System.out.println("1. Register New Audience");
		System.out.println("2. Enter The Concert Hall");
		System.out.println("3. Search Queue Number");
		System.out.println("4. Update Audience Data");
		System.out.println("5. Exit");

		int choose;

		do {
			System.out.print(">> ");
			choose = Utilities.scan.nextInt();
			Utilities.scan.nextLine();
		}while(choose < 1 || choose > 5);

		switch(choose) {
			case 1:
				registerAudience();
				break;
			case 2:
				enterConcertHall();
				break;
			case 3:
				searchQueueNumber();
				break;
			case 4:
				updateAudienceData();
				break;
			case 5:
				removeAllAudience();
				return;
		}

		menu();
	}

	Main() {
		menu();
	}

	public static void main(String[] args) {
		new Main();
	}

}
