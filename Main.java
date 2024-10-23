import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String sql = "SELECT * FROM vehicle_details";
        String url="jdbc:mysql://localhost:3306/database_name";
        String user="USERNAME";
        String password="PASSWORD";

        // make use of try-catch to handle the exception
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {  // Loop through all the rows
                String state = rs.getString(1);
                String district = rs.getString(2);
                String seriesChar = rs.getString(3);
                String seriesNum = rs.getString(4);
                String ownerName = rs.getString(5);
                String ownerMobNo = rs.getString(6);
                String insValidFrom = rs.getString(7);
                String insValidTo = rs.getString(8);
                String pucValidFrom = rs.getString(9);
                String pucValidTo = rs.getString(10);

                // Print all column values for each row
                System.out.println("State: " + state + ", District: " + district +
                        ", Series Char: " + seriesChar + ", Series Num: " + seriesNum +
                        ", Owner Name: " + ownerName + ", Owner Mobile: " + ownerMobNo +
                        ", Insurance Valid From: " + insValidFrom + ", Insurance Valid To: " + insValidTo +
                        ", PUC Valid From: " + pucValidFrom + ", PUC Valid To: " + pucValidTo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
