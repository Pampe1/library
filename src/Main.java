import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Library library = new Library();

        library.addItem(new Book("1", "Book", "Bob", "Fiction"));
        library.addItem(new DVD("2", "DVD", 48));
        library.addItem(new Magazine("3", "Magazine", 9));

        library.saveToFile("data.txt");

        Library newLibrary = new Library();
        newLibrary.loadFromFile("data.txt");

        System.out.println("=== Loaded from file ===");
        for (LibraryItem item : newLibrary.getCatalog().values()) {
            System.out.println(item.getDetails());
        }
    }
}
