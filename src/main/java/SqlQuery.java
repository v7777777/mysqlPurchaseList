import java.sql.*;

public class SqlQuery {

    public static void getCourseAveragePurchase (String url, String user, String pass, String query) throws SQLException {

        try (  Connection connection = DriverManager.getConnection(url, user, pass);
               Statement statement =connection.createStatement())

       { ResultSet result = statement.executeQuery(query);

        while (result.next())
        {
            String course_name = result.getString("course_name");
            Float average_per_month = result.getFloat("average");

            System.out.printf("%-34s %6.2f\n", course_name, average_per_month);
        }
    }

       catch (SQLException ex) {ex.printStackTrace();}
} }
