package bg.tu_varna.sit.task2;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private String title;
    private Author author;
    private int publishingYear;
    private int availableQuantity;

    public Book(String title, Author author, int publishingYear, int availableQuantity) throws InvalidDataException{
        if (title.isEmpty() || availableQuantity < 0) throw new InvalidDataException("Book's title cannot be empty and available quantity cannot be negative"); // books can be written before 0 AD, signified by negatve year
        this.title = title;
        this.author = author;
        this.publishingYear = publishingYear;
        this.availableQuantity = availableQuantity;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAuthor());
    }

    @Override
    public int compareTo(Book book) {
        int titleCompare = this.title.compareTo(book.title);
        int authorCompare = this.author.compareTo(book.author);
        if (titleCompare == 0) {
            return authorCompare;
        }else return titleCompare;
    }

    @Override
    public String toString() {
        return "Title: " + this.title +
                "\n " + this.author.toString() +
                "\n Publishing year: " + this.publishingYear +
                "\n Available quantity: " + this.availableQuantity;
    }
}
