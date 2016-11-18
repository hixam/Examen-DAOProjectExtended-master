/**
 * Created by hicham.az on 18/11/2016.
 */

import java.util.HashMap;

public class Fachada {
    private static Fachada ourInstance = new Fachada();
    private HashMap<String, Usuario> cache = new HashMap();

    public static Fachada getInstance() {

        if(ourInstance == null) {
            ourInstance = new Fachada();
        }
        return ourInstance;
    }

    private Fachada() {

    }

    public Usuario getCommand(String cmd) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Usuario c = (Usuario)this.cache.get(cmd);

        if(c == null) {
            Class cl = Class.forName(cmd);
            c = (Usuario)cl.newInstance();
            this.cache.put(cmd, c);
        }
        return c;
    }
}
