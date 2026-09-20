public class Magazine extends LibraryItem {
    private int issueNumber;
    public Magazine(String id, String title, int issueNumber) {
        super(id, title);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getDetails() {
        return "Title: " + getTitle() + "\nID: " + getId() + "\nIssue Number: " + issueNumber + "\nAvailable: " + isAvailable();
    }
}
