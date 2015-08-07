package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongbailiang on 7/22/15.
 */
public class Student {
    private String studentID = new String();
    private ArrayList<String> score = new ArrayList<String>();

    public Student(){

    }
    public void setStudentID(String studentID){
        this.studentID = studentID;
    }
    public void setScore(String q1, String q2, String q3, String q4, String q5){
        score.add(q1);
        score.add(q2);
        score.add(q3);
        score.add(q4);
        score.add(q5);

    }
    public String getStudentID(){
        return this.studentID;
    }
    public List<String> getScore(){
        return this.score;
    }
    public String getScore(int index){
        return this.score.get(index);
    }
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<this.score.size(); i++){
            sb.append(this.score.get(i) + " ");
        }
        return sb.toString();
    }
}
