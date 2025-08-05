Student Record Management System
Objective: Create a CLI-based CRUD system for managing student records.
Tools :Java, VS Code/IntelliJ CE.
Deliverables: Java program with classes and menu options.
'''
import java.util.ArrayList;
import java.util.Scanner;
class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCourse(String course) {
        this.course = course;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course);
    }
}
public class StudentManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.out.println("Thank you! Exiting system.");
                default -> System.out.println("Invalid choice. Please select between 1 and 6.");
            }
        } while (choice != 6);
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        studentList.add(new Student(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    private static void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No records found.");
        } else {
            System.out.println("--- Student Records ---");
            for (Student s : studentList) {
                s.display();
            }
        }
    }

    private static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getId() == id) {
                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.print("Enter new Name: ");
                s.setName(scanner.nextLine());

                System.out.print("Enter new Age: ");
                s.setAge(scanner.nextInt());
                scanner.nextLine();

                System.out.print("Enter new Course: ");
                s.setCourse(scanner.nextLine());

                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = studentList.removeIf(s -> s.getId() == id);

        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
'''
output:
--------
PS C:\SOU> javac StudentManagementSystem.java
PS C:\SOU> java StudentManagementSystem.java 

=== Student Record Management System ===
1. Add Student
2. View All Students   
3. Search Student by ID
4. Update Student      
5. Delete Student      
6. Exit
Enter your choice: 4   
Enter ID to update: 101
Student not found.

=== Student Record Management System ===
1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student
5. Delete Student
6. Exit
Enter your choice: 1
Enter ID: 102
Enter Name: souji
Enter Age: 20
Enter Course: cse 
Student added successfully!

=== Student Record Management System ===
1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student
5. Delete Student
6. Exit
Enter your choice: 2
--- Student Records ---
ID: 102, Name: souji, Age: 20, Course: cse

=== Student Record Management System ===
1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student
5. Delete Student
6. Exit
Enter your choice: 1
Enter ID: 102
Enter Name: suchi
Enter Age: 20
Enter Course: cse
Student added successfully!

=== Student Record Management System ===
1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student
5. Delete Student
6. Exit
Enter your choice: 1
Enter ID: 103
Enter Name: puppy
Enter Age: 21
Enter Course: cse
Student added successfully!

=== Student Record Management System ===
1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student
5. Delete Student
6. Exit
Enter your choice: 1
Enter ID: 104
Enter Name: nikki
Enter Age: 20
Enter Course: cse
Student added successfully!

=== Student Record Management System ===
1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student
5. Delete Student
6. Exit
Enter your choice: 1
Enter ID: 104
Enter Name: srav
Enter Age: 21
Enter Course: cse
Student added successfully!

=== Student Record Management System ===
1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student
5. Delete Student
6. Exit
Enter your choice: 6
Thank you! Exiting system.
-------------
