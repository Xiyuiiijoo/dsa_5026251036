package Lw03.unguided;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        int gagal = 0;
        Map<String, Integer> enrollment = new LinkedHashMap<> ();
        List<String> list = new ArrayList<>();
        System.out.println("===== Enrollment Checks =====");
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String [] bagian = line.split(" ");
            String perintah = bagian[0];
            String matkul = bagian[1];
            
            if(perintah.equals("REGISTER")){
                int jumlah = Integer.parseInt(bagian[2]);
                if(jumlah <= 0){
                    gagal++;
                }
                
                if(enrollment.containsKey(matkul)){
                    int current = enrollment.get(matkul);
                    enrollment.put(matkul, current + jumlah);
                } else {
                    enrollment.put(matkul, jumlah);
                }
            } else if (perintah.equals("WITHDRAW")){
                int jumlah = Integer.parseInt(bagian[2]);
                if (enrollment.containsKey(matkul) 
                    && enrollment.get(matkul) >= jumlah){
                        int current = enrollment.get(matkul);
                        enrollment.put(matkul, current - jumlah);
                } else {
                    gagal++;
                }
            } else if (perintah.equals("CHECK")){
                
                if(enrollment.containsKey(matkul)){
                    System.out.println(matkul + ": " + enrollment.get(matkul));
                } else {
                    System.out.println(matkul + ": not found");
                }
            }
        }
        sc.close();
        
        System.out.println("\n===== Final Enrollment =====");
        for (String namaMatkul : enrollment.keySet()) {
            System.out.println(namaMatkul + ": " + enrollment.get(namaMatkul));
        }
        


        System.out.println("\nRejected operations: " + gagal);
    }
}
