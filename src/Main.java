import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<LibraryItem> library = new ArrayList<>();

        LibraryItem book = new Book("1", "Book", "Bob", "Fiction");
        LibraryItem dvd = new DVD("2", "DVD", 48);
        LibraryItem magazine = new Magazine("3", "Magazine", 9);

        dvd.setAvailable(false);

        if (book instanceof Loanable loanable) {
            loanable.setNumberOfLoanDays(14);
            int output = loanable.getLoanPeriodDays();
            System.out.println(output);
        }

        library.add(book);
        library.add(dvd);
        library.add(magazine);

        int counter = library.size() - 1;

        for(LibraryItem l : library) {
            String output_console = l.getDetails();
            System.out.println(output_console);
            if(counter > 0) {
                System.out.println("=====================================");
            }
            counter--;
        }
    }
}
