import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Authenticator {

    private Authenticator(){}

    // <username> <password>
    private ArrayList<String> userPassList;

    public signUpResult signUp(String username, String password){
        if (checkIfUserExists(username)) return signUpResult.ERROR_USERNAME;
        userPassList.add(username+"|"+password);
        save();
        return signUpResult.SUCCESS;
    }

    private boolean checkIfUserExists(String username){

        for (String userPass : userPassList) {
            int seperator = userPass.indexOf('|');
            if (userPass.substring(0,seperator).equals(username)) return true;
        }
        return false;
    }

    private void save(){
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        Gson gson = builder.create();
        String userListText = gson.toJson(this);
        FileOperator fileOperator = new FileOperator();
        fileOperator.write("userList.json",userListText,false);
    }

    private static Authenticator load(){
        FileOperator fileOperator = new FileOperator();
        String userListText =  fileOperator.read("userList.json");
        Authenticator authenticator = new Gson().fromJson(userListText, Authenticator.class);
        return authenticator;
    }

    public ArrayList<String> getUserPassList(){
        load();
        return this.userPassList;
    }


    // Singleton Design
    // Only one Library Instance should exist
    private static Authenticator authenticatorInstance;
    public static Authenticator getInstatnce(){
        if (authenticatorInstance==null){
            authenticatorInstance = load();
        }
        return authenticatorInstance;
    }



}
enum signUpResult{
    SUCCESS,
    ERROR_USERNAME
}