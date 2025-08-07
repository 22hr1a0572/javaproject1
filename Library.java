Library Management System (Using OOP)
--------------------------------------
Objective: Develop a mini system to manage books and users.
Tools :Java, VS Code, Terminal.
Deliverables: Multi-class Java project.
'''
import java.util.*;
abstract class User {
    protected int userId;
    protected String name;
    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
    public int getUserId() { return userId; }
    public String getName() { return name; }
    public abstract void showUserType();
}
class Student extends User {
    public Student(int userId, String name) {
        super(userId, name);
    }
    public void showUserType() {
        System.out.println("User Type: Student");
    }
}

class Teacher extends User {
    public Teacher(int userId, String name) {
        super(userId, name);
    }
    public void showUserType() {
        System.out.println("User Type: Teacher");
    }
}
class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
    public int getId() { return id; }
    public boolean isIssued() { return isIssued; }
    public void issue() { isIssued = true; }
    public void returnBook() { isIssued = false; }

    public String toString() {
        return id + ": " + title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}
class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added.");
    }
    public void listBooks() {
        if (books.isEmpty()) System.out.println("No books.");
        else for (Book b : books) System.out.println(b);
    }
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added.");
    }
    public void listUsers() {
        if (users.isEmpty()) System.out.println("No users.");
        else for (User u : users) {
            System.out.println(u.getUserId() + ": " + u.getName());
            u.showUserType();
        }
    }
    public void issueBook(int id) {
        for (Book b : books) {
            if (b.getId() == id && !b.isIssued()) {
                b.issue(); System.out.println("Book issued."); return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(int id) {
        for (Book b : books) {
            if (b.getId() == id && b.isIssued()) {
                b.returnBook(); System.out.println("Book returned."); return;
            }
        }
        System.out.println("Invalid book ID.");
    }
}
public class LibrarySystem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        boolean run = true;
        while (run) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book  2. List Books  3. Add User  4. List Users");
            System.out.println("5. Issue Book  6. Return Book  7. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1:
                    System.out.print("Book ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Title: "); String t = sc.nextLine();
                    System.out.print("Author: "); String a = sc.nextLine();
                    lib.addBook(new Book(id, t, a)); break;
                case 2: lib.listBooks(); break;
                case 3:
                    System.out.print("1. Student 2. Teacher: "); int type = sc.nextInt();
                    System.out.print("User ID: "); int uid = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    if (type == 1) lib.addUser(new Student(uid, name));
                    else lib.addUser(new Teacher(uid, name)); break;
                case 4: lib.listUsers(); break;
                case 5: System.out.print("Book ID to issue: "); lib.issueBook(sc.nextInt()); break;
                case 6: System.out.print("Book ID to return: "); lib.returnBook(sc.nextInt()); break;
                case 7: run = false; break;
                default: System.out.println("Invalid choice.");
            }
        }
        sc.close();
        System.out.println("Exiting...");
    }
}
'''
output:
--------
PS C:\SOU> javac LibrarySystem.java
PS C:\SOU> java LibrarySystem.java 

--- Library Menu ---
1. Add Book  2. List Books  3. Add User  4. List Users
5. Issue Book  6. Return Book  7. Exit
Choice: 1
Book ID: 100
Title: manoyudham
Author: T.Nikitha
Book added.

--- Library Menu ---
1. Add Book  2. List Books  3. Add User  4. List Users
5. Issue Book  6. Return Book  7. Exit
Choice: 7
Exiting...
PS C:\SOU> 
-------
