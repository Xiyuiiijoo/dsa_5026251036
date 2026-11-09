package Lw04.unguided;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));
        
        int besarArray = sc.nextInt();
        int[] arrayRaka = new int[besarArray];

        for(int i = 0; i < besarArray; i++){
            arrayRaka[i] = sc.nextInt();
        }
        //sortink selection
        for(int i = 0; i < 2; i++){
            int min = i;
            for(int j = i + 1; j < arrayRaka.length; j++){
                if(arrayRaka[j] < arrayRaka[min]){
                    min = j;
                }
            }
            int sementara = arrayRaka[min];
            arrayRaka[min] = arrayRaka[i];
            arrayRaka[i] = sementara;
        }
        for(int i = 0; i < arrayRaka.length; i++){
            System.out.print(arrayRaka[i] + " ");
        }
        System.out.println();
        
        //sercing
        int jumlahCari = sc.nextInt();
        int[] arrayCari = new int[jumlahCari];
        for(int i = 0; i < jumlahCari; i++){
            arrayCari[i] = sc.nextInt();
        }
        for(int i = 0; i < arrayCari.length; i++){
        boolean ada = false;
            for(int j = 0; j < arrayRaka.length; j++){
                if(arrayRaka[j] == arrayCari[i]){
                    System.out.println(arrayCari[i] +": " + "FOUND at INDEX " + j);
                    ada = true;
                    break;
                }
            }
            if(!ada){
                    System.out.println(arrayCari[i] +": " + "NOT FOUND");
                }
                
        }
    }
}
