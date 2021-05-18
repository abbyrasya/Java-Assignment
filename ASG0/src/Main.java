import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static Integer firstNumber = 0;
    static Integer secondNumber = 0;
    static Boolean p1;
    static Boolean p2;

    void secondApplication() {
        do {
            System.out.print("Give me value for p1 [true : false] : ");

            try {
                p1 = scan.nextBoolean();
                scan.nextLine();
                break;
            } catch (Exception e) {
                scan.nextLine();
            }

        }while(true);

        do {
            System.out.print("Give me value for p2 [true : false] : ");

            try {
                p2 = scan.nextBoolean();
                scan.nextLine();
                break;
            } catch (Exception e) {
                scan.nextLine();
            }

        }while(true);

        System.out.printf("P1: %-5s P2: %s\n", p1 ? "T" : "F", p2 ? "T" : "F");
        System.out.printf("%-5s %-5s %-5s %-5s\n", "!P1", "!P2", "&&", "||");
        System.out.printf("%-5b %-5b %-5b %-5b\n", !p1, !p2, p1 && p2, p1 || p2);

    }

    void firstApplication() {
        do {
            System.out.print("Input The First Number [1 - 100] (Inclusive): ");

            try {
                firstNumber = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Enter A Number");
            }

        }while(firstNumber < 1  || firstNumber > 100);

        do {
            System.out.print("Input The Second Number [1 - 100] (Inclusive): ");

            try {
                secondNumber = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Enter A Number");
            }

        }while(secondNumber < 1  || secondNumber > 100);

        System.out.printf("%-20s %-20s %-20s %-20s %s\n",
                "+ (String Type)", "(Character Type)", "* (Integer Type)", "/ (Floating Type)",
                "Input 1 == Input 2 (Boolean Type)");

        String stringType = firstNumber.toString() + " + " + secondNumber.toString();

        Character firstNumberChar = (char)firstNumber.intValue();
        Character secondNumberChar = (char)secondNumber.intValue();
        String charType = firstNumberChar + " " + secondNumberChar;

        Integer firstXsecond = firstNumber * secondNumber;
        String intType = firstXsecond.toString();

        Float firstBBsecond = firstNumber.floatValue() / secondNumber.floatValue();
        String floatType = firstBBsecond.toString();

        Boolean checkSame = (firstNumber == secondNumber);
        String booleanType = checkSame.toString();

        System.out.printf("%-20s %-20s %-20s %-20s %s\n",
                stringType, charType, intType, floatType, booleanType);

        System.out.println();

        System.out.printf("%-20s %-20s %-20s %-20s %s\n", "+", "-", "*", "/", "%");
        System.out.printf("%-20d %-20d %-20d %-20d %d\n",
                firstNumber + secondNumber,
                firstNumber - secondNumber, firstNumber * secondNumber,
                firstNumber / secondNumber, firstNumber % secondNumber);

        System.out.println();

        System.out.println("Press Enter To Proceed...");
        scan.nextLine();

        secondApplication();
    }

    void menu() {

        int c = 0;

        do {
            System.out.println("1. Start The Application");
            System.out.println("2. Close App");
            System.out.print("Choose >> ");

            try {
                c = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Enter A Number");
            }


        }while(c < 1 || c > 2);

        switch(c) {
            case 1:
                firstApplication();
                break;
            case 2:
                return;
        }

        menu();
    }

    Main() {
        menu();

    }

    public static void main(String[] args) {
        new Main();
        System.out.println("\nThank You");
    }

}
