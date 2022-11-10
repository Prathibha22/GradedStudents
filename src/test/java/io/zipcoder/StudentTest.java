package io.zipcoder;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    @Test
    public void getExamScoresTest(){
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
       //ArrayList<Double> alExamScore=new ArrayList<>(Arrays.asList(examScores));
        Student student = new Student(firstName, lastName, examScores);
        String expected= "Exam Scores:\n"+
                                      "Exam 1 -> 100\n"+
                                      "Exam 2 -> 95\n"+
                                      "Exam 3 -> 123\n"+
                                      "Exam 4 -> 96\n";

        // When
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void addExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);
        String expected="Exam Scores:\n"+
                "Exam 1 -> 100\n";
        // When
        student.addExamScore(100.0);
        String actual = student.getExamScores();

        // Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void setExamScoreTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
      //  ArrayList<Double> alExamScore=new ArrayList<>(Arrays.asList(examScores));
        Student student = new Student(firstName, lastName, examScores);
        String expected="Exam Scores:\n"+
                "Exam 1 -> 150\n";

        // When
        student.setExamScore(1, 150.0);
        String actual = student.getExamScores();

        // Then
       Assert.assertEquals(expected,actual);
    }
    @Test
    public void getAverageExamScoreTest(){
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);
        Double expected=125.0;

        // When
        Double actual = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void overrideStringTest(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);
        String expected= "Student Name: Leon Hunter\n"+
                "Average Score: 125.0\n"+
                "Exam Scores:\n"+
                "Exam 1 -> 100\n"+
                "Exam 2 -> 150\n"+
                "Exam 3 -> 250\n"+
                "Exam 4 -> 0\n";
        // When
        String actual = student.toString();

        // Then
        Assert.assertEquals(expected,actual);
    }


}