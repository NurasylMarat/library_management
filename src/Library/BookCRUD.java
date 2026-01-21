package Library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookCRUD {

    public void addBook (Book book) {
        String sql = "INSERT INTO books(title, author, year) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getYear());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String title = rs.getString("title");
                String author = rs.getString("author");
                int year = rs.getInt("year");

                Book book = new Book(title, author, year);
                books.add((book));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return books;
    }


    public boolean updateYear(String title, int newYear) {
        String sql = "UPDATE books SET year = ? WHERE title = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, newYear);
                stmt.setString(2, title);
                int affectedRows = stmt.executeUpdate();
                return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean deleteByTitle(String title) {
        String sql = "DELETE FROM books WHERE title = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Book findByTitle(String title) {
        String sql = "SELECT * FROM books WHERE title = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                Book book = new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year")
                );
                conn.close();
                return book;
            } conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> filterByYear(int year) {
        List<Book> result = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE year >= ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, year);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                result.add(new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year")
                ));
            }
            conn.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Book> sortByYear() {
        List<Book> result = new ArrayList<>();
        String sql = "SELECT * FROM books ORDER BY year";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                result.add(new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("year")
                ));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}