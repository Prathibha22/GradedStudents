package io.zipcoder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    //Fields
    private String _firstName;
    private String _lastName;
    private Double[] _arrScores;
    private int _totalExamsTaken;

    //Constructor
    public Student(String firstName,String lastName,Double[] examScores){
        this._firstName=firstName;
        this._lastName=lastName;
        this._arrScores=examScores;
    }

    //Getters and Setters
    public String getFirstName(){ return _firstName;}
    public void setFirstName(String newFirstName){ this._firstName=newFirstName;}
    public String getLastName(){return _lastName;}
    public void setLastName(String newLastName){this._lastName=newLastName;}
    public int getNumberOfExamsTaken(){return _totalExamsTaken;}

// method which returns a string representation of all exams taken.
    public String getExamScores(){
        StringBuilder sb=new StringBuilder();
        int noOfExam=1;
        sb.append("Exam Scores:\n");
        for(int i=0;i<_arrScores.length;i++){
            sb.append("Exam "+noOfExam+" -> "+Math.round(_arrScores[i])+"\n");
            noOfExam++;
        }
        return sb.toString();
    }
    public void addExamScore(Double examScore){
        ArrayList<Double> _examScores=new ArrayList<Double>(Arrays.asList(_arrScores));
      _examScores.add(examScore);
        _arrScores=_examScores.toArray(_arrScores);
    }

   public void setExamScore(int examNumber, double newScore){
       ArrayList<Double> _examScores=new ArrayList<Double>(Arrays.asList(_arrScores));
       _examScores.set(examNumber-1,newScore);;
       _arrScores=_examScores.toArray(_arrScores);
   }

   public Double getAverageExamScore(){
        Double sum=0.0;
      DecimalFormat df=new DecimalFormat(".#");
      for(int i=0;i<_arrScores.length;i++){
          sum+=_arrScores[i];
      }
      return Double.valueOf(df.format(sum/_arrScores.length));
   }

    @Override
    public String toString() {
        return "Student Name: "+ _firstName +" "+ _lastName +"\n"+
                "Average Score: "+getAverageExamScore()+"\n"+
                getExamScores();
    }
}
