import java.util.*;
class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}
class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}
class Course {
    String name;
    int capacity;
    List<String> prerequisites;
    List<String> enrolledStudents;
    public Course(String name, int capacity, List<String> prerequisites) {
        this.name = name;
        this.capacity = capacity;
        this.prerequisites = prerequisites;
        this.enrolledStudents = new ArrayList<>();
    }
    public void enrollStudent(String studentName, List<String> completedCourses)
            throws CourseFullException, PrerequisiteNotMetException {
    
        if (enrolledStudents.size() >= capacity) {
            throw new CourseFullException("Enrollment Failed: Course is Full!");
        }
        for (String prerequisite : prerequisites) {
            if (!completedCourses.contains(prerequisite)) {
                throw new PrerequisiteNotMetException("Enrollment Failed: Missing Prerequisite - " + prerequisite);
            }
        }
        enrolledStudents.add(studentName);
        System.out.println(studentName + " enrolled successfully in " + name);
    }
    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + name + ": " + enrolledStudents);
    }
}
public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> prerequisites = Arrays.asList("Math", "English");
        Course course = new Course("Computer Science", 2, prerequisites);
        for (int i = 0; i < 3; i++) {
            try {
                System.out.print("\nEnter Student Name: ");
                String studentName = sc.nextLine();
                System.out.println("Enter Completed Courses (comma separated): ");
                String[] completed = sc.nextLine().split(",");
                List<String> completedCourses = Arrays.asList(completed);
                course.enrollStudent(studentName, completedCourses);
            } catch (CourseFullException | PrerequisiteNotMetException e) {
                System.out.println(e.getMessage());
            }
            course.showEnrolledStudents();
        }
        sc.close();
    }
}
