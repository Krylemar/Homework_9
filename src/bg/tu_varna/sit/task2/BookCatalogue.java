package bg.tu_varna.sit.task2;

import java.util.*;

public class BookCatalogue {
    private Set<Book> catalogue;

    public BookCatalogue() {
        this.catalogue = new HashSet<>();
    }

    public boolean addBook(Book paramBook){
        return catalogue.add(paramBook);
    }

    public boolean removeBook(Book paramBook){
        return catalogue.remove(paramBook);
    }

    public boolean borrowBook(Book paramBook){
        for(Book book : catalogue){
            if (book != null){
                if (book.equals(paramBook)){
                    book.setAvailableQuantity(book.getAvailableQuantity()-1);
                    if (book.getAvailableQuantity() == 0) catalogue.remove(book);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean returnBook(Book paramBook){
        if (!catalogue.contains(paramBook)) return false;
        boolean bookExists = false;
        for(Book book : catalogue){
            if (book != null) {
                if (book.equals(paramBook)) {
                    book.setAvailableQuantity(book.getAvailableQuantity() + 1);
                    bookExists = true;
                }
            }
        }
        if(!bookExists) catalogue.add(paramBook);
        return true;
    }

    public int countBooksByAuthor(Author author){
        int count = 0;
        for(Book book : catalogue){
            if (book != null) {
                if (book.getAuthor().equals(author)) count++;
            }
        }
        return count;
    }

    public List<Book> sortCatalogueByAuthor(){
        List<Book> bookList = new ArrayList<>(catalogue);
        bookList.sort(Comparator.comparing(Book::getAuthor));
        return bookList;
    }

    public List<Book> sortCatalogueByAvailableQuantity(){
            List<Book> bookList = new ArrayList<>(catalogue);
            bookList.sort(Comparator.comparingInt(Book::getAvailableQuantity));
            return bookList;
    }

    public List<Book> sortCatalogueByTitle(){
            List<Book> bookList = new ArrayList<>(catalogue);
            bookList.sort(Comparator.comparing(Book::getTitle));
            return bookList;
    }

    public int countBooksPublishedAfterYear(int year){
        int count = 0;
        for (Book book : catalogue){
            if (book.getPublishingYear() > year) count++;
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Book book : catalogue){
            sb.append(book.toString()).append("\n\n");
        }
        return sb.toString();
    }
}
