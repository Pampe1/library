public abstract class LibraryItem {
    private String id;
    private String title;
    private boolean isAvailable = true;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean new_options) {
        isAvailable = new_options;
    }

    public abstract String getDetails();
}
