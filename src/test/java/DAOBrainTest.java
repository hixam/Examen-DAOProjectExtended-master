import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ericmassip on 11/10/16.
 */
public class DAOBrainTest {
    User user1;
    User user2;
    Dept dept1;

    @Before
    public void setUp() throws Exception {
        user1 = new User("Toni", "EETAC");
        user2 = new User("Joan", "Mataró Park");
        dept1 = new Dept("Entel", "Guardiola", "Informática y eso");
    }

    @After
    public void tearDown() throws Exception {
        this.user1 = null;
        this.user2 = null;
        this.dept1 = null;
    }

    @Test
    public void getInsertQuery() throws Exception {
        assertEquals("INSERT INTO User (id,name,address) VALUES (?,?,?)", user1.getInsertQuery());
    }

    @Test
    public void getSelectQuery() throws Exception {
        assertEquals("SELECT * FROM User WHERE id=?", user1.getSelectQuery());
    }

    @Test
    public void getUpdateQuery() throws Exception {
        assertEquals("UPDATE User SET id=?,name=?,address=? WHERE id=?", user1.getUpdateQuery());
    }

    @Test
    public void getDeleteQuery() throws Exception {
        assertEquals("DELETE FROM Dept WHERE id=?", dept1.getDeleteQuery());
    }

    @Test
    public void getGetterName() throws Exception {
        assertEquals("getName", user2.getGetterName("name"));
    }

    @Test
    public void getPrimaryKeyParameter() throws Exception {
        assertEquals(0, user1.getPrimaryKeyParameter());
    }

}