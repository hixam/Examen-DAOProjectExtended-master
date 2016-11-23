import java.util.List;

/**
 * Created by hicham.az on 18/11/2016.
 */
public interface Usuario {

     //String User(String id, String name, String apellido);
     User AddUser(String _Name, String _Password);
     void UpdateUser(User _user,String id, String name);
     User selectUser(int primaryKey);
     etakemons insertEtakemon(User _usuario, String _Name);
     List<etakemons> selectEtakemons(User user);

}
