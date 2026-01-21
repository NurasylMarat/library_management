package Library;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        BookCRUD crud = new BookCRUD();
        Library library = new Library();

        while(true){
            System.out.println("1 - Add book");
            System.out.println("2 - Show all books");
            System.out.println("3 - Update year by title");
            System.out.println("4 - Delete by title");
            System.out.println("5 - Find by title");
            System.out.println("6 - Filter by year(>=)");
            System.out.println("7 - Sort by year");
            System.out.println("0 - exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice == 0) {
                break;
            }

            if(choice == 1) {
                System.out.print("Title: ");
                String title = sc.nextLine();
                System.out.print("Author: ");
                String author = sc.nextLine();
                System.out.print("Year: ");
                int year = sc.nextInt();
                sc.nextLine();

                Book book = new Book(title, author, year);
                crud.addBook(book);
                System.out.println("Added successfully.");
            }

            if(choice == 2) {
                for (Book b : crud.getAllBooks()) {
                    System.out.println(b);
                }
            }

            if(choice == 3) {
                System.out.print("Enter title: ");
                String title = sc.nextLine();

                System.out.print("Enter new year: ");
                int newYear = sc.nextInt();
                sc.nextLine();

                boolean ok = crud.updateYear(title, newYear);

                if (ok) System.out.println("Updated successfully.");
                else System.out.println("Not found.");
            }

            if(choice == 4) {
                System.out.println("Enter title: ");
                String title = sc.nextLine();

                boolean ok = crud.deleteByTitle(title);
                if (ok) System.out.println("Deleted successfully.");
                else System.out.println("Not found.");
            }

            if(choice == 5) {
                System.out.print("Enter title: ");
                String title = sc.nextLine();

                Book found = crud.findByTitle(title);
                if (found == null) System.out.println("Not found.");
                else System.out.println("Found: " + found);
            }

            if(choice == 6) {
                System.out.println("From year: ");
                int year = sc.nextInt();
                sc.nextLine();

                List<Book> filtered = crud.filterByYear(year);
                if (filtered.isEmpty()) System.out.println("No books.");
                else {
                    for (Book b : filtered) {
                        System.out.println(b);
                    }
                }
            }

            if(choice == 7) {
                List<Book> sorted = crud.sortByYear();
                System.out.println("Sorted successfully.");
                for (Book b: sorted) {
                    System.out.println(b);
                }
            }
        }
    }
}