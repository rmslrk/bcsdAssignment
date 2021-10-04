package jdbcExample;

import java.sql.*;

public class Main {
    // 변수 설정
    private static String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    private static String DBURL = "jdbc:mysql://localhost:3306/test";
    private static String USER = "root";
    private static String PASSWORD = "qud@980314";

    public static void main(String[] args)
    {
        try {
            // DB 접속
            Class.forName(CLASSNAME);
            Connection conn = DriverManager.getConnection(DBURL, USER, PASSWORD);

            // SELECT
            String query = "SELECT * FROM user1";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);

            System.out.println("초기값 SELECT ------------------------------------------------------\n");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int sex = rs.getInt("sex");

                System.out.println("id : " + id + "\tname : " + name + "\tage : " + age + "\tsex : " + sex + "\n");
            }
            System.out.println("-------------------------------------------------------------------\n");

            // Insert
            String queryI = "INSERT INTO user1 (name, age, sex) VALUES ('Jwa', 20, 1), ('Oh', 20, 1)";
            PreparedStatement psI = conn.prepareStatement(queryI);
            psI.executeUpdate();

            // SELECT after INSERT
            rs = ps.executeQuery();

            System.out.println("SELECT after INSERT ------------------------------------------------\n");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int sex = rs.getInt("sex");

                System.out.println("id : " + id + "\tname : " + name + "\tage : " + age + "\tsex : " + sex + "\n");
            }
            System.out.println("-------------------------------------------------------------------\n");

            // UPDATE
            String queryU = "UPDATE user1 SET age = 27 where age = 29";
            PreparedStatement psU = conn.prepareStatement(queryU);
            psU.executeUpdate();

            // SELECT after UPDATE
            rs = ps.executeQuery();

            System.out.println("SELECT after UPDATE ------------------------------------------------\n");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int sex = rs.getInt("sex");

                System.out.println("id : " + id + "\tname : " + name + "\tage : " + age + "\tsex : " + sex + "\n");
            }
            System.out.println("-------------------------------------------------------------------\n");

            // DELETE
            String queryD = "DELETE from user1 where age = 20";
            PreparedStatement psD = conn.prepareStatement(queryD);
            psD.executeUpdate();

            // SELECT after DELETE
            rs = ps.executeQuery();

            System.out.println("SELECT after DELETE ------------------------------------------------\n");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int sex = rs.getInt("sex");

                System.out.println("id : " + id + "\tname : " + name + "\tage : " + age + "\tsex : " + sex + "\n");
            }
            System.out.println("-------------------------------------------------------------------\n");

            conn.close();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
