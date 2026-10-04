import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConsoleMenu {
    private Library library;
    private LoanService loanService;
    private Storage storage;

    public ConsoleMenu(Library library, LoanService loanService, Storage storage) {
        this.library = library;
        this.loanService = loanService;
        this.storage = storage;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        String filename = "data.txt";

        try {
            //library.loadFromFile(filename);
            storage.load(filename, library);
        } catch (FileNotFoundException e) {
            System.out.println("Error:" + e.getMessage());
        }
        while(true) {
            System.out.println("===== Library =====\nChoose an options:\n1. Add item\n2. Issue item\n3. Return item\n4. Search\n5. Save and exit\nYour choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Which item you want to add?(Book (B)/DVD (D)/Nagazine (M)): ");
                    String add_answer = scanner.nextLine();

                    if(add_answer.equalsIgnoreCase("B")) {
                        System.out.println("ID: ");
                        String id = scanner.nextLine();
                        System.out.println("Title: ");
                        String title = scanner.nextLine();
                        System.out.println("Author: ");
                        String author = scanner.nextLine();
                        System.out.println("Genre: ");
                        String genre = scanner.nextLine();

                        Book book = new Book(id, title, author, genre);
                        library.addItem(book);
                        System.out.println("Book '" + title + "' was added!");
                    } else if (add_answer.equalsIgnoreCase("D")) {
                        System.out.println("ID: ");
                        String id = scanner.nextLine();
                        System.out.println("Title: ");
                        String title = scanner.nextLine();
                        System.out.println("Duration (minutes): ");
                        int duration = scanner.nextInt();
                        scanner.nextLine();

                        DVD dvd = new DVD(id, title, duration);
                        library.addItem(dvd);
                        System.out.println("DVD '" + title + "' was added!");
                    } else if (add_answer.equalsIgnoreCase("M")) {
                        System.out.println("ID: ");
                        String id = scanner.nextLine();
                        System.out.println("Title: ");
                        String title = scanner.nextLine();
                        System.out.println("Issue Number: ");
                        int issueNumber = scanner.nextInt();
                        scanner.nextLine();

                        Magazine magazine = new Magazine(id, title, issueNumber);
                        library.addItem(magazine);
                        System.out.println("Magazine '" + title + "' was added!");
                    } else {
                        System.out.println("Error: Wrong input");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter ID:");
                    String inout_id_check = scanner.nextLine();

                    try {
                        //library.checkout(inout_id_check);
                        loanService.checkout(inout_id_check);
                        System.out.println("Item successfully added!");
                    } catch (ItemNotAvailableException | ItemNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter ID:");
                    String inout_id_check = scanner.nextLine();

                    try {
                        //library.returnItem(inout_id_check);
                        loanService.returnItem(inout_id_check);
                        System.out.println("Item successfully returned!");
                    } catch (ItemNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enter Title:");
                    String inout_title = scanner.nextLine();

                    LibraryItem searchItem = library.searchByTitle(inout_title);

                    if(searchItem != null) {
                        System.out.println("Found: " + searchItem.getDetails());
                    } else {
                        System.out.println("Error: Item Not Found");
                    }
                    break;
                }
                case 5: {
                    storage.save(filename, library);
                    System.out.println("Exit...");
                    return;
                }
            }
        }
    }
}
