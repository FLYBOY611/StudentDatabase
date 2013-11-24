/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabase;

//An ADT for all the actions our program can do with the data
public interface DatabaseADT {
    
    //Compute the average GPA of all students
    public int AverageGPA(int GPA);
    
    //Display all students sorted by first name
    public String DisplayFirstName(String names);
    
    //Display all students sorted by last name
    public String DisplayLastName(String names);
    
}
