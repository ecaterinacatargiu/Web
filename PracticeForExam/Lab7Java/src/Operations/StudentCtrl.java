package Operations;

import Model.Courses;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/StudentCtrl")
public class StudentCtrl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserManager db = new UserManager();
        List<Courses> lst = db.getStudentCourse(request.getParameter("name"));
        PrintWriter out = new PrintWriter(response.getOutputStream());
        lst.forEach(courses -> {
            out.print("<p>"+courses.getName()+"</p>");
            out.print("<p>Students  "+courses.getParticipants()+"</p>");
            out.print( "<p>Grade  "+courses.getGrades()+"</p>");
        });
        out.flush();
    }
}
