public class Book extends LibraryItem implements Loanable{
    private String author;
    private String genre;
    private int numberOfLoanDays = 0;
    public Book(String id, String title, String author, String genre) {
        super(id, title);
        this.author = author;
        this.genre = genre;
    }


    @Override
    public String getDetails() {
        return "Title: " + getTitle() + "\nID: " + getId() + "\nAuthor: " + author + "\nGenre: " + genre + "\nAvailable: " + isAvailable();
    }
    @Override
    public int getLoanPeriodDays() {
        return numberOfLoanDays;
    }
    @Override
    public void setNumberOfLoanDays(int period) {
        if(period > 0) {
            numberOfLoanDays = period;
        }
    }
}
