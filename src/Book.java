import java.util.HashMap;
import java.util.HashSet;

public class Book {

    public static HashSet<Book> bookShelf;

    private int isbn;
    private String name;
    private Publication publicationId;
    private int dateReleased;
    private HashSet<Author> authors;

    public Book(int isbn, String name, Publication publicationId, int dateReleased, HashSet<Author> authors) {
        this.isbn = isbn;
        this.name = name;
        this.publicationId = publicationId;
        this.dateReleased = dateReleased;
        this.authors = authors;
        bookShelf.add(this);
    }
}
