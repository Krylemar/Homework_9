package bg.tu_varna.sit.task2;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BookCatalogue bookCatalogue = new BookCatalogue();
        Author[] authors = new Author[10];
        try {
            authors[0] = new Author("Agatha", "Christie", "UK");
            authors[1] = new Author("Sun", "Tzu", "China");
            authors[2] = new Author("Hristo", "Botev", "Bulgaria");
            authors[3] = new Author("Frank", "Herbert", "USA");
            authors[4] = new Author("Tolga", "Tahsinov", "Bulgaria");
            authors[5] = new Author("George", "Lucas", "USA");
            authors[6] = new Author("George", "Orwell", "UK");
            authors[7] = new Author("Richard", "Osman", "UK");
            authors[8] = new Author("Kass", "Morgan", "USA");
            authors[9] = new Author("Haruki", "Murakami", "Japan");
        }catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        }

        Book[] books = new Book[10];
        Book bookNotInCatalogue = null;
        try {
            books[0] = new Book("Murder on the Orient Express", authors[0], 1934, 30);
            books[1] = new Book("Dune", authors[3], 1934, 67);
            books[2] = new Book("Star Wars", authors[5], 1934, 48);
            books[3] = new Book("1984", authors[6], 1934, 2);
            books[4] = new Book("On parting", authors[2], 1934, 10);
            books[5] = new Book("The Hanging of Levski", authors[2], 1934, 25);
            books[6] = new Book("The Thursday Murder Club", authors[7], 1934, 9);
            books[7] = new Book("Melancholic", authors[4], 1934, 7);
            books[8] = new Book("The 100", authors[8], 1934, 17);
            books[9] = new Book("1Q84", authors[9], 1934, 55);
            bookNotInCatalogue = new Book("Algorithms++",new Author("Preslav", "Nakov", "Bulgaria"),2013,60);
        }catch (InvalidDataException e){
            System.out.println(e.getMessage());
        }

        for (Book book : books) { //add all books
            bookCatalogue.addBook(book);
        }

        if (!bookCatalogue.borrowBook(bookNotInCatalogue)) System.out.println("The Book you tried to borrow is not in Catalogue");
        System.out.printf("Number of Books by %s, %d \n", authors[9].toString(), bookCatalogue.countBooksByAuthor(authors[9]));
        System.out.println();
        System.out.println(bookCatalogue.toString());
        System.out.println();

        System.out.println("Book Catalogue sorted by Available Quantity:");
        List<Book> sortedCatalogue = bookCatalogue.sortCatalogueByAvailableQuantity();
        for (Book book : sortedCatalogue) {
            System.out.println(book.toString());
        }
        System.out.println();

        System.out.println("Book Catalogue sorted by Title:");
        sortedCatalogue = bookCatalogue.sortCatalogueByTitle();
        for (Book book : sortedCatalogue) {
            System.out.println(book.toString());
        }
        System.out.println();

        System.out.println("Book Catalogue sorted by Author:");
        sortedCatalogue = bookCatalogue.sortCatalogueByAuthor();
        for (Book book : sortedCatalogue) {
            System.out.println(book.toString());
        }
        System.out.println();


    }
}
