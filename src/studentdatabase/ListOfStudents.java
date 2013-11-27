
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabase;

import java.util.ArrayList;
import java.util.Collections;

//We need an ArrayList of students
//As each student is made, it's added to the array
//The ArrayList is then used to manipulate the data
public class ListOfStudents {
    ArrayList<Student> listofsets = new ArrayList<>();
    
    public Student GetWithId(int StudentNum){
        Collections.sort(listofsets, Student.Comparators.STUDENT_NUMBER);
        
        int front = 0;
        int end = listofsets.size();
        
        while(true){
            
            int middle = (end-front)/2;
            middle += front;
            
            Student temp = listofsets.get(middle);
            
            if(StudentNum == temp.StudentNumber){
                return temp;
            }
            if(middle == front && StudentNum != temp.StudentNumber){
                System.out.println("That record does not exist!");
                return null;
            }
            else if (StudentNum > temp.StudentNumber){
                front = middle+1;
            }else if (StudentNum < temp.StudentNumber){
                end = middle-1;
            }
            
            
            
        }
        
    }
    
}


