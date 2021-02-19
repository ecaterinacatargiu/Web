package Operations;

import Model.UserProfile;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/GetUserByNameServlet")
public class GetUserByNameServlet extends HttpServlet {

    UserManager userManager;

    public GetUserByNameServlet()
    {
        this.userManager = new UserManager();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String text = request.getParameter("text");
        List<UserProfile> userProfileList = (List<UserProfile>) userManager.getUsersByName(text);
        PrintWriter out = response.getWriter();
        JSONArray jsonArray  = new JSONArray();

        userProfileList.forEach(userProfile -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", userProfile.getName());
            jsonObject.put("email", userProfile.getEmail());
            jsonObject.put("picture", userProfile.getPicture());
            jsonObject.put("age", userProfile.getAge());
            jsonObject.put("hometown", userProfile.getHometown());

            jsonArray.add(jsonObject);
        });


        System.out.println(jsonArray.toJSONString());
        out.println(jsonArray.toJSONString());
        out.flush();

        userProfileList.forEach(System.out::println);


    }
}

