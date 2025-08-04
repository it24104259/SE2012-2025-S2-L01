import java.util.Scanner;

public class Marks_updated {

    static int[][] marks; // marks[studentID][subjectID]

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int students = scanner.nextInt();
        marks = new int[students + 1][4]; // Subject index 1 to 3

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nMENU");
            System.out.println("1. Add student marks");
            System.out.println("2. Update student marks");
            System.out.println("3. Get average for a subject");
            System.out.println("4. Get average for a student");
            System.out.println("5. Get total marks for a student");
            System.out.println("6. Grades");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student ID to add marks: ");
                    int id = scanner.nextInt();
                    add(id, scanner);
                }
                case 2 -> {
                    System.out.print("Enter student ID to update: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter subject ID to update (1=Math, 2=Chem, 3=Physics): ");
                    int subject = scanner.nextInt();
                    update(id, subject, scanner);
                }
                case 3 -> {
                    System.out.print("Enter subject ID to average (1=Math, 2=Chem, 3=Physics): ");
                    int subject = scanner.nextInt();
                    average_s(subject, students);
                }
                case 4 -> {
                    System.out.print("Enter student ID to get average: ");
                    int id = scanner.nextInt();
                    average(id);
                }
                case 5 -> {
                    System.out.print("Enter student ID to get total: ");
                    int id = scanner.nextInt();
                    total(id);
                }
                case 6 -> grades(students);
                case 7 -> isRunning = false;
                default -> System.out.println("INVALID CHOICE!");
            }
        }

        scanner.close();
    }

    static void add(int id, Scanner scanner) {
        System.out.print("Math marks: ");
        marks[id][1] = scanner.nextInt();

        System.out.print("Chemistry marks: ");
        marks[id][2] = scanner.nextInt();

        System.out.print("Physics marks: ");
        marks[id][3] = scanner.nextInt();

        System.out.println("Marks added for student " + id);
    }

    static void update(int id, int subjectID, Scanner scanner) {
        System.out.print("Enter new mark for subject " + subjectID + ": ");
        marks[id][subjectID] = scanner.nextInt();
        System.out.println("Marks updated.");
    }

    static void average_s(int subjectID, int totalStudents) {
        int sum = 0;
        for (int i = 1; i <= totalStudents; i++) {
            sum += marks[i][subjectID];
        }
        double avg = (double) sum / totalStudents;
        System.out.println("Average for subject " + subjectID + ": " + avg);
    }

    static void average(int id) {
        int sum = marks[id][1] + marks[id][2] + marks[id][3];
        System.out.println("Average marks of student " + id + ": " + (sum / 3.0));
    }

    static void total(int id) {
        int sum = marks[id][1] + marks[id][2] + marks[id][3];
        System.out.println("Total marks of student " + id + ": " + sum);
    }

    static void grades(int totalStudents){
        System.out.println("GRADE SUMMARY");
        System.out.printf("%-10s %-10s %-10s %-10s%n", "Student", "Math", "Chem", "Physics");

        for (int i = 1; i <= totalStudents; i++) {
            System.out.printf("%-10d %-10s %-10s %-10s%n", i,
                    getGrade(marks[i][1]),
                    getGrade(marks[i][2]),
                    getGrade(marks[i][3]));
        }

    }

    static String getGrade(int score) {
        if (score >= 90) return "Grade A";
        else if (score >= 80) return "Grade B";
        else if (score >= 70) return "Grade C";
        else if (score >= 60) return "Grade D";
        else return "Fail";
    }
}