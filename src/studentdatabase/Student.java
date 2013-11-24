/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabase;

//We want a student constructor so we can make "students" from our data file.
public class Student {
    int StudentNumber;
    String FirstName;
    String LastName;
    int PhoneNumber; 
    String Gender;
    int Classification; //What year they are
    char Major; //Maybe have that be a string?
    double GPA; //Will make things easy when we have to compare them
    
    //We might want Phone# as String to deal with the dashes. TBD
}
