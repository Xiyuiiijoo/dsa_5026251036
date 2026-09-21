package Lw01.unguided;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        List<Rental> rentals = new ArrayList<>();
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("src/Lw01/unguided/rentals.txt"));

        while (scanner.hasNext()){
            String type = scanner.next();
            String id   = scanner.next();
            int days    = scanner.nextInt();
            int units   = scanner.nextInt(); 

            if (type.equals("Laptop")){
                Rental laptop = new LaptopRental(id, days);
                rentals.add(laptop);
            } else {
                Rental projector = new ProjectorRental(id, days);
                rentals.add(projector);
            }
        }
        scanner.close();


        for (Rental output : rentals) {
            System.out.println(output.summary());
        }
    }
}
