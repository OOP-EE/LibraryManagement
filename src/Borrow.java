import java.util.Calendar;
import java.util.Date;

public class Borrow {
    private static int maxDaysBorrowed = 7;
    private int id;
    private User user;
    private Book book;
    private Date dateBorrowed;
    private Date dateToReturn;
    private Date dateReturned;

    public Borrow(int id, User user, Book book) {
        this.id = makeId();
        this.user = user;
        this.book = book;
        this.dateBorrowed = new Date();
        this.dateToReturn = new Date();
        this.dateToReturn = addDateToReturned(Borrow.maxDaysBorrowed);
        this.dateReturned = null;
    }

    private boolean extend(int daysExtended){
        if (canExtend()) {
            this.dateToReturn = addDateToReturned(daysExtended);
            return true;
        }
        else return false;
    }

    //Date
    // Calender

    private Date addDateToReturned(int numOfDays){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.dateReturned);
        calendar.add(Calendar.DATE, numOfDays);
        return calendar.getTime();
    }

    private boolean canExtend(){
        //TODO
        return true;
    }

    public boolean isActive(){
        if (this.dateReturned==null) return true;
        return false;
    }

    private static int makeId(){
        //TODO
        return 0;
    }

}
