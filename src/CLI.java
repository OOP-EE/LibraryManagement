import java.util.Scanner;

public class CLI {

    // Get the command
    // Parse the command
    // Interpret and run the command

    private Scanner scanner;

    public CLI(){
        scanner = new Scanner(System.in);
    }

    public void prompt(){
        switch(State.getInstatnce().getLabel()) {
            case AUTH:
                System.out.println("sign up ? sign in");
                break;
            case SIGN_IN:
                System.out.println("Enter username and password in the fowllowing format: <username>|<password>");
                // <username>|<password>

                break;
            case SIGN_UP:
                System.out.println("Enter username and password in the fowllowing format: <username>|<password>");

            case MENU_ADMIN:
                // <command>

                break;
            case MENU_USER:
                // <command>

                break;
            default:
                // Abort
        }
    }

    public void getCommand(){
        String commandString = scanner.nextLine();
        parseCommand(commandString ,State.getInstatnce());
    }
    public void parseCommand(String commandString ,State state){
        switch(state.getLabel()) {
            case AUTH:
                if (commandString.equals("sign in")){
                    State.getInstatnce().setLabel(StateLabel.SIGN_IN);
                }else if (commandString.equals("sign up")){
                    State.getInstatnce().setLabel(StateLabel.SIGN_UP);
                }
                break;
            case SIGN_IN:
                // <username>|<password>

                break;
            case SIGN_UP:
                int seperatorInd = commandString.indexOf('|');
                String username = commandString.substring(0,seperatorInd);
                String password = commandString.substring(seperatorInd+1);
                signUpResult result = Authenticator.getInstatnce().signUp(username,password);
                if (result==signUpResult.SUCCESS)
                    State.getInstatnce().setLabel(StateLabel.MENU_USER);
                else
                    State.getInstatnce().setLabel(StateLabel.AUTH);
                break;
            case MENU_ADMIN:
                // <command>

                break;
            case MENU_USER:
                // <command>

                break;
            default:
                // Abort
        }
    }

}
