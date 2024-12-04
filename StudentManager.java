import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        if (student == null || student.getId().isEmpty() || student.getMarks() < 0 || student.getMarks() > 10) {
            System.out.println("Error: Invalid student data. Marks should be between 0 and 10, and ID cannot be empty.");
            return;
        }
        try {
            int idValue = Integer.parseInt(student.getId());
            if (idValue <= 0) {
                System.out.println("Error: ID cannot be 0 or a negative number.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: ID must be a valid positive integer.");
            return;
        }
        student.setMarks(student.getMarks());
        students.add(student);
        System.out.println("Student added successfully with rank: " + student.getRank());
    }


    public void editStudentMarks(String id, double marks) {
        if (marks < 0 || marks > 10) {
            System.out.println("Error: Marks should be between 0 and 10.");
            return;
        }
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setMarks(marks); // Update the student's marks
                System.out.println("Marks updated successfully for student ID: " + id);
                return;
            }
        }
        System.out.println("Error: Student with ID " + id + " not found.");
    }


    public void deleteStudent(String id) {
        boolean studentFound = false;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                System.out.println("Student deleted successfully.");
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    public void sortStudentsByMarks() {
        if (students.isEmpty()) {
            System.out.println("Error: No students to sort.");
            return;
        }
        students.sort((student1, student2) -> Double.compare(student2.getMarks(), student1.getMarks()));
        System.out.println("Students sorted by marks.");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("Error: No students to display.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }


    public void searchStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Error: Student with ID " + id + " not found.");
    }
}
