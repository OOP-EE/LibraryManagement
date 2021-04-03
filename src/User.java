import java.util.ArrayList;
import java.util.HashSet;

public class User extends Person {

    public HashSet<Borrow> borrowedBooks;

    public User(String userName, String passwordHash) {
        super(userName, passwordHash, PrivilageCode.USER);
        borrowedBooks = new HashSet<>();
    }

}
