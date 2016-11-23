/**
 * Created by hicham.az on 23/11/2016.
 */
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import sun.invoke.empty.Empty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddUserServlet extends HttpServlet {
    Logger log = Logger.getLogger(AddUserServlet.class);
    UserImplement userimplent = new UserImplement();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = null;
        String password = null;
        String etakName = null;
        try {
            JSONObject jsonObjectReceived = new JSONObject(getJson(request));
            name = jsonObjectReceived.getString("name");
            password = jsonObjectReceived.getString("password");
            etakName = jsonObjectReceived.getString("etakemonName");
        } catch (NumberFormatException | JSONException e) {
            e.printStackTrace();
        }

        User user = userimplent.findUser(name, password);
        userimplent.insertEtakemon(user, etakName);
        log.info("Etakemon " + etakName + " agregado a  " + user.getName());
    }

    private String getJson(HttpServletRequest request) {
        String get = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            get = in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return get;
    }
}
