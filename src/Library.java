import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Library {

    private Library(){
        books = new HashSet<>();
    }


    private HashSet<Book> books;
    private int numOfBooks;
    private Date lastModified;


    public void saveLibrary(){
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        Gson gson = builder.create();
        String libraryText = gson.toJson(libraryInstance);
        FileOperator fileOperator = new FileOperator();
        fileOperator.write("bookList.json",libraryText,false);
    }



    public void addBook(Book book){
        books.add(book);
        numOfBooks ++;
        lastModified = new Date();
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    public Date getLastModified() {
        return lastModified;
    }

    // Singleton Design
    // Only one Library Instance should exist
    private static Library libraryInstance;
    public static Library getInstatnce(){
        if (libraryInstance==null){
            libraryInstance = new Library();
        }
        return libraryInstance;
    }

}
