package Library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }


    public Book findByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }


    public List<Book> filterByYear(int year) {
        List<Book> result = new ArrayList<>();

        for (Book b : books) {
            if (b.getYear() >= year) {
                result.add(b);
            }
        }

        return result;
    }


    public void sortByYear() {
        books.sort(Comparator.comparingInt(Book::getYear));
    }

    public void showAllBooks() {
        books.forEach(System.out::println);
    }

    public boolean updateYear(String title, int newYear) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                b.setYear(newYear);
                return true;
            }
        }
        return false;
    }

    public boolean deleteByTitle(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }
}