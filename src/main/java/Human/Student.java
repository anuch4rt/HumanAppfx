package Human;

import Subject.Subject;
import java.util.ArrayList;

public class Student extends Person {
    private int score;
    private ArrayList<Subject> subjects = new ArrayList<Subject>();

    public Student() {
        super();
    }

    public Student(String id, String name, String lastname, int score) {
        super(id, name, lastname);
        this.score = score;
    }

    @Override
    public int giveReward() {
        return 500;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addSubject(Subject sub) {
        subjects.add(sub);
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public String whatYourName() {
        return getName() + " " + getLastname();
    }

    public String computeGrade() {
        if (score >= 80) return "A";
        if (score >= 70) return "B";
        if (score >= 60) return "C";
        if (score >= 50) return "D";
        return "F";
    }

    public void showInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName() + " " + getLastname());
        System.out.println("Score: " + score);
        System.out.println("Grade: " + computeGrade());
    }
}