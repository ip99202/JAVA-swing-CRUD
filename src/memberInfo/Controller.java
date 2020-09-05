package memberInfo;

import java.sql.*;

public class Controller {
    Connection conn = null;
    ResultSet rs = null;
    Statement st = null;

    public Controller() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/memberinfo?serverTimezone=UTC", "root",
                    "1234567890");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 회원 추가
    public void insertMember(Model model) {
        try {
            st = conn.createStatement();
            int stmt = st.executeUpdate(
                    "insert into member values ('" + model.name + "', '" + model.birth + "', '" + model.tel + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
