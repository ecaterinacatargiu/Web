package Operations;

import Model.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UpdateServlet")
@MultipartConfig(maxFileSize = 16177215)

public class UpdateServlet extends HttpServlet {

    UserManager userManager;

    public UpdateServlet()
    {
        this.userManager = new UserManager();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try
        {
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("name");
            //String password = (String) session.getAttribute("password");

            String email = request.getParameter("email");
            //String picture = request.getParameter("picture");
            Part picture = request.getPart("picture");
            String age = request.getParameter("age");
            String hometown = request.getParameter("hometown");

            UserProfile userProfile = new UserProfile(name, email, "", age, hometown, "");
            userManager.updateUser(userProfile,picture);

            response.sendRedirect("landing.jsp");
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response){

    }
}
