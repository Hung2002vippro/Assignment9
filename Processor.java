package assignment9.StudentManager;

import java.util.*;

public class Processor {

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Enter student information");
            System.out.println("2. Display all students");
            System.out.println("3. Search student by ID");
            System.out.println("4. Delete student by ID");
            System.out.println("5. Edit student by ID");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentList.inputStudents();
                    break;
                case 2:
                    studentList.displayStudents();
                    break;
                case 3:
                    System.out.print("Enter the ID to search: ");
                    String searchId = scanner.nextLine();
                    Student student = studentList.searchStudentById(searchId);
                    if (student != null) {
                        System.out.println("Student found: " + student);
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter the ID to delete: ");
                    String deleteId = scanner.nextLine();
                    studentList.deleteStudentById(deleteId);
                    break;
                case 5:
                    System.out.print("Enter the ID to edit: ");
                    String editId = scanner.nextLine();
                    studentList.editStudentById(editId);
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
