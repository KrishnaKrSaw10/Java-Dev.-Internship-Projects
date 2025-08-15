import java.util.Scanner;

/**
 * A Java program to calculate a student's total marks, average percentage, and assign a grade.
 */
public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 1: Get the number of subjects from the user
            System.out.print("Enter the number of subjects: ");
            int numberOfSubjects = scanner.nextInt();

            if (numberOfSubjects <= 0) {
                System.out.println("Number of subjects must be a positive integer.");
                return;
            }

            // Step 2: Input marks for each subject and calculate total
            double totalMarks = 0;
            for (int i = 1; i <= numberOfSubjects; i++) {
                System.out.printf("Enter marks for subject %d (out of 100): ", i);
                double marks = scanner.nextDouble();

                // Step 6: Validate marks input
                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks. Marks must be between 0 and 100.");
                    return;
                }
                totalMarks += marks;
            }

            // Step 3: Calculate average percentage
            double averagePercentage = totalMarks / numberOfSubjects;

            // Step 4: Determine the grade
            String grade;
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

            // Step 5: Display the final results
            System.out.println("\n--- Results ---");
            System.out.printf("Total Marks: %.2f%n", totalMarks);
            System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
            System.out.println("Grade: " + grade);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
