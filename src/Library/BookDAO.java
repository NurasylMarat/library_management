package Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void addBook (Book book) throws SQLException {
        String sql = "INSERT INTO books(title, year) VALUES (?, ?)";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, book.getTitle());
        stmt.setInt(2, book.getYear());
        stmt.executeUpdate();

        conn.close();
    }


    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT title, year FROM books";

        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            String title = rs.getString("title");
            int year = rs.getInt("year");
            }

        return books;
        }


    public void updateYear(String title, int newYear) throws SQLException {
        String sql = "UPDATE books SET year = ? WHERE title = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, newYear);
        stmt.setString(2, title);
        stmt.executeUpdate();
        }


    public void deleteBook(String title) throws SQLException {
        String sql = "DELETE FROM books WHERE title = ?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, title);
        stmt.executeUpdate();
    }
}
