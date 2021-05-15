public class State {

    private StateLabel label;

    public State(){
        this.label = StateLabel.AUTH;
    }


    public StateLabel getLabel(){
        return this.label;
    }


    public void setLabel(StateLabel label) {
        this.label = label;
    }

    // Singleton Design
    // Only one State Instance should exist
    private static State stateInstance;
    public static State getInstatnce(){
        if (stateInstance==null){
            stateInstance = new State();
        }
        return stateInstance;
    }
}

enum StateLabel{
    AUTH,
    SIGN_IN,
    SIGN_UP,
    MENU_USER,
    MENU_ADMIN
}