import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Asking user for the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        int totalMarks = 0;
        // User inputs marks for each subject and validate input
        for (int i = 1; i <= numSubjects; i++) {
            int subjectMarks;
            do {
                System.out.print("Enter marks for Subject " + i + ": ");
                if (scanner.hasNextInt()) {
                    subjectMarks = scanner.nextInt();
                    if (subjectMarks >= 0 && subjectMarks <= 100) {
                        break; // Valid input, exit the loop
                    } else {
                        System.out.println("Marks must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Please enter a valid integer.");
                    scanner.next(); // Clear invalid input from the scanner
                }
            } while (true);
            totalMarks += subjectMarks;
        }
        // Calculating the average percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        String grade;
        // Assigning grades based on the average percentage obtained
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
        // Displaying the  Student results to the user
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        scanner.close();
    }
}
