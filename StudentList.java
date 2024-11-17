package assignment9.StudentManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StudentList {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void inputStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i < n; i++) {
            System.out.println("Enter information for student " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Full Name: ");
            String name = scanner.nextLine();
            System.out.print("Date of Birth (dd/MM/yyyy): ");
            Date dob = null;
            try {
                dob = dateFormat.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("Invalid date format. Try again.");
                i--;
                continue;
            }
            System.out.print("Major: ");
            String major = scanner.nextLine();
            System.out.print("GPA: ");
            float gpa = scanner.nextFloat();
            scanner.nextLine(); 

            students.add(new Student(id, name, dob, major, gpa));
        }
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            System.out.println("Student List:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public Student searchStudentById(String id) {
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudentById(String id) {
        Student student = searchStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student with ID " + id + " has been deleted.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void editStudentById(String id) {
        Student student = searchStudentById(id);
        if (student != null) {
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Editing information for student: " + student);

            System.out.print("New Name: ");
            String newName = scanner.nextLine();
            System.out.print("New Date of Birth (dd/MM/yyyy): ");
            Date newDob = null;
            try {
                newDob = dateFormat.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("Invalid date format. Edit canceled.");
                return;
            }
            System.out.print("New Major: ");
            String newMajor = scanner.nextLine();
            System.out.print("New GPA: ");
            float newGpa = scanner.nextFloat();

            student.setFullName(newName);
            student.setDateOfBirth(newDob);
            student.setMajor(newMajor);
            student.setGpa(newGpa);
            System.out.println("Student information has been updated.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}
