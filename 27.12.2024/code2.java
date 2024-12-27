import java.util.Scanner;

class Student {
    private String name;
    private int[] grades;
    private int totalGrades;

    // Constructor
    public Student(String name, int numGrades) {
        this.name = name;
        grades = new int[numGrades];
        totalGrades = 0;
    }

    // Method to enter grades
    public void enterGrades() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter grades for " + name + ":");
        for (int i = 0; i < grades.length; i++) {
            System.out.print("Grade " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
            totalGrades += grades[i];
        }
    }

    // Method to calculate average
    public double calculateAverage() {
        return (double) totalGrades / grades.length;
    }

    // Method to determine if the student passed
    public boolean isPassed() {
        return calculateAverage() >= 50; // Passing criteria: average >= 50
    }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("Student: " + name);
        System.out.println("Average Grade: " + calculateAverage());
        System.out.println(isPassed() ? "Status: Passed" : "Status: Failed");
    }
}

public class GradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Enter number of students and number of grades
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        System.out.print("Enter number of grades per student: ");
        int numGrades = scanner.nextInt();
        
        // Create student objects and collect data
        Student[] students = new Student[numStudents];
        
        for (int i = 0; i < numStudents; i++) {
            scanner.nextLine();  // Consume the newline left by nextInt
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            
            students[i] = new Student(name, numGrades);
            students[i].enterGrades();
        }
        
        // Display student results
        System.out.println("\nStudent Results:");
        for (Student student : students) {
            student.displayStudentInfo();
        }
    }
}
