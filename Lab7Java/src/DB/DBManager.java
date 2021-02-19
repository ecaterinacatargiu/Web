package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager{

    private static Connection connection;

    public static void connect() throws SQLException {
        if(connection==null)
        {
            String url = "jdbc:postgresql://localhost:5432/UserProfiles";
            try
            {
                Class.forName("org.postgresql.Driver");
                System.out.println("hello driver");
                connection = DriverManager.getConnection(url, "postgres", "admin");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void disconnect()
    {
        try
        {
            connection.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        connection = null;
    }

    public static Connection getConnection() throws SQLException
    {
        if(connection==null)
        {
            connect();
        }
        return connection;
    }

}
