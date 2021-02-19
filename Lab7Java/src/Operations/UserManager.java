package Operations;

import DB.DBManager;
import Model.UserProfile;

import javax.servlet.http.Part;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {

    public void updateUser(UserProfile userProfile, Part picture) throws SQLException {
        try
        {
            String sql = "update users set email = ?,picture = ?,age = ?,hometown = ? where name = ?;";
            PreparedStatement ps = DBManager.getConnection().prepareStatement(sql);
            ps.setString(1, userProfile.getEmail());
            ps.setBinaryStream(2, picture.getInputStream());
            ps.setString(3, userProfile.getAge());
            ps.setString(4, userProfile.getHometown());

            ps.setString(5, userProfile.getName());
            //ps.setString(6, userProfile.getPassword());

            ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public List<UserProfile> getUsersByName(String text)
    {
        List<UserProfile> userProfiles = new ArrayList<>();
        try
        {
            String sql = "select name, email, encode(picture, 'base64'), age, hometown from users where name = ?;";
            PreparedStatement ps = DBManager.getConnection().prepareStatement(sql);
            ps.setString(1, text);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String picture = rs.getString("encode");
                String age = rs.getString("age");
                String hometown = rs.getString("hometown");
                //String password = rs.getString("password");

                userProfiles.add(new UserProfile(name, email, picture, age, hometown, ""));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return userProfiles;
    }

    public List<UserProfile> getUsersByEmail(String text)
    {
        List<UserProfile> userProfiles = new ArrayList<>();
        try
        {
            String sql = "select name, email, picture, age, hometown from users where email = ?;";
            PreparedStatement ps = DBManager.getConnection().prepareStatement(sql);
            ps.setString(1, text);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String picture = rs.getString("picture");
                String age = rs.getString("age");
                String hometown = rs.getString("hometown");
                //String password = rs.getString("password");

                userProfiles.add(new UserProfile(name, email, picture, age, hometown, ""));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return userProfiles;
    }

    public List<UserProfile> getUsersByAge(String text)
    {
        List<Model.UserProfile> userProfiles = new ArrayList<>();
        try
        {
            String sql = "select name, email, picture, age, hometown from users where age = ?;";
            PreparedStatement ps = DBManager.getConnection().prepareStatement(sql);
            ps.setString(1, text);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String picture = rs.getString("picture");
                String age = rs.getString("age");
                String hometown = rs.getString("hometown");
                //String password = rs.getString("password");

                userProfiles.add(new Model.UserProfile(name, email, picture, age, hometown, ""));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return userProfiles;
    }

    public List<UserProfile> getUsersByHometown(String text)
    {
        List<Model.UserProfile> userProfiles = new ArrayList<>();
        try
        {
            String sql = "select name, email, picture, age, hometown from users where hometown = ?;";
            PreparedStatement ps = DBManager.getConnection().prepareStatement(sql);
            ps.setString(1, text);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String picture = rs.getString("picture");
                String age = rs.getString("age");
                String hometown = rs.getString("hometown");
                //String password = rs.getString("password");

                userProfiles.add(new Model.UserProfile(name, email, picture, age, hometown, ""));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return userProfiles;
    }

    public List<UserProfile> getUsers()
    {
        List<UserProfile> userProfiles = new ArrayList<>();
        try
        {
            String sql = "select name, email, picture, age, hometown from users;";
            PreparedStatement ps = DBManager.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String picture = rs.getString("picture");
                String age = rs.getString("age");
                String hometown = rs.getString("hometown");
                //String password = rs.getString("password");

                userProfiles.add(new UserProfile(name, email, picture, age, hometown, ""));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return userProfiles;
    }

    public static ArrayList<UserProfile> getBySubstring(String  text)
    {
        List<UserProfile> allUsers = new ArrayList<>();
        try
        {
            String sql = "select * from users";
            PreparedStatement stmt = DBManager.getConnection().prepareStatement(sql);
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs);
            while(rs.next())
            {
                allUsers.add(new UserProfile(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6))
                );
            }

            allUsers = allUsers.stream().filter( b -> b.getName().contains( text ) || b.getEmail().contains( text ) || b.getPicture().contains( text )|| b.getAge().contains( text )).collect(Collectors.toList());


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return (ArrayList<UserProfile>) allUsers;
    }
}
