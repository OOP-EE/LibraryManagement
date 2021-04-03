import java.util.HashSet;

public class Admin extends Person{

    public Admin(String userName, String passwordHash) {
        super(userName, passwordHash, PrivilageCode.ADMIN);
    }

}
