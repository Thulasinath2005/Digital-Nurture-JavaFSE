import java.sql.*;

// Exercise 32: Insert and Update Operations in JDBC
public class JDBCInsertUpdate {

    static final String URL  = "jdbc:mysql://localhost:3306/community_portal";
    static final String USER = "root";
    static final String PASS = "your_password";

    // StudentDAO class with insert and update methods
    static class StudentDAO {
        private Connection conn;

        StudentDAO(Connection conn) { this.conn = conn; }

        // Insert new student record using PreparedStatement
        void insert(String name, String email, String grade) throws SQLException {
            String sql = "INSERT INTO students (name, email, grade) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, grade);
                int rows = ps.executeUpdate();
                System.out.println("Inserted " + rows + " row: " + name);
            }
        }

        // Update student grade using PreparedStatement
        void updateGrade(int studentId, String newGrade) throws SQLException {
            String sql = "UPDATE students SET grade = ? WHERE student_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, newGrade);
                ps.setInt(2, studentId);
                int rows = ps.executeUpdate();
                System.out.println("Updated " + rows + " row(s). ID " + studentId + " → grade " + newGrade);
            }
        }
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("✅ Connected!");
            StudentDAO dao = new StudentDAO(conn);

            // Insert sample students
            dao.insert("Alice Johnson", "alice@example.com", "A");
            dao.insert("Bob Smith",     "bob@example.com",   "B");
            dao.insert("Charlie Lee",   "charlie@example.com", "C");

            // Update a student's grade
            dao.updateGrade(1, "A+");

            System.out.println("Done. Run JDBCConnection to verify changes.");

        } catch (SQLException e) {
            System.out.println("❌ DB Error: " + e.getMessage());
        }
    }
}
