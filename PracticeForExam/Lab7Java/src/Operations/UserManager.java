package Operations;

import DB.DBManager;
import Model.Courses;
import Model.Persons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    public UserManager()
    {

    }

    public Persons getAll(String name)
    {
        Persons p = null;
        try
        {
            String sql = "select * from `persons` where `role` ='professor'";

            Connection conn = DBManager.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next())
            {
                if(rs.getString("name").equals(name))
                {
                    p = new Persons(rs.getInt("id"), rs.getString("name"), rs.getString("role"));
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return p;
    }

    public List<Courses> getAllCourses(int id)
    {
        List<Courses> lst = new ArrayList<>();
        try
        {
            String sql = "select * from `course` where professorid=?";
            PreparedStatement ps  = DBManager.getConnection().prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                lst.add(new Courses(rs.getInt("id"), rs.getInt("professorid"), rs.getString("name"), rs.getString("participants"), rs.getString("grades")));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lst;
    }

    public List<Courses> getStudentCourse(String name){
        List<Courses> lst = new ArrayList<>();
        try{

            PreparedStatement stmt = DBManager.getConnection().prepareStatement("SELECT * FROM courses WHERE participants LIKE ?");
            stmt.setString(1,"%"+name+";%");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                lst.add(new Courses(rs.getInt("id"), rs.getInt("professorid"), rs.getString("name"), rs.getString("participants"), rs.getString("grades")));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lst;
    }

    public void grade(int id, String newp, String newg) {
        try
        {
            PreparedStatement stmt = DBManager.getConnection().prepareStatement("UPDATE `courses` SET `participants`=?, `grades`=? WHERE `id`=?");
            stmt.setString(1,newp);
            stmt.setString(2,newg);
            stmt.setInt(3,id);
            stmt.executeUpdate();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}






