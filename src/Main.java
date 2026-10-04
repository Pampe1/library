import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Library library = new Library();
        LoanService loanService = new LoanService(library);
        Storage storage = new GsonFileStorage();

        ConsoleMenu consoleMenu = new ConsoleMenu(library, loanService, storage);
        consoleMenu.run();
    }
}
