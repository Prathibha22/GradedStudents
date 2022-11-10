package io.zipcoder;

//import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.*;

public class Classroom {


    //Fields in Classroom object
   private Student[] _students;
    private int _maxNoOfStudents;
    //Constructors of Classroom
    public Classroom(int maxNoOfStudents) {
        this._maxNoOfStudents = maxNoOfStudents;
    }

    public Classroom(Student[] _students) {
        this._students = _students;
    }

    public Classroom() {
        this._students= new Student[30];
    }
    //getter for Students
    public Student[] getStudents() {
        return _students;
    }
    public Double getAverageExamScoreStudents(){
        double output=0.0;
        if(_students!=null){
            for(Student elementStudent:_students){
                output+=elementStudent.getAverageExamScore();
            }
            output/=_students.length;
        }
        return output;
    }
    public void addStudent(Student student){
        ArrayList<Student> alStudent;
        if(_students!=null){
             alStudent=new ArrayList<Student>(Arrays.asList(_students));
            alStudent.add(student);
        }
        else{
            alStudent=new ArrayList<Student>(Arrays.asList(student));
        }
        _students=alStudent.toArray(new Student[alStudent.size()]);
    }
    public void removeStudent(String firstName, String lastName){
        if(_students!=null){
            ArrayList<Student> alStudent=new ArrayList<Student>(Arrays.asList(_students));
            for(Student eleStudent :alStudent){
                if(eleStudent.getFirstName().equals(firstName)&&eleStudent.getLastName().equals(lastName)){
                    alStudent.remove(eleStudent);
                    _students=alStudent.toArray(new Student[alStudent.size()]);
                    break;
                }
            }
        }
    }
    public void getStudentsByScore(){
      if(_students!=null){
          ArrayList<Student> alStudent=new ArrayList<>(Arrays.asList(_students));
          Collections.sort(alStudent, new Comparator<Student>() {
                      @Override
                      public int compare(Student s1, Student s2) {
                          int status=0;
                          status= s1.getAverageExamScore().compareTo(s2.getAverageExamScore());
                          if(status==0)
                              status=s1.getLastName().compareTo(s2.getLastName());
                          return status;
                      }
                  });
                  _students = alStudent.toArray(new Student[alStudent.size()]);
      }
    }
    private static TreeMap<Double, String> gradeMap = new TreeMap<>();
    static {
        gradeMap.put(90.0, "A");
        gradeMap.put(75.0, "B");
        gradeMap.put(60.0, "C");
        gradeMap.put(30.0, "D");
        gradeMap.put( 0.0, "F");
    }
    public HashMap  getGradeBook(){
        HashMap<Object,String> mapStudentGrades=new HashMap<>();
        
        if(_students!=null){
            for(Student stu:_students){
                mapStudentGrades.put(stu,gradeMap.floorEntry(stu.getAverageExamScore()).getValue());
            }
        }
        return mapStudentGrades;
    }

}

