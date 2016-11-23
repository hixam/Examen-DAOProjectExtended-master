import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*
public class User extends DAO {
    private int id;
    private String name;
    private String address;

    public User (String name, String address) {
        this.name = name;
        this.address = address;
    }
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
*/
public class User extends DAO {

    String id;
    String name;
    String apellido;

    public List<etakemons> getEtakemonList() {
        return etakemonList;
    }

    public void setEtakemonList(List<etakemons> etakemonList) {
        this.etakemonList = etakemonList;
    }

    public List<etakemons> etakemonList = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  //  public List<User> milistaUsers = new ArrayList<User>();
    public HashMap<String, User> ListUsers = new HashMap();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }



    public User() {
    }
    public User insertUserToList( String _name, String _pass)
    {
        User usuario = new User(_name,_pass);
      //  ListUsers.put(usuario.id, usuario);
        return usuario;
    }



}