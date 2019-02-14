import java.util.HashMap;
import java.util.Map;

public class UserPool {


    static Map<String,String> userPool = new HashMap<String, String>();

    public void addUser(User user){

        userPool.put(user.getUsername(),user.getPassword());

    }
    public boolean checkUser(User user){

        if (userPool.containsKey(user.getUsername())){
            if (userPool.get(user.getUsername()).equals(user.getPassword())){
                return true;
            }
    }
        return false;
    }

}
