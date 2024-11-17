package assignment9.StudentManager;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    String studentId;
    String fullName;
    Date dateOfBirth;
    String major;
    float gpa;

    public Student(String studentId, String fullName, Date dateOfBirth, String major, float gpa) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.major = major;
        this.gpa = gpa;
    }

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void enterStudentInfo() {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter Student ID: ");
        this.studentId = scanner.nextLine();

        System.out.print("Enter Full Name: ");
        this.fullName = scanner.nextLine();

        System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
        try {
            this.dateOfBirth = dateFormat.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter the date in dd/MM/yyyy format.");
            return;
        }
        System.out.print("Enter Major: ");
        this.major = scanner.nextLine();

        System.out.print("Enter GPA: ");
        this.gpa = scanner.nextFloat();
    }

    public void displayStudentInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Student Information:");
        System.out.println("ID: " + this.studentId);
        System.out.println("Name: " + this.fullName);
        System.out.println("Date of Birth: " + dateFormat.format(this.dateOfBirth));
        System.out.println("Major: " + this.major);
        System.out.println("GPA: " + this.gpa);
    }

}
