
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    Vector<Participant> participants = new Vector<>();
    Scanner scan = new Scanner(System.in);
    int choose = 0;

    Boolean sameUsername(String username) {
        for(Participant x : participants) {
            if(x.getUsername().equals(username)) {
                return true;
            }
        }

        return false;
    }

    Vector<Integer> getShuffleAndReverseNumber() {
        Vector<Integer> shuffleAndReverseNumber = new Vector<>();

        for(Participant x : participants) {
            shuffleAndReverseNumber.add(x.getNumber());
        }

        Collections.shuffle(shuffleAndReverseNumber);
        Collections.reverse(shuffleAndReverseNumber);

        return shuffleAndReverseNumber;
    }

    void sortParticipant() {
        Collections.sort(participants, (user1, user2) -> user1.getUsername().compareTo(user2.getUsername()));
    }

    void exitApplication() {

        if(participants.size() == 0) {
            return;
        }

        sortParticipant();
        Vector<Integer> number = getShuffleAndReverseNumber();

        System.out.println("Share List");
        System.out.printf("%-25s %-10s %s\n", "Username", "Before", "After");
        for(int i = 0; i < participants.size(); i++) {
            System.out.printf("%-25s %-10d %d\n",
                    participants.get(i).getUsername(), participants.get(i).getNumber(), number.get(i));
        }

    }

    void viewAll() {
        System.out.println("Share List");

        int i = 1;
        for(Participant x : participants) {
            System.out.println(i + " " + x.getUsername() + " " + x.getNumber());
            i++;
        }

    }

    void deleteParticipant() {

        int total = participants.size();

        if(total == 0) {
            System.out.println("No Participant");
            return;
        }

        viewAll();

        int index = 0;

        do {
            System.out.print("Which participant you would like to delete [1 - " + total + "][0 : exit]: ");
            try {
                index = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Enter A Number");
            }

        }while(index < 0 || index > total);

        if(index == 0) {
            return;
        }

        participants.remove(index - 1);
        System.out.println("Participant successfully removed from event");

    }

    void updateParticipant() {

        int total = participants.size();

        if(total == 0) {
            System.out.println("No Participant");
            return;
        }

        viewAll();

        int index = 0;

        do {
            System.out.print("Which participant you would like to update [1 - " + total + "][0 : exit]: ");
            try {
                index = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Enter A Number");
            }

        }while(index < 0 || index > total);

        if(index == 0) {
            return;
        }

        int number = 0;
        do {
            System.out.print("Enter A Number [0-100]: ");

            try {
                number = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Enter A Number");
            }

        }while(number < 0 || number > 100);

        participants.get(index - 1).setNumber(number);

        System.out.println("Update Successful!");
        scan.nextLine();

    }

    void startSharing() {
        String username;
        int number = 0;

        do {
            System.out.print("Enter A Number [0-100]: ");

            try {
                number = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Enter A Number");
            }

        }while(number < 0 || number > 100);

        do {
            System.out.print("Your Username [5 - 20 chars]: ");

            try {
                username = scan.next();
                scan.nextLine();

                if(sameUsername(username)) {
                    continue;
                }

                int len = username.length();

                if(len >= 5 && len <= 20) {
                    break;
                }

            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Enter A Number");
            }

        }while(true);

        participants.add(new Participant(username, number));



    }

    void menu() {
        choose =  0;

        System.out.println("1. Start Sharing");
        System.out.println("2. Update Participant");
        System.out.println("3. Delete Participant");
        System.out.println("4. Close App");

        do {
            System.out.print("Choice >> ");

            try {
                choose = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Enter A Number");
            }

        }while(choose < 1 || choose > 4);

        switch(choose) {
            case 1:
                startSharing();
                break;
            case 2:
                updateParticipant();
                break;
            case 3:
                deleteParticipant();
                break;
            case 4:
                exitApplication();
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
