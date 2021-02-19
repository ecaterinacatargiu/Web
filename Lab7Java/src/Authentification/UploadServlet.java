package Authentification;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class UploadServlet extends HttpServlet {

    public UploadServlet()
    {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part image = request.getPart("picture");
        HttpSession session = request.getSession();
        System.out.println("here");

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        String age = request.getParameter("age");
        String hometown = request.getParameter("hometown");
        String password = request.getParameter("password");

        AuthentificationManager.addUserToDB(name, email, image, age, hometown, password);

        Login.loginUser(request.getSession(), name);

        response.sendRedirect("landing.jsp");

        //RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        //rd.forward(request, response);

    }

}

