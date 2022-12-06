package bg.tu_varna.sit.task3;

import java.util.Objects;

public class Student extends Person implements Comparable<Student> {
    private String fNumber;
    private Specialty specialty;
    private int course;
    private double grades;

    public Student(String firstName, String lastName, int age, String fNumber, Specialty specialty, int course, double grades) throws InvalidDataException {
        super(firstName, lastName, age);
        if (fNumber.isEmpty() || specialty == null) throw new InvalidDataException("Faculty number or specialty invalid");
        this.fNumber = fNumber;
        this.specialty = specialty;
        setCourse(course); // to reuse validation
        setGrades(grades);
    }

    public String getfNumber() {
        return fNumber;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public int getCourse() {
        return course;
    }

    public double getGrades() {
        return grades;
    }

    public void setCourse(int course) throws InvalidDataException {
        if (course < 1 || course > 4) throw new InvalidDataException("Course must be 1 to 4");
        this.course = course;
    }

    public void setGrades(double grades) throws InvalidDataException{
        if (grades < 2.00 || grades > 6.00) throw new InvalidDataException("Grades must be 2.00 to 6.00");
        this.grades = grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(getfNumber(), student.getfNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getfNumber());
    }

    @Override
    public String toString() {
        return "Student: \n" + " Name: " + this.getFirstName() + " " +this.getLastName() +
                "\n Age: " + this.getAge()+
                "\n Faculty Number: " + this.fNumber +
                "\n Specialty: " + this.specialty +
                "\n Course: " + this.course +
                "\n Grades: " + this.grades;
    }

    @Override
    public int compareTo(Student student) {
        return this.fNumber.compareTo(student.getfNumber());
    }
}
