import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        CLI commandLineInterface = new CLI();
        while(true){
            commandLineInterface.prompt();
            commandLineInterface.getCommand();
        }
    }

}
