package io.zipcoder;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class ClassroomTest {
    @Test
    public void getAverageExamScoreTest(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double output = classroom.getAverageExamScoreStudents();

        // Then
        System.out.println(output);
    }
    @Test
    public void addStudentTest(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }
    @Test
    public void removeStudentTest(){
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        classroom.addStudent(student);
       // Student[] beforeRemove = classroom.getStudents();
        classroom.removeStudent("Leon","Hunter");
        Student[] afterRemove = classroom.getStudents();

        // Then
        //String beforeRemoveAsString = Arrays.toString(beforeRemove);
        String afterRemoveAsString = Arrays.toString(afterRemove);

        System.out.println("===========================");
      //  System.out.println(beforeRemoveAsString);
        System.out.println("===========================");
        System.out.println(afterRemoveAsString);
    }
    @Test
    public void getStudentsByScore(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 120.0, 150.0 };
        Double[] s3Scores = { 100.0, 150.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "Abcd", s3Scores);

        Student[] students = {s1,s2,s3};
        Classroom classroom = new Classroom(students);
         classroom.getStudentsByScore();
        Student[] afterOrder = classroom.getStudents();

        // Then
        String afterOrderAsString = Arrays.toString(afterOrder);


        System.out.println("===========================");
        System.out.println(afterOrderAsString);
    }
    @Test
    public void getGradeBook(){
        // : Given
        Double[] s1Scores = { 100.0, 95.0 };
        Double[] s2Scores = { 20.0, 10.0 };
        Double[] s3Scores = { 60.0, 60.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "Abcd", s3Scores);

        Student[] students = {s1,s2,s3};
        Classroom classroom = new Classroom(students);
        HashMap<Object,Student> mapGradeBook=classroom.getGradeBook();

        for (Object keys : mapGradeBook.keySet())
        {
            System.out.println(keys + "Grade :"+ mapGradeBook.get(keys));
        }


    }
}
