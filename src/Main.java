import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        LibraryItem book = new Book("1", "Book", "Bob", "Fiction");
        LibraryItem dvd = new DVD("2", "DVD", 48);
        LibraryItem magazine = new Magazine("3", "Magazine", 9);

        dvd.setAvailable(false);

        if (book instanceof Loanable loanable) {
            loanable.setNumberOfLoanDays(14);
            int output = loanable.getLoanPeriodDays();
            System.out.println(output);
        }

        library.addItem(book);
        library.addItem(dvd);
        library.addItem(magazine);

       try {
           library.checkout("3");
           library.returnItem("999");
        } catch (ItemNotFoundException | ItemNotAvailableException e) {
           System.out.println("Error: " + e.getMessage());
        }

        int counter = library.getCatalog().size() - 1;

        for(String l : library.getCatalog().keySet()) {
            LibraryItem item = library.getCatalog().get(l);
            String print_item = item.getDetails();
            //System.out.println(print_item);
            if(counter > 0) {
                //System.out.println("=====================================");
            }
            counter--;
        }
    }
}
