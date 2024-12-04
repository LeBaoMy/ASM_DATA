public class Student {
    private String id;
    private String name;
    private double marks;
    private String rank; // Added rank field

    // Constructor to initialize student details
    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = calculateRank(marks);  // Automatically calculate the rank based on marks
    }

    // Getter for ID
    public String getId() {
        return id;
    }

    // Getter for Name
    public String getName() {
        return name;
    }

    // Getter for Marks
    public double getMarks() {
        return marks;
    }

    // Getter for Rank
    public String getRank() {
        return rank;
    }

    // Setter for Marks (recalculates rank when marks are updated)
    public void setMarks(double marks) {
        this.marks = marks;
        this.rank = calculateRank(marks); // Recalculate rank after updating marks
    }

    // Method to calculate the rank based on the marks
    private String calculateRank(double marks) {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks >= 5.0 && marks < 6.5) {
            return "Medium";
        } else if (marks >= 6.5 && marks < 7.5) {
            return "Good";
        } else if (marks >= 7.5 && marks < 9.0) {
            return "Very Good";
        } else if (marks >= 9.0 && marks <= 10.0) {
            return "Excellent";
        }
        return "Unknown";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Rank: " + rank;
    }
}
