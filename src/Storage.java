import java.io.FileNotFoundException;
public interface Storage {
    public void save (String filename, Library library);
    public void load (String filename, Library library) throws FileNotFoundException;
}
