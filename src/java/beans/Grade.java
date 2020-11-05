/*
 * Mustafa Shubbar
 * Assignment #2
 * A bean class that models grades of the student
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Mustafa Shubbar
 */

// Bean rule #1 to implement Serializable
public class Grade implements Serializable{
    // Bean rule #2 to initiate the properties
    private double gradePoint = 0.0;
    private String letterDescription = "";
    
    // Bean rule #3 - empty constructor
    public Grade() {}

    // Bean rule #4 - madatory getters and optional setters 
    public double getGradePoint() {
        return gradePoint;
    }

    public void setGradePoint(double gradePoint) {
        this.gradePoint = gradePoint;
    }

    public String getLetterDescription() {
        return letterDescription;
    }

    public void setLetterDescription(String letterDescription) {
        this.letterDescription = letterDescription;
    }
    
    
}
