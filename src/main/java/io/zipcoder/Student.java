package io.zipcoder;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Student {
    //Fields
    private String _firstName;
    private String _lastName;
    private ArrayList<Double> _examScores=new ArrayList<Double>();
    private int _totalExamsTaken;

    //Constructor
    public Student(String firstName,String lastName,ArrayList<Double> examScores){
        this._firstName=firstName;
        this._lastName=lastName;
        this._examScores=examScores;
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
        int i=1;
        sb.append("Exam Scores:\n");
        for(Double score : _examScores){
         sb.append("Exam "+i+" -> "+Math.round(score)+"\n");
           i++;
        }
        return sb.toString();
    }
    public void addExamScore(double examScore){
     _examScores.add(examScore);
    }

   public void setExamScore(int examNumber, double newScore){
        _examScores.set(examNumber-1,newScore);
   }

   public Double getAverageExamScore(){
        Double sum=0.0;
      DecimalFormat df=new DecimalFormat(".#");
      for(Double num:_examScores){
          sum+=num;
      }
      return Double.valueOf(df.format(sum/_examScores.size()));
   }

}
