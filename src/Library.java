import java.util.HashMap;

public class Library {
    private HashMap<String, LibraryItem> catalog = new HashMap<>();

    public void addItem(LibraryItem item) {
        catalog.put(item.getId(), item);
    }

    public HashMap<String, LibraryItem> getCatalog() {
        return catalog;
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
}
