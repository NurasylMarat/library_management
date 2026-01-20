package Library;

public class Main {
    public static void main(String[] args) throws Exception {
        BookDAO dao = new BookDAO();

        dao.addBook(new Book("Thinking Fast and Slow", "Daniel Kahneman", 2011));
        dao.addBook(new Book("The Richest Man in Babylon", "George S. Clason", 1926));
        dao.addBook(new Book("Chimp Paradox", "Steve Peters", 2012));
        dao.addBook(new Book("Death on the Nile", "Agatha Christie", 1937));
        dao.addBook(new Book("Deception Point", "Dan Brown", 2001));

        dao.updateYear("Deception Point", 2005);

        dao.deleteBook("Chimp Paradox");

        dao.getAllBooks().forEach(System.out::println);
    }
}