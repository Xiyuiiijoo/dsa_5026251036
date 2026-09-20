package Lw01.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<PrintJob> printJobs = new ArrayList<>();

        try {
            File jobsFile = new File("src/Lw01/prelab/jobs.txt");

            Scanner scanner = new Scanner(jobsFile);

            while (scanner.hasNext()) {
                String printType = scanner.next();
                String jobId = scanner.next();
                int totalPages = scanner.nextInt();

                if (printType.equals("MONO")) {
                    PrintJob monoJob = new MonoPrint(jobId, totalPages);
                    printJobs.add(monoJob);
                } else if (printType.equals("COLOUR")) {
                    PrintJob colourJob = new ColourPrint(jobId, totalPages);
                    printJobs.add(colourJob);
                }
            }

            scanner.close();

            for (PrintJob printJob : printJobs) {
                System.out.println(printJob.summary());
            }

        } catch (FileNotFoundException error) {
            System.out.println("File jobs.txt tidak ditemukan.");
        }
    }
}