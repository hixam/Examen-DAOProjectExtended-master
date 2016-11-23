import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Main {


    public static void main(String[] args) throws Exception {
       /* User us = new User();
        User us2 = new User();

        Gson json = new Gson();
        Gson json2 = new Gson();
        User user1 = new User("Toni", "Avenida Diagonal 11");
        user1.insert();
        User user2 = new User("Juan", "Carrer Molinot 5-7");
        user2.insert();
        user2.setAddress("Plaça Muntanyeta 14");
        user2.update();
        Dept dept1 = new Dept("Entel", "EETAC", "Telemática y eso");
        dept1.insert();
        String JSN = json.toJson(user1);
        String JSN2= json.toJson(user2);
        System.out.print("los json es:  " + JSN + "///***///"+ JSN2+"/n/");
     /*   User usuarioConvertido1 = json.fromJson(JSN, User.class);
        User usuarioConvertido2 = json.fromJson(JSN2, User.class);
        System.out.print("los usuarioConvertidos son:  " + usuarioConvertido1 + "///***///"+ usuarioConvertido2);*/

        // dept1.delete();
        HashMap<String, User> ListUsers = new HashMap();
        User usr = new User();
        List<etakemons> etak = new ArrayList<etakemons>();
        etakemons mietak = new etakemons();

        Fachada.getInstance().getCommand("User").AddUser("usuario1","pass");
        Fachada.getInstance().getCommand("User").AddUser( "usuario2","pass");
        Fachada.getInstance().getCommand("User").AddUser("usuario3","pass");
        Fachada.getInstance().getCommand("User").AddUser("usuario4","pass");
        Fachada.getInstance().getCommand("User").AddUser("usuario5","pass");

        ListUsers.put("1", usr.insertUserToList("hicham","az"));
        ListUsers.put("2", usr.insertUserToList("asddsa","az"));
        mietak.setId(1); mietak.setName("testname");
        etak.add(mietak);
        mietak.setId(2); mietak.setName("testname2");
        etak.add(mietak);


        ListUsers.forEach((k,v) -> v.insert(k) );



    }

}
