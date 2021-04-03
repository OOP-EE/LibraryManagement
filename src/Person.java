import java.util.HashSet;

public class Person {

    public static HashSet<Person> personList;


    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String passwordHash;
    protected PrivilageCode privilge;
    private String email;

    public Person( String userName, String passwordHash, PrivilageCode privilge) {
        personList.add(this);
        this.id = Person.makeId();
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.privilge = privilge;
    }


    private static int makeId(){
        //TODO
        return 0;
    }

}

enum PrivilageCode{
    ADMIN,
    USER;
}