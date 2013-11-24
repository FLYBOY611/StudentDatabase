package studentdatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StudentDatabase {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        System.out.println("Welcome to the Student Database Program!");
        System.out.println("This program will take database information "
                + "from a text file and manipulate it in many ways.");
        System.out.println("Please be sure that the student information "
                + "file is in the same directory as this program.");
        System.out.println("Let's start by reading in that file!\r");
        System.out.println("Please enter the full name of the "
                + "student information file:");
        
        //Take the name of the file from the user
        Scanner input1 = new Scanner(System.in);
        String selector = input1.nextLine();

        System.out.println("\rReading...");
        
        //A Try-Catch block is necessary to read in a file
        //We will eventually have this create every new student    
        BufferedReader br = new BufferedReader(new FileReader(selector));
        String catchit;     
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append('\n');
                line = br.readLine();
            }
            String everything = sb.toString();
            catchit = everything;
        } finally {         
            br.close();
        }
        System.out.println("Reading was successful\r");
        
        //Just print out everything in that file
        System.out.println(catchit);

    }
}
