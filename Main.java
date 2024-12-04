import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\nStudent Management System:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student Marks");
            System.out.println("3. Delete Student");
            System.out.println("4. Sort Students by Marks");
            System.out.println("5. Display All Students");
            System.out.println("6. Search Student by ID");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = -1;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    String id, name;
                    double marks;
                    System.out.print("Enter ID: ");
                    id = scanner.nextLine();
                    if (id.isEmpty()) {
                        System.out.println("Error: ID cannot be empty.");
                        break;
                    }
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("Error: Name cannot be empty.");
                        break;
                    }
                    System.out.print("Enter Marks: ");
                    try {
                        marks = scanner.nextDouble();
                        if (marks < 0 || marks > 100) {
                            System.out.println("Error: Marks should be between 0 and 100.");
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Please enter valid marks.");
                        scanner.nextLine();
                        break;
                    }
                    manager.addStudent(new Student(id, name, marks));
                    break;

                case 2:
                    System.out.print("Enter ID of student to edit marks: ");
                    id = scanner.nextLine();
                    System.out.print("Enter New Marks: ");
                    try {
                        marks = scanner.nextDouble();
                        manager.editStudentMarks(id, marks);
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Please enter valid marks.");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    System.out.print("Enter ID of student to delete: ");
                    id = scanner.nextLine();
                    manager.deleteStudent(id);
                    break;

                case 4:
                    manager.sortStudentsByMarks();
                    break;

                case 5:
                    manager.displayStudents();
                    break;

                case 6:
                    System.out.print("Enter ID of student to search: ");
                    id = scanner.nextLine();
                    manager.searchStudentById(id);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
