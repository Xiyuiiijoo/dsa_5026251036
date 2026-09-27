package Lw02.prelab;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> daftarTransaksi = new LinkedList<>();
        LinkedList<String[]> daftarPelanggan = new LinkedList<>();
        Queue<String[]> antreanTransaksi = new LinkedList<>();
        Stack<String[]> transaksiGagal = new Stack<>();
        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        
        
        while (sc.hasNextLine()){
            String baris = sc.nextLine();
            String[] transaksi = baris.split(" ");
            daftarTransaksi.add(transaksi);
            boolean sudahAda = false;

            for (String[] pelanggan : daftarPelanggan){
                if(pelanggan[0].equals(transaksi[0])){
                    sudahAda = true;
                    break;
                }
            }
            if (!sudahAda){
                daftarPelanggan.add(new String[]{transaksi[0], "0"});
            }
        }
        sc.close();

        for (String[] transaksi : daftarTransaksi){
            antreanTransaksi.add(transaksi);
        }
        
        while(!antreanTransaksi.isEmpty()){
            String[]transaksi = antreanTransaksi.poll();

            for (String[] pelanggan : daftarPelanggan){
                if (pelanggan[0].equals(transaksi[0])){
                    int jumlah = Integer.parseInt(transaksi[2]);
                    int saldo = Integer.parseInt(pelanggan[1]);
                    if (transaksi[1].equals("DEPOSIT")){
                        saldo = saldo + jumlah;
                        pelanggan[1] = String.valueOf(saldo);
                    }
                    else if (transaksi[1].equals("WITHDRAW")){
                        if (jumlah > saldo) {
                            transaksiGagal.push(transaksi);
                        } else {
                            saldo = saldo - jumlah;
                            pelanggan[1] = String.valueOf(saldo);
                        }
                    }
                    break;
                }
            }
        }
        System.out.println("=== Final Balances ==="); // tampilan saldo akhir
        for(String[] pelanggan : daftarPelanggan){
            System.out.println(pelanggan[0] + " : " + pelanggan[1]);
        }

        System.out.println("=== Failed Transactions ==="); //untuk yang gagal
        while (!transaksiGagal.isEmpty()){
            String[] gagal = transaksiGagal.pop();
            System.out.println(gagal[0] + " " + gagal[1] + " " + gagal[2]);
        }

        
        

    }
}
