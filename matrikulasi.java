import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Student name:");
        String studentName = scanner.nextLine();
        System.out.println("Enter Student address:");
        String studentAddress = scanner.nextLine();
        Student student = new Student(studentName, studentAddress);

        System.out.println("Enter Teacher name:");
        String teacherName = scanner.nextLine();
        System.out.println("Enter Teacher address:");
        String teacherAddress = scanner.nextLine();
        Teacher teacher = new Teacher(teacherName, teacherAddress);

        System.out.println("Enter Course to add:");
        String course = scanner.nextLine();
        teacher.addCourse(course);
        student.addCourseGrade(course, 80);

        System.out.println("Student Grades:");
        student.printGrades();
        System.out.println("Teacher Courses: ");
        teacher.printCourses();

        scanner.close();
    }
}

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return name + " (" + address + ")";
    }
}

class Student extends Person {
    private int[] grades;
    private String[] courses;
    private int numCourses;

    public Student(String name, String address) {
        super(name, address);
        this.courses = new String[100];
        this.grades = new int[100];
        this.numCourses = 0;
    }

    public void addCourseGrade(String course, int grade) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i] != null && courses[i].equals(course)) {
                grades[i] = grade;
                return;
            }
        }
        courses[numCourses] = course;
        grades[numCourses] = grade;
        numCourses++;
    }

    public void printGrades() {
        for (int i = 0; i < numCourses; i++) {
            System.out.println(courses[i] + ": " + grades[i]);
        }
    }

    public double getAverageGrade() {
        int sum = 0;
        for (int i = 0; i < numCourses; i++) {
            sum += grades[i];
        }
        return (double) sum / numCourses;
    }

    public String toString() {
        return "Student: " + super.toString();
    }
}

class Teacher extends Person {
    private String[] courses;
    private int numCourses;

    public Teacher(String name, String address) {
        super(name, address);
        this.courses = new String[100];
        this.numCourses = 0;
    }

    public boolean addCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i] != null && courses[i].equals(course)) {
                return false;
            }
        }
        courses[numCourses] = course;
        numCourses++;
        return true;
    }

    public boolean removeCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i] != null && courses[i].equals(course)) {
                for (int j = i; j < numCourses - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                numCourses--;
                return true;
            }
        }
        return false;
    }

    public void printCourses() {
        for (int i = 0; i < numCourses; i++) {
            System.out.println(courses[i]);
        }
    }
}
