import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ericmassip on 18/10/16.
 */
public class DAOTest {
    User user1;
    User user2;
    Dept dept1;

    @Before
    public void setUp() throws Exception {
        user1 = new User("Toni", "EETAC");
        user2 = new User("Joan", "Mataró Park");
        dept1 = new Dept("Entel", "Guardiola", "Informática y eso");
        user1.insert();
        user2.insert();
        dept1.insert();
    }

    @After
    public void tearDown() throws Exception {
        user1.delete();
        user2.delete();
        dept1.delete();
        this.user1 = null;
        this.user2 = null;
        this.dept1 = null;
    }

    @Test
    public void insert() throws Exception {
        int idUser1 = user1.getId();
        user2.select(idUser1);
        assertEquals(user2.getId(), user1.getId());
        assertEquals(user2.getName(), user1.getName());
    }

    @Test
    public void select() throws Exception {
        int idDept1 = dept1.getId();
        Dept dept2 = new Dept("IBM", "Enrique", "Cambiar el mundo básicamente");
        dept2.select(idDept1);
        assertEquals(dept2.getId(), dept1.getId());
        assertEquals(dept2.getName(), dept1.getName());
        assertEquals(dept2.getDirector(), dept1.getDirector());
        assertEquals(dept2.getDescription(), dept1.getDescription());
        dept2.delete();
        int idUser1 = user1.getId();
        User user3 = new User("Roberto", "Bcn fons a la dreta");
        user3.select(idUser1);
        assertEquals(user1.getId(), user3.getId());
        assertEquals(user1.getName(), user3.getName());
        assertEquals(user1.getAddress(), user3.getAddress());
        user3.delete();
    }

    @Test
    public void update() throws Exception {
        assertEquals("Informática y eso", dept1.getDescription());
        dept1.setDescription("No sólo Informática, this is Development");
        dept1.update();
        assertEquals("No sólo Informática, this is Development", dept1.getDescription());
        assertEquals("Mataró Park", user2.getAddress());
        user2.setAddress("Ànec Blau");
        user2.update();
        assertEquals("Ànec Blau", user2.getAddress());
    }

    @Test
    public void delete() throws Exception {
        int idUserABorrar = user2.getId();
        user2.delete();
        User user3 = new User("Anabel", "Viladecans");
        user3.select(idUserABorrar);
        assertNotEquals(user2.getId(), user3.getId());
        assertNotEquals(user2.getName(), user3.getName());
        assertNotEquals(user2.getAddress() , user3.getAddress());
    }

}