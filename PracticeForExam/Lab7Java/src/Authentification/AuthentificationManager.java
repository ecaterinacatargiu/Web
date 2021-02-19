package Authentification;

import DB.DBManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthentificationManager {

    public static void addUserToDB(String name, String role)
    {
        String sql = "insert into persons(name, role) values (?,?)";
        System.out.println(sql);
        try
        {
            PreparedStatement ps = DBManager.getConnection().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, role);
            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Boolean validLogin(String name)
    {
        try
        {
            String role = "professor";
            String sql = "select * from persons where name = '" + name +"' AND role = '" + role + "';";
            PreparedStatement ps = DBManager.getConnection().prepareStatement(sql);
            ResultSet results = ps.executeQuery();

            while(results.next())
            {
                return true;
            }
            return false;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }


}
