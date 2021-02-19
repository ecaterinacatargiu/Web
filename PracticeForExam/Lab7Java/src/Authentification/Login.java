package Authentification;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class Login extends HttpServlet {

    public Login()
    {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        if(AuthentificationManager.validLogin(name))
        {
            loginUser(request.getSession(), name);
            response.sendRedirect("landing.jsp");
            return;
        }
        else
        {
            response.sendRedirect("login.jsp");
        }
    }

    public static void loginUser(HttpSession session, String name)
    {
        session.setAttribute("name", name);
        System.out.println("HERE'S THE SESSION NAME: ");
        System.out.println(session.getAttribute("name"));

    }

}
