package Authentification;

import DB.DBManager;

import javax.servlet.http.Part;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthentificationManager {

    public static void addUserToDB(String name, String email, Part picture, String age, String hometown, String password)
    {
        String sql = "insert into users(name, email, picture, age, hometown, password) values (?,?,?,?,?,?)";
        System.out.println(sql);
        InputStream fis = null;
        try
        {
            PreparedStatement ps = DBManager.getConnection().prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,email);
            fis = picture.getInputStream();
            ps.setBinaryStream(3, fis);
            ps.setString(4,age);
            ps.setString(5,hometown);
            ps.setString(6,password);
            ps.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Boolean validLogin(String name, String password)
    {
        try
        {
            String sql = "select * from users where name = '" + name +"' AND password = '" + password + "';";
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
