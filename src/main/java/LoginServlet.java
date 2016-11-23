import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hicham.az on 23/11/2016.
 */
public class LoginServlet extends HttpServlet {
    private Logger log = Logger.getLogger(LoginServlet.class);
    private UserImplement userImplement = new UserImplement();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream out = response.getOutputStream();
        String username = null;
        String password = null;
        try {
            JSONObject jsonObjectReceived = new JSONObject(getJson(request));
            username = jsonObjectReceived.getString("name");
            password = jsonObjectReceived.getString("password");
        } catch (NumberFormatException | JSONException e) {
            e.printStackTrace();
        }

        boolean isRegistered = userImplement.isRegistered(username, password);
        if(!isRegistered) log.info(username + " login Fail");
        else
            log.info(username + " login Fail");


        JSONObject jsonObjectToSend = null;
        try {
            jsonObjectToSend = new JSONObject();
            jsonObjectToSend.put("isRegistered", isRegistered);
        } catch (NumberFormatException | JSONException e) {
            e.printStackTrace();
        }

        if (jsonObjectToSend != null) out.print(jsonObjectToSend.toString());
        else out.print("");
    }

    private String getJson (HttpServletRequest request) {
        String recibido = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            recibido = in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recibido;
    }
}
