/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdatabase;

//We want a student constructor so we can make "students" from our data file.

import java.util.Comparator;

public class Student implements Comparable<Student> {

    int StudentNumber;
    String FirstName;
    String LastName;
    String PhoneNumber; 
    String Gender;
    int Classification; //What year they are
    char Major; //Maybe have that be a string?
    double GPA; //Will make things easy when we have to compare them
    
    //We might want Phone# as String to deal with the dashes. TBD
    
     public String toString(){
        return FirstName + " " + LastName;
    }
    
    @Override
    public int compareTo(Student o) {
        return Comparators.STUDENT_NUMBER.compare(this, o);
    }
    
         public static class Comparators {
    
         public static Comparator<Student> NAME = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.LastName.compareTo(o2.LastName);
                
                
                //return o1.name.compareTo(o2.name);

            }
        };
        
        public static Comparator<Student> STUDENT_NUMBER = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.StudentNumber > o2.StudentNumber){
                    return 1;
                }else if(o2.StudentNumber > o1.StudentNumber ){
                    return -1;
                }else return 0;

                //return o1.age - o2.age;
            }
        };
    }
}
