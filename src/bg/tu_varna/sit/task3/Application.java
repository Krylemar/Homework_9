package bg.tu_varna.sit.task3;

public class Application {
    public static void main(String[] args) {
        Faculty fita = null;
        Student st1;
        Student st2;
        Student st3;
        Student st4;
        try {
            fita = new Faculty("FITA");
            st1 = new Student("Penko","Patev", 21,"20785468", Specialty.SIT,3,4.00);
            st2 = new Student("Svetoslav", "Tsanov",20,"21674575", Specialty.CST,2,5.55);
            st3 = new Student("Ginko", "Bilobov",22,"19568945",Specialty.A,4,6.00);
            st4 = new Student("Dilbo","Daggins", 19,"22568793", Specialty.CCT,1,5.23);
            fita.addStudent(st1);
            fita.addStudent(st2);
            fita.addStudent(st3);
            fita.addStudent(st4);
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Average Grades in: "+ fita.getFacultyName() + ": "+fita.calculateAverageGrades());
        System.out.println();
        System.out.println("Number of Students by specialty: "+ Specialty.SIT + ": "+fita.getNumberOfStudentsBySpecialty(Specialty.SIT));
        System.out.println();
        System.out.println("Students with excellent grades: " +fita.getStudentsWithExcellentGrades());
        System.out.println();
        System.out.println("Students in course: "+ 3 + ": "+fita.getNumberOfStudentsByCourse(3));
        System.out.println();
        System.out.println("Entire faculty: \n" + fita.toString());

    }
}
