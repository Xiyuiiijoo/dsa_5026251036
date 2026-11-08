package Lw04.prelab;
import java.util.*;

public class main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(main.class.getResourceAsStream("branches.txt"));

        int jumlahBranches = sc.nextInt();
        int[] arrayBranches = new int[jumlahBranches];

        for(int i = 0; i < jumlahBranches; i++){
            arrayBranches[i] = sc.nextInt();
        }

        //sorting
        for(int i = 1; i <= 3; i++){
            int Key = arrayBranches[i];
            int j = i-1;
            while(j >= 0 && Key > arrayBranches[j]){
                arrayBranches[j+1] = arrayBranches[j];
                j--;
            }
            arrayBranches[j+1] = Key;
        }
        for(int i = 0; i < arrayBranches.length; i++){
            System.out.print(arrayBranches[i] + " ");
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
            for(int j = 0; j < arrayBranches.length; j++){
                if(arrayBranches[j] == arrayCari[i]){
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