package bg.tu_varna.sit.task3;

import java.util.HashSet;
import java.util.Set;

public class Faculty {
    private String facultyName;
    private Set<Student> students;

    public Faculty(String facultyName) throws InvalidDataException{
        if (facultyName.isEmpty()) throw new InvalidDataException("Faculty Number cannot be empty");
        this.facultyName = facultyName;
        this.students = new HashSet<>();
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void addStudent(Student student) throws InvalidDataException{
        if (student == null) throw new InvalidDataException("Student cannot be null");
        students.add(student);
    }

    public double calculateAverageGrades(){
        double totalGrade = 0.00d;
        int studentCount = 0;
        for (Student student : students){
            if (student != null){
                totalGrade += student.getGrades();
                studentCount++;
            }
        }
        return totalGrade / studentCount;
    }

    public int getNumberOfStudentsBySpecialty(Specialty specialty){
        int count = 0;
        for (Student student : students){
            if (student != null){
                if (student.getSpecialty() == specialty) count++;
            }
        }
        return count;
    }

    public int getStudentsWithExcellentGrades(){
        int count = 0;
        for (Student student : students){
            if (student != null){
                if (student.getGrades() > 5.49) count++;
            }
        }
        return count;
    }

    public int getNumberOfStudentsByCourse(int course){
        int count = 0;
        for (Student student : students){
            if (student != null){
                if (student.getCourse() == course) count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students){
            sb.append(student.toString()).append("\n");
        }
        return sb.toString();
    }
}
