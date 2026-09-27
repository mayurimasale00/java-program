import java.sql.*;

public class JDBCExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "mayuri01";

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection con =
                DriverManager.getConnection(url, user, password);

            System.out.println("Database Connected Successfully!");

            // Execute query
            Statement stmt = con.createStatement();

            ResultSet rs =
                stmt.executeQuery("SELECT * FROM student");

            // Display records
            System.out.println("\nStudent Records:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("marks")
                );
            }

            // Close connection
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
} 