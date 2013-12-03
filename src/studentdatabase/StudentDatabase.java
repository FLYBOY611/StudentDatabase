package studentdatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentDatabase {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.println("Welcome to the Student Database Program!");
        System.out.println("This program will take database information "
                + "from a text file and manipulate it in many ways.");
        System.out.println("Please be sure that the student information "
                + "file is in the same directory as this program.");
        System.out.println("Let's start by reading in that file!");
        System.out.println("(Hint: the included file is named file.txt)\r");
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

            while (DataLine != null) {

                //We make a new student and give ourselves some variables 
                //to work with
                Student newKid = new Student();
                int i = 0;
                String ID = "";
                String FName = "";
                String LName = "";
                String PNumb = "";
                String Gend = "";
                String StuClass = "";
                char Maj;
                String CGPA = "";

                //STUDENT NUMBER    
                //Always the first five digits
                while (i <= 4) {
                    ID = ID + Character.toString(DataLine.charAt(i));
                    i++;
                }
                //Set the NewKids student number
                newKid.StudentNumber = Integer.parseInt(ID);



                //FIRST NAME    
                //The next 10 characters, might include white space
                while (i <= 14) {
                    FName = FName + Character.toString(DataLine.charAt(i));
                    i++;
                }
                newKid.FirstName = FName;

                //LAST NAME    
                //The next 10 characters, also might include white space
                while (i <= 24) {
                    LName = LName + Character.toString(DataLine.charAt(i));
                    i++;
                }
                newKid.LastName = LName;

                //PHONE NUMBER
                //The next 12 spaces so we can have dashes!
                while (i <= 36) {
                    PNumb = PNumb + Character.toString(DataLine.charAt(i));
                    i++;
                }
                newKid.PhoneNumber = PNumb;

                //GENDER
                //Is exactly one space, doesn't need a loop            
                Gend = Character.toString(DataLine.charAt(i));
                i++;
                newKid.Gender = Gend;

                //CLASSIFICATION
                //Also just one space, no loop necessary           
                StuClass = Character.toString(DataLine.charAt(i));
                i++;
                newKid.Classification = Integer.parseInt(StuClass);

                //Major
                //Also just one space, no loop necessary           
                newKid.Major = DataLine.charAt(i);
                i++;

                //GPA
                //The last 4 spaces are for GPA
                while (i <= 43) {
                    CGPA = CGPA + Character.toString(DataLine.charAt(i));
                    i++;
                }
                newKid.GPA = Double.parseDouble(CGPA);

                //At the end, we add the newKid
                FullList.listofsets.add(newKid);

                sb.append('\n');
                sb.append(DataLine);

                DataLine = br.readLine();

            }
        } finally {
            br.close();
        }


        System.out.println("Reading was successful!\r");

        
        

        //Kick off the switch statement!
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        Scanner input4 = new Scanner(System.in);
        Scanner input5 = new Scanner(System.in);
        Menus WorkMenus = new Menus();
        int switcher = 0;

        while (switcher != 6) {
            System.out.println("What would you like to do now?");
            WorkMenus.MainMenu();
            switcher = input2.nextInt();

            switch (switcher) {
                //LOCATE A STUDENT BY STUDENT NUMBER
                //add the error checking
                case 1:
                    System.out.println("What student ID do you want to search"
                            + " for?");
                    int IN = input4.nextInt();
                    Student temp = FullList.GetWithId(IN);
                    
                    //If it's a valid student number
                    if(temp != null){

                    System.out.println("Number    Name         "
                            + "      Phone Number"
                            + "    Gender     Class     Major     GPA");
                    System.out.print(temp.StudentNumber + "    ");
                    System.out.print(temp.FirstName);
                    System.out.print(temp.LastName);
                    System.out.print(temp.PhoneNumber + "        ");
                    System.out.print(temp.Gender + "        ");
                    System.out.print(temp.Classification + "         ");
                    System.out.print(temp.Major + "      ");
                    System.out.print(temp.GPA);
                    System.out.println();
                    }
                    break;

                //PRINT OUT ALL STUDENTS BY CLASS 
                case 2:
                    System.out.println("What student class do you want "
                            + "to list?");
                    int classin = input5.nextInt();

                    //Organize all the students by last name
                    Collections.sort(FullList.listofsets,
                            Student.Comparators.NAME);

                    //Gotta have a header
                    System.out.println("Number    Name     "
                            + "          Phone Number"
                            + "    Gender     Class     Major     GPA");

                    //Scroll through all the students
                    for (int i = 0; i < FullList.listofsets.size(); i++) {
                        
                            Student tempStudent = new Student();
                            tempStudent = FullList.listofsets.get(i);
                            
                            //If the student is the right class
                            //Print them out
                            if (tempStudent.Classification == classin) {


                            System.out.print(FullList.listofsets.get(i).StudentNumber
                                    + "    ");
                            System.out.print(FullList.listofsets.get(i).FirstName);
                            System.out.print(FullList.listofsets.get(i).LastName);
                            System.out.print(FullList.listofsets.get(i).PhoneNumber
                                    + "        ");
                            System.out.print(FullList.listofsets.get(i).Gender
                                    + "        ");
                            System.out.print(FullList.listofsets.get(i).Classification
                                    + "        ");
                            System.out.print(FullList.listofsets.get(i).Major
                                    + "        ");
                            System.out.print(FullList.listofsets.get(i).GPA);
                            System.out.println();
                        }
                    }
                    System.out.println("\r");
                    break;

                //DISPLAY ALL STUDENTS BY STUDENT NUMBER  
                case 3:
                    //Sort everything by student number
                    Collections.sort(FullList.listofsets, 
                            Student.Comparators.STUDENT_NUMBER);
                    
                    //Get a header
                    System.out.println("Number    Name     "
                            + "          Phone Number"
                            + "    Gender     Class     Major     GPA");
                    
                    //Scroll through them all and print out
                    for (int i = 0; i < FullList.listofsets.size(); i++) {                      
                        System.out.print(FullList.listofsets.get(i).StudentNumber
                                + "    ");
                        System.out.print(FullList.listofsets.get(i).FirstName);
                        System.out.print(FullList.listofsets.get(i).LastName);
                        System.out.print(FullList.listofsets.get(i).PhoneNumber
                                + "        ");
                        System.out.print(FullList.listofsets.get(i).Gender
                                + "        ");
                        System.out.print(FullList.listofsets.get(i).Classification
                                + "        ");
                        System.out.print(FullList.listofsets.get(i).Major
                                + "        ");
                        System.out.print(FullList.listofsets.get(i).GPA);
                        System.out.println();

                    }
                    System.out.println("\r");
                    break;

                //DISPLAY ALL STUDENTS BY LAST NAME
                case 4:

                    Collections.sort(FullList.listofsets, Student.Comparators.NAME);

                    System.out.println("Number    Name     "
                            + "          Phone Number"
                            + "    Gender     Class     Major     GPA");

                    for (int i = 0; i < FullList.listofsets.size(); i++) {                      
                        System.out.print(FullList.listofsets.get(i).StudentNumber
                                + "    ");
                        System.out.print(FullList.listofsets.get(i).FirstName);
                        System.out.print(FullList.listofsets.get(i).LastName);
                        System.out.print(FullList.listofsets.get(i).PhoneNumber
                                + "        ");
                        System.out.print(FullList.listofsets.get(i).Gender
                                + "        ");
                        System.out.print(FullList.listofsets.get(i).Classification
                                + "        ");
                        System.out.print(FullList.listofsets.get(i).Major
                                + "        ");
                        System.out.print(FullList.listofsets.get(i).GPA);
                        System.out.println();

                    }
                    System.out.println("\r");

                    break;

                //FIND THE AVERAGE GPA FOR ALL STUDENTS WITH A SPECIFIC MAJOR
                case 5:
                    System.out.println("What major would you like to "
                            + "analyze?");

                    //We need to flip it around to get a char 
                    String Major = input3.nextLine();
                    char MajorChar = Major.charAt(0);

                    int count = 0;
                    double GPAcombine = 0;

                    //Iterate through our students
                    for (int i = 0; i < FullList.listofsets.size(); i++) {
                        //If the major is detected, grab that GPA and count up
                        if (FullList.listofsets.get(i).Major == MajorChar) {
                            GPAcombine += FullList.listofsets.get(i).GPA;
                            count++;
                        }
                    }
                    System.out.println("There are " + count + " students "
                            + "with that major");
                    System.out.println("The average GPA is:"
                            + " " + GPAcombine / count + "\r");

                    break;

                //EXIT THE PROGRAM
                case 6:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;

                //DEFAULT CASE
                default:
                    System.out.println("That wasn't a selection!!!");
                    break;
            }
        }
    }
}
