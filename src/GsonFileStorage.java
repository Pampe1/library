import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GsonFileStorage implements Storage {
    @Override
    public void save (String filename, Library library) {
        LibraryData libraryData = new LibraryData();
        for (String c : library.getCatalog().keySet()) {
            LibraryItem item = library.getCatalog().get(c);
            if (item instanceof Book book) {
                libraryData.setNewBook(book);
            }
            if (item instanceof DVD dvd) {
                libraryData.setNewDVD(dvd);
            }
            if (item instanceof Magazine magazine) {
                libraryData.setNewMagezine(magazine);
            }
        }
        Gson gson = new Gson();
        String json = gson.toJson(libraryData);

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(json);
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }
    @Override
    public void load (String filename, Library library) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();

        try (Scanner fileReader = new Scanner(new File(filename))) {
            while (fileReader.hasNextLine()) {
                content.append(fileReader.nextLine());
            }
        }

        Gson gson = new Gson();
        LibraryData data = gson.fromJson(content.toString(), LibraryData.class);

        for (Book b : data.books) {
            library.addItem(b);
        }
        for (DVD d : data.dvds) {
            library.addItem(d);
        }
        for (Magazine m : data.magazines) {
            library.addItem(m);
        }
    }
}
