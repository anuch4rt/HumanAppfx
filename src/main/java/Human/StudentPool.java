package Human;

import java.util.ArrayList;
import Subject.Subject;

public class StudentPool {
    private ArrayList<Student> std = new ArrayList<Student>();

    public void addStudent(Student s) {
        std.add(s);
    }

    public double averageScore() {
        if (std.size() == 0) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < std.size(); i++) {
            sum = sum + std.get(i).getScore();
        }
        return sum / std.size();
    }

    public void showStudent() {
        System.out.println("รายชื่อนักเรียนและวิชาที่ลงทะเบียน");
        for (int i = 0; i < std.size(); i++) {
            Student s = std.get(i);
            System.out.println("ไอดี " + s.getId() + " ชื่อ " + s.whatYourName() + " คะแนน " + s.getScore() + " เกรด " + s.computeGrade() + " เบี้ยยังชีพ " + s.giveReward() + " บาท");

            ArrayList<Subject> subList = s.getSubjects();
            System.out.println("  รายวิชาที่ลงเรียน");

            if (subList.size() == 0) {
                System.out.println("   - ไม่ได้ลงทะเบียนวิชาใดๆ");
            } else {
                for (int j = 0; j < subList.size(); j++) {
                    Subject sub = subList.get(j);
                    System.out.println("   - " + sub.getCode() + " " + sub.getName() + " (" + sub.getUnit() + " หน่วยกิต)");
                }
            }
            System.out.println();
        }
    }
}