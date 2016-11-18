/**
 * Created by hicham.az on 18/11/2016.
 */
public class etakemons extends DAO {
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

    private int id;

    public etakemons(int id, String name) {
        this.id = id;
        this.name = name;
    }
public etakemons(){}
    private String name;
}
