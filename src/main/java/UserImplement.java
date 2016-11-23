
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by hicham.az on 23/11/2016.
 */

public class UserImplement extends DAO implements Usuario {  /* falta implementar las demas*/
    private Logger log = Logger.getLogger( UserImplement.class.toString());

    @Override
    public User AddUser(String username, String password) {
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.insert(user);
        log.info("User added: " + user.getName());
        return user;
    }

    @Override
    public void UpdateUser(User userToUpdate, String username, String password) {
        userToUpdate.setName(username);
        userToUpdate.setPassword(password);
        this.UpdateUser(userToUpdate, username,password);
        log.info("User updated: " + userToUpdate.getId() + " " + userToUpdate.getName() + " " + userToUpdate.getPassword());
    }

    @Override
    public User selectUser(int primaryKey) {
        User selectedUser = new User();
        selectedUser = (User) selectedUser.select(User.class, primaryKey);
        log.info("selectedUser: " + selectedUser.getName());
        return selectedUser;
    }

    @Override
    public etakemons insertEtakemon(User user, String name) {
        etakemons etakemon = new etakemons();
        etakemon.setName(name);
        etakemon.setId(Integer.parseInt(user.getId()));
        etakemon.insert(etakemon);
        log.info("Etakemon added: " + etakemon.getName());
        return etakemon;
    }

    @Override
    public List<etakemons> selectEtakemons(User user) {
        setEtakemonsFromDatabase(user);
        return user.getEtakemonList();
    }

    private void setEtakemonsFromDatabase(User user) {
        List<etakemons> userEtakemons = new ArrayList<>();
        String query = "SELECT * FROM Etakemon WHERE userId = ?";
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setObject(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                etakemons etakemon = new etakemons();
                setFieldsFromResultSet(resultSet, resultSetMetaData, etakemon);
                userEtakemons.add(etakemon);
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        user.setEtakemonList(userEtakemons);
        log.info(user.getName() + "'s etakemons all set from database");
    }

    private List<User> getAllUsers() {
        User user = new User();
        return user.selectAll(User.class);
    }



    public boolean isRegistered(String username, String password) {
        boolean isRegistered = false;
        for (User user : getAllUsers()) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                isRegistered = true;
            }
        }
        return isRegistered;
    }

    public User findUser(String username, String password) {
        User foundUser = null;
        for (User user : getAllUsers()) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                foundUser = user;
            }
        }
        return foundUser;
    }

}
