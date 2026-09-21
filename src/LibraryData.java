import java.util.ArrayList;

public class LibraryData {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<DVD> dvds = new ArrayList<>();
    ArrayList<Magazine> magazines = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return books;
    }
    public void setNewBook(Book book) {
        books.add(book);
    }

    public ArrayList<DVD> getDvds() {
        return dvds;
    }
    public void setNewDVD(DVD dvd) {
        dvds.add(dvd);
    }

    public ArrayList<Magazine> getMagazines() {
        return magazines;
    }
    public void setNewMagezine(Magazine magazine) {
        magazines.add(magazine);
    }
}
