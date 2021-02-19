package Operations;

import Model.Courses;
import Model.Persons;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CoursesCtrl")
public class CoursesCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Persons user = (Persons)request.getSession().getAttribute("user");
        UserManager db = new UserManager();
        List<Courses> lst = db.getAllCourses(user.getId());
        PrintWriter out = new PrintWriter(response.getOutputStream());
        lst.forEach(courses -> {
            out.print("<p>"+courses.getName()+"</p>");
            out.print("<p>Students  "+courses.getParticipants()+"</p>");
            out.print( "<p>Grade  "+courses.getGrades()+"</p>");
            out.print("<button onclick=cursclick("+courses.getId()+")>Assign a Grade</button><hr>");
        });
        out.flush();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserManager db = new UserManager();
        Persons user = (Persons)request.getSession().getAttribute("user");
        List<Courses> lst = db.getAllCourses(user.getId());

        Courses course = lst.stream().filter(courses -> courses.getId()==Integer.parseInt(request.getParameter("id"))).findFirst().get();

        String participants = course.getParticipants();
        String grades = course.getGrades();
        String[] lstp = participants.split(";");
        String[] lstg = grades.split(";");
        String name = request.getParameter("name");
        String grade = request.getParameter("grade");
        int i;
        boolean found = false;
        for(i=0;i<lstp.length;i++)
        {
            if(lstp[i].equals(name))
            {
                found = true;
                lstg[i] = grade;
            }
        }
        StringBuilder newp= new StringBuilder();
        StringBuilder newg = new StringBuilder();

        for(i=0;i<lstp.length;i++)
        {
            if(!lstp[i].equals(""))
            {
                newp.append(lstp[i]).append(";");
                newg.append(lstg[i]).append(";");
            }
        }
        if(found==false)
        {
            newp.append(name).append(";");
            newg.append(grade).append(";");
        }
        db.grade(course.getId(), newp.toString(), newg.toString());
    }

}
