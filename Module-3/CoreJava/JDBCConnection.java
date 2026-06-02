import java.sql.*;

// Exercise 31: Basic JDBC Connection
// Prerequisites: MySQL running with a 'students' table
// Add mysql-connector-j JAR to classpath before compiling
public class JDBCConnection {
    // Update these credentials for your local MySQL setup
    static final String URL  = "jdbc:mysql://localhost:3306/community_portal";
    static final String USER = "root";
    static final String PASS = "your_password";

    public static void main(String[] args) {
        System.out.println("Connecting to database...");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            System.out.println("✅ Connected to MySQL successfully!");

            // Create students table if not exists
            String createSQL = """
                CREATE TABLE IF NOT EXISTS students (
                    student_id   INT PRIMARY KEY AUTO_INCREMENT,
                    name         VARCHAR(100) NOT NULL,
                    email        VARCHAR(100),
                    grade        CHAR(1)
                )
            """;
            conn.createStatement().execute(createSQL);
            System.out.println("students table ready.");

            // Execute SELECT query
            String selectSQL = "SELECT * FROM students";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs   = stmt.executeQuery(selectSQL)) {

                System.out.println("\nStudent Records:");
                System.out.printf("%-5s %-20s %-30s %-5s%n", "ID", "Name", "Email", "Grade");
                System.out.println("-".repeat(65));

                boolean hasRows = false;
                while (rs.next()) {
                    hasRows = true;
                    System.out.printf("%-5d %-20s %-30s %-5s%n",
                        rs.getInt("student_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("grade"));
                }
                if (!hasRows) System.out.println("(No records found — run JDBCInsertUpdate to add data)");
            }

        } catch (SQLException e) {
            System.out.println("❌ DB Error: " + e.getMessage());
            System.out.println("Make sure MySQL is running and credentials are correct.");
        }
    }
}
