import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/skillbox?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
        String user = "root";
        String pass = "psw";
        String query = "select course_name, count(*)/(select count(*) from (select month(subscription_date), year(subscription_date) from PurchaseList " +
                "group by month(subscription_date), year(subscription_date) order by month(subscription_date)) as temp) as average from PurchaseList group by " +
                "course_name order by course_name;";

        SqlQuery.getCourseAveragePurchase(url, user, pass, query);


    }
}
