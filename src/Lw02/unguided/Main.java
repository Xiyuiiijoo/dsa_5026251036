package Lw02.unguided;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> daftarPermintaan = new LinkedList<>();
        LinkedList<String[]> buku = new LinkedList<>();
        LinkedList<String[]> member = new LinkedList<>();
        Queue<String[]> antreanPermintaan = new LinkedList<>();
        Stack<String[]> permintaanGagal = new Stack<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        while (sc.hasNext()) {
            String nama = sc.next();
            String jenisBuku = sc.next();
            String[] permintaan = new String[]{nama, jenisBuku};
            daftarPermintaan.add(permintaan);

            boolean sudahAda = false;
            
            for(String[] pendatang : daftarPermintaan){
                if(pendatang[0].equals(permintaan[0])){
                    sudahAda = true;
                    break;
                }
            }
            if (!sudahAda){
                daftarPermintaan.add(new String[]{permintaan[0], "0"});
            }
        }
        sc.close();
        
        int countFisika = 0;
        int countStatistika = 0;
        int countKalkulus = 0;
        
        for (String[] permintaan : daftarPermintaan){
            antreanPermintaan.add(permintaan);
        }

        while(!antreanPermintaan.isEmpty()){
            String[] permintaan = antreanPermintaan.poll();

            for(String[] pendatang : daftarPermintaan){
                if(pendatang[0].equals(permintaan[0])){
                    
                    if(permintaan[1].equals("Fisika")){
                        countFisika ++;
                        
                    }
                    else if(permintaan[1].equals("Statistika")){
                        countStatistika ++;
                    }
                    else {
                        countKalkulus ++;
                    }
                    
                    break;
                }
            }
        }


    }
}
