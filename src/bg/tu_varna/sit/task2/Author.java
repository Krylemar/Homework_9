package bg.tu_varna.sit.task2;

import java.util.Objects;

public class Author implements Comparable<Author>{
    private String firstName, lastName, country;

    public Author(String firstName, String lastName, String country) throws InvalidDataException{
        if (firstName.isEmpty() || lastName.isEmpty() || country.isEmpty()) throw new InvalidDataException("Author names and country cannot be empty");
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Author: " + this.firstName + " " + this.lastName + " Country: " + this.country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(getFirstName(), author.getFirstName()) && Objects.equals(getLastName(), author.getLastName()) && Objects.equals(getCountry(), author.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getCountry());
    }

    @Override
    public int compareTo(Author author) {
        int firstNameCompare = this.firstName.compareTo(author.firstName);
        int lastNameCompare = this.lastName.compareTo(author.lastName);
        int countryCompare = this.country.compareTo(author.country);
        if (firstNameCompare == 0) {
            if (lastNameCompare == 0) {
                return countryCompare;
            }else return lastNameCompare;
        }else return firstNameCompare;
    }
}
