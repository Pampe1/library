import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Library {
    private HashMap<String, LibraryItem> catalog = new HashMap<>();

    public void addItem(LibraryItem item) {
        catalog.put(item.getId(), item);
    }

    public HashMap<String, LibraryItem> getCatalog() {
        return catalog;
    }

    public void checkout(String id) throws ItemNotFoundException, ItemNotAvailableException {
        if (!catalog.containsKey(id)) {
            throw new ItemNotFoundException("No such item");
        } else {
            if (!catalog.get(id).isAvailable()) {
                throw new ItemNotAvailableException("Not available");
            } else {
                catalog.get(id).setAvailable(false);

                if (catalog.get(id) instanceof Loanable loanable) {
                    loanable.setNumberOfLoanDays(5);
                }
            }
        }
    }

    public void returnItem(String id) throws ItemNotFoundException {
        if (catalog.containsKey(id)) {
            catalog.get(id).setAvailable(true);
        } else {
            throw new ItemNotFoundException("No such item");
        }
    }

    public LibraryItem searchByTitle(String title) {
        for (String c : catalog.keySet()) {
            LibraryItem l_item = catalog.get(c);
            if (l_item.getTitle().equalsIgnoreCase(title)) {
                return l_item;
            }
        }
        return null;
    }

    public void saveToFile(String filename) {
        LibraryData libraryData = new LibraryData();
        for (String c : catalog.keySet()) {
            LibraryItem item = catalog.get(c);
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

    public void loadFromFile(String filename) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();

        try (Scanner fileReader = new Scanner(new File(filename))) {
            while (fileReader.hasNextLine()) {
                content.append(fileReader.nextLine());
            }
        }

        Gson gson = new Gson();
        LibraryData data = gson.fromJson(content.toString(), LibraryData.class);

        for (Book b : data.books) {
            addItem(b);
        }
        for (DVD d : data.dvds) {
            addItem(d);
        }
        for (Magazine m : data.magazines) {
            addItem(m);
        }
    }
}
