package studentdatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
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
        
        ListOfStudents FullList = new ListOfStudents();
        
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
            String DataLine = br.readLine();
            
            //We make a new student and give ourselves some variables 
            //to work with
            Student newKid = new Student();
            String ID = "";
            String FName = "";
            String LName = "";
            int i = 0;
            
        //STUDENT NUMBER    
            //The first 5 spaces are student ID, no exceptions
            //Anything less we have an error (ADD ERROR CHECING)
            while(Character.isDigit(DataLine.charAt(i)) == true
                    && i<=4){
                ID = ID + Character.toString(DataLine.charAt(i));
            i++;
            }
            //Set the NewKids student number
            newKid.StudentNumber = Integer.parseInt(ID);
            
            
            
        //FIRST NAME    
            //As long as we see characters we have the first name
            //UNTIL we see a second uppercase letter or hit column 14
            while(Character.isLetter(DataLine.charAt(i)) == true
                    && i<=14){
              FName = FName + Character.toString(DataLine.charAt(i));
              
              //If the next character is Uppercase we've hit the last name
              //Signal a break
              if(Character.isUpperCase(DataLine.charAt(i+1))==true){
                  break;
              }
              i++;
            }
            newKid.FirstName = FName;
            
        //LAST NAME    
            //As long as we see characters we have the last name
            //UNTIL we see a second uppercase letter or hit column 24
            while(Character.isLetter(DataLine.charAt(i)) == true
                    && i<=24){
              LName = LName + Character.toString(DataLine.charAt(i));
              
              //If the next character is Uppercase we've hit the last name
              //Signal a break
              if(Character.isDigit(DataLine.charAt(i+1))==true){
                  break;
              }
              i++;
            }
            newKid.LastName = LName;
   

            //At the end, we add the newKid
            FullList.listofsets.add(newKid);
            
        } finally {         
            br.close();
        }
        
        
        System.out.println("Reading was successful\r");
        
        //Just print out the student number in that file
        System.out.println(FullList.listofsets.get(0).StudentNumber);
        System.out.println(FullList.listofsets.get(0).FirstName);
        System.out.println(FullList.listofsets.get(0).LastName);

    }
}


//SCRAP CODE
    /*
            while (line != null) {
                sb.append(line);
                sb.append('\n');
                line = br.readLine();
            } */

    /*        
        //FIRST NAME    
            //As long as we see characters we have the first name
            //UNTIL we see a second uppercase letter or hit column 14
            while(Character.isLetter(DataLine.charAt(i)) == true
                    && i<14){
              FName = FName + Character.toString(DataLine.charAt(i));
              
              //If the next character is Uppercase we've hit the last name
              //Signal a break
              if(Character.isUpperCase(DataLine.charAt(i+1))==true){
                  break;
              }
              i++;
            }
            newKid.FirstName = FName;
            
            */
            
            
            
            /*
            //The next 10 spaces are First Name
            //We need to account for names less than 10
            for(i = 5; i<14; i++){
                char hold = DataLine.charAt(i);
                Character.isLetter(hold);
                
                FName = FName + Character.toString(DataLine.charAt(i));
            }
            
            * */
            
            //String everything = sb.toString();
            //catchit = DataLine;