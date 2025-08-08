Java File I/O – Notes App
Objective: Create a text-based notes manager with file read/write.
Tools :Java, VS Code, Terminal.
Deliverables: Working .java file using FileReader/FileWriter
''''''
import java.io.*;
import java.util.Scanner;
public class NotesApp {
    private static final String FILE_NAME = "notes.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n===== Notes App =====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Clear Notes");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    addNote(scanner);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    clearNotes();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
    private static void addNote(Scanner scanner) {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(note + System.lineSeparator());
            System.out.println("Note added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    private static void viewNotes() {
        System.out.println("\n--- Your Notes ---");
        try (FileReader fr = new FileReader(FILE_NAME);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            boolean empty = true;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                empty = false;
            }
            if (empty) {
                System.out.println("(No notes found)");
            }
        } catch (FileNotFoundException e) {
            System.out.println("(No notes file found yet)");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    private static void clearNotes() {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            fw.write("");
            System.out.println("All notes cleared!");
        } catch (IOException e) {
            System.out.println("Error clearing file: " + e.getMessage());
        }
    }
}
'''
output:
-----------
PS C:\SOU> javac NotesApp.java
PS C:\SOU> java NotesApp.java 

===== Notes App =====
1. Add Note       
2. View Notes     
3. Clear Notes    
4. Exit
Choose an option: 1
Enter your note: keep smiling
Note added successfully!

===== Notes App =====
1. Add Note
2. View Notes
3. Clear Notes
4. Exit
Choose an option: 2

--- Your Notes ---
keep smiling

===== Notes App =====
1. Add Note
2. View Notes
3. Clear Notes
4. Exit
Choose an option: 1
Enter your note: enjoy every movement
Note added successfully!

===== Notes App =====
1. Add Note
2. View Notes
3. Clear Notes
4. Exit
Choose an option: 4
Exiting... Goodbye!
PS C:\SOU> 
