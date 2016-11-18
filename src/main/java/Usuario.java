/**
 * Created by hicham.az on 18/11/2016.
 */
public interface Usuario {

     String GetUsers();
     String User(String id, String name, String apellido);
     String UpdateUser(String id, String name,String apellido);
     String GetEtakemons();
     String AddEtakemons();
}
