import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String url="jdbc:mysql://127.0.0.1:3306/employee_db";
    private static final String username="root";
    private static final String password="Vivek@9561";

    public static Connection getConnection(){
        Connection conn = null;
        try {
        conn=DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}