/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabase;

//An ADT for all the actions our program can do with the data
public interface DatabaseADT {
  
    //Display all students sorted by last name
    public String DisplayList(ListOfStudents stuff);
    
    //Sort by student number
    public String SortByNumber(ListOfStudents stuff);
    
    //Sort by last name
    public String SortLastName(ListOfStudents stuff);
    
    //Find the average GPA for all students with a specified major
    public String GPAbyMajor(ListOfStudents stuff);
    
    //Find by student number
    public String FindByNumber(ListOfStudents stuff, int studentNumber);
    
}
