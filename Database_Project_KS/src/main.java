import java.sql.*;

public class main {
    public static void main(String [] argv) throws Exception
    {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby:addressbook", "deitel", "deitel");
        Statement st = con.createStatement();
        int State = st.executeUpdate("ALTER TABLE Addresses ADD USState VARCHAR(5)");
        System.out.println("Query OK, " + State + "rows affected");
    }
}
