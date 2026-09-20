public class DVD extends LibraryItem implements Loanable{
    private int durationMinutes;
    private int numberOfLoanDays = 0;

    public DVD(String id, String title, int durationMinutes) {
        super(id, title);
        this.durationMinutes = durationMinutes;
    }

    @Override
    public String getDetails() {
        return "Title: " + getTitle() + "\nID: " + getId() + "\nDuration (minutes): " + durationMinutes + "\nAvailable: " + isAvailable();
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
