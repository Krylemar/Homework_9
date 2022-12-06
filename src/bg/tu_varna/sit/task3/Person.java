package bg.tu_varna.sit.task3;

import java.util.Objects;

public class Person {
    private String firstName, lastName;
    private int age;

    public Person(String firstName, String lastName, int age) throws InvalidDataException {
        if (firstName.isEmpty() || lastName.isEmpty() || age < 0) throw new InvalidDataException("Invalid data for person");
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person: \n" + " Name: "+this.firstName + " " + this.lastName + "\n Age: "+ this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAge());
    }
}
