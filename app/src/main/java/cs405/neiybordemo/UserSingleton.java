package cs405.neiybordemo;

/**
 * Created by Donny on 3/2/2018.
 */

public class UserSingleton {

    private static UserSingleton instance;

    private String userID;
    private String password;

    private UserSingleton(){
        //initialization stuff here
    }

    public static UserSingleton Instance(){
        if(instance == null){
            instance = new UserSingleton();
        }
        return instance;
    }
}
