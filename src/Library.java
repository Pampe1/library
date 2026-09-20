import java.util.HashMap;

public class Library {
    private HashMap<String, LibraryItem> catalog = new HashMap<>();

    public void addItem(LibraryItem item) {
        catalog.put(item.getId(), item);
    }

    public HashMap<String, LibraryItem> getCatalog() {
        return catalog;
    }

    public void checkout(String id) throws ItemNotFoundException, ItemNotAvailableException {
        if (!catalog.containsKey(id)) {
            throw new ItemNotFoundException("No such item");
        } else {
            if (!catalog.get(id).isAvailable()) {
                throw new ItemNotAvailableException("Not available");
            } else {
                catalog.get(id).setAvailable(false);

                if (catalog.get(id) instanceof Loanable loanable) {
                    loanable.setNumberOfLoanDays(5);
                }
            }
        }
    }

    public void returnItem(String id) throws ItemNotFoundException {
        if (catalog.containsKey(id)) {
            catalog.get(id).setAvailable(true);
        } else {
            throw new ItemNotFoundException("No such item");
        }
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
