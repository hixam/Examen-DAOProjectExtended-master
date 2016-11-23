import java.sql.*;
import java.util.ArrayList;
import java.util.List;


abstract class DAO extends DAOBrain {


    void insert(Object _objecto) {
        String query = getInsertQuery();
        System.out.println(query);
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            addClassFieldsParameters(preparedStatement);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                setIntField(generatedKeys.getInt(1), "id");
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object select(Class _classToLoad, int _PKey) {
        Object newObject = null;
        try {
            newObject = _classToLoad.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        String query = getSelectQuery(newObject);
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            int position = 1;
            addPrimaryKeyParameter(preparedStatement, position, _PKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                setFieldsFromResultSet(resultSet, resultSetMetaData, newObject);
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newObject;
    }
    public List selectAll(Class classToLoad) {
        List<Object> objects = new ArrayList<>();
        String query = getSelectAllQuery(classToLoad);
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Object newObject = classToLoad.newInstance();
                setFieldsFromResultSet(resultSet, resultSetMetaData, newObject);
                objects.add(newObject);
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return objects;
    }
    void update(Object _objecto) {
        String query = getUpdateQuery();
        System.out.println(query);
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            addClassFieldsParameters(preparedStatement);
            int primaryKey = getPrimaryKeyParameter();
            int position = (this.getClass().getDeclaredFields().length + 1);
            addPrimaryKeyParameter(preparedStatement, position, primaryKey);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void delete(Object _objecto) {
        String query = getDeleteQuery();
        System.out.println(query);
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            int position = 1;
            int primaryKey = getPrimaryKeyParameter();
            addPrimaryKeyParameter(preparedStatement, position, primaryKey);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
