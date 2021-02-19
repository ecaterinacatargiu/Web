package Operations;

import Model.UserProfile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/GetUserByHometownServlet")
public class GetUserByHometownServlet extends HttpServlet {

    UserManager userManager;

    public GetUserByHometownServlet()
    {
        this.userManager = new UserManager();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<UserProfile> userProfileList = (List<UserProfile>) userManager.getUsersByHometown(request.getParameter("text"));
        PrintWriter out = new PrintWriter(response.getOutputStream());
        JSONArray jsonArray  = new JSONArray();

        userProfileList.forEach(userProfile -> {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("name", userProfile.getName());
                jsonObject.put("email", userProfile.getEmail());
                jsonObject.put("picture", userProfile.getPicture());
                jsonObject.put("age", userProfile.getAge());
                jsonObject.put("hometown", userProfile.getHometown());

                jsonArray.put(jsonObject);
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        });
        System.out.println(jsonArray.toString());
        out.flush();

        userProfileList.forEach(System.out::println);
    }
}
