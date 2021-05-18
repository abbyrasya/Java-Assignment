import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    Vector<Shoe> shoes = new Vector<>();

    Scanner scan = new Scanner(System.in);
    int choose;

    Boolean viewShoes() {
        if(shoes.size() == 0) {
            System.out.println("No Shoes Available");
            System.out.println("Press Enter To Continue");
            scan.nextLine();
            return false;
        }

        int i = 0;
        for(Shoe x : shoes) {
            System.out.println(i + x.getName());
            System.out.println("Category: " + x.getCategory());
            System.out.println("Release date: " + x.getDate());
            System.out.println("Price: " + x.getPrice());
            System.out.println();
        }

        System.out.println("Press Enter To Continue");
        scan.nextLine();

        return true;
    }

    Boolean checkDate(Date date, String dateTemp) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        format.setLenient(false);

        try {
            date = format.parse(dateTemp);
            return true;
        } catch (ParseException e) {
            return false;
        }

    }

    void addShoe() {
        String name;
        String category;
        String dateTemp;
        Date date = new Date();
        int price = 0;

        do {
            System.out.print("Input shoe's name [ends with \"shoe\"]: ");

            name = scan.nextLine();

            if(name.endsWith("shoe")) {
                break;
            }

        }while(true);

        do {
            System.out.print("Input shoe's category [Sneaker | Running | Boot] (Case Sensitive): ");

            category = scan.nextLine();

            if(category.equals("Running") || category.equals("Sneaker") || category.equals("Boot")) {
                break;
            }

        }while(true);

        do {
            System.out.print("input shoe's release date [dd-mm-yyyy]: ");

            dateTemp = scan.nextLine();

            if(checkDate(date, dateTemp)) {
                break;
            }

        }while(true);

        do {
            System.out.println("Input shoe's price [more than or equals to 5000]: ");

            try {
                price = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Input price");
            }

        }while(price < 5000);

        shoes.add(new Shoe(name, category, date, price));

    }

    void deleteShoe() {
        if(!viewShoes()) {
            return;
        }

        int total = shoes.size();

        int index = 0;
        do {
            System.out.print("Choose shoe's number to delete: ");

            try {
                index = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("Enter Correct Number");
            }

        }while(index < 1 || index > total);

        shoes.remove(index - 1);
        System.out.println("Shoe Removed");

    }

    void menu() {
        choose = 0;

        System.out.println("1. View Shoes");
        System.out.println("2. Add Shoe");
        System.out.println("3. Delete Shoe");
        System.out.println("4. Exit");

        do {
            System.out.print(">> ");

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
                viewShoes();
                break;
            case 2:
                addShoe();
                break;
            case 3:
                deleteShoe();
                break;
            case 4:
                return;
        }

        menu();
    }

    Main() {
        menu();
    }

    public static void main(String[] args) {
        new Main();
        System.out.println("Thank You For Using This Application");
    }

}
