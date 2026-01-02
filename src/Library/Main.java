package Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library = new Library();

        library.addBook(new Book("Chimp Paradox", "Steve Peters", 2012));
        library.addBook(new Book("The Richest Man in Babylon", "George S. Clason", 1926));
        library.addBook(new Book("Deception Point", "Dan Brown", 2005));

        System.out.println("=== All books ===");
        library.showAllBooks();

        System.out.println("\nEnter title to search:");
        String title = scanner.nextLine();
        Book found = library.findByTitle(title);
        System.out.println(found != null ? found : "Book not found");

        System.out.println("\nBooks after 2000:");
        library.filterByYear(2000).forEach(System.out::println);

        System.out.println("\nSorted by year:");
        library.sortByYear();
        library.showAllBooks();

        // Polymorphism
        Person member = new LibraryMember("Adil", 101);
        System.out.println("\nRole: " + member.getRole());
    }
}