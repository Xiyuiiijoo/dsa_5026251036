package Lw03.prelab;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Problem 1 ===");
        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist = new LinkedList<>();
        while (sc.hasNext()) {
            String baris = sc.nextLine();
            String[] bagian = baris.split(" ", 2);
            String perintah = bagian[0];
            String judulLagu = bagian[1];
            if (perintah.equals("ADD")) {
                playlist.add(judulLagu);
            } else if (perintah.equals("INSERT")) {
                String[] subBagian = judulLagu.split(" ", 2);
                int index = Integer.parseInt(subBagian[0]);
                String lagu = subBagian[1];
                playlist.add(index, lagu);
            } else if (perintah.equals("REMOVE")) {
                playlist.remove(judulLagu);
            }
        }
        sc.close();
        System.out.println("Total Songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        System.out.println("\n=== Problem 2 ===");
        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> namaUnik = new HashSet<>();
        int jumlahDuplikat = 0;
        while (sc2.hasNextLine()) {
            String nama = sc2.nextLine().trim();
            if (!nama.isEmpty()) {
                if (!namaUnik.add(nama)) {
                    jumlahDuplikat++;
                }
            }
        }
        sc2.close();
        List<String> listNama = new ArrayList<>(namaUnik);
        System.out.println("Unique participants: " + namaUnik.size());
        for (int i = 0; i < namaUnik.size(); i++) {
            System.out.println((i + 1) + ". " + listNama.get(i));
        }
        System.out.println("Duplicate registrations: " + jumlahDuplikat);

        System.out.println("\n=== Problem 3 ===");
        Map<String, Integer> inventori = new LinkedHashMap<>();
        Scanner sc3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        int gagalJual = 0;
        while (sc3.hasNextLine()) {
            String line = sc3.nextLine();
            String[] part = line.split(" ");
            String order = part[0];                  
            String namaBarang = part[1];             
            int jumlah = Integer.parseInt(part[2]);  
            if (order.equals("ADD")) {
                if (inventori.containsKey(namaBarang)) {
                    int stokLama = inventori.get(namaBarang);
                    inventori.put(namaBarang, stokLama + jumlah);
                } else {
                    inventori.put(namaBarang, jumlah);
                }

            } else if (order.equals("SELL")) {
                if (inventori.containsKey(namaBarang)
                        && inventori.get(namaBarang) >= jumlah) {
                    int stokLama = inventori.get(namaBarang);
                    inventori.put(namaBarang, stokLama - jumlah);
                } else {
                    gagalJual++;
                }
            }
        }
        sc3.close();
        for (String namaBarang : inventori.keySet()) {
            System.out.println(namaBarang + ": " + inventori.get(namaBarang));
        }
        System.out.println("Failed sales: " + gagalJual);
    }
}