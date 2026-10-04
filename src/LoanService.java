public class LoanService {
    private Library library;

    public LoanService(Library library) {
        this.library = library;
    }

    public void checkout(String id) throws ItemNotFoundException, ItemNotAvailableException {
        if (!library.getCatalog().containsKey(id)) {
            throw new ItemNotFoundException("No such item");
        } else {
            if (!library.getCatalog().get(id).isAvailable()) {
                throw new ItemNotAvailableException("Not available");
            } else {
                library.getCatalog().get(id).setAvailable(false);

                if (library.getCatalog().get(id) instanceof Loanable loanable) {
                    loanable.setNumberOfLoanDays(5);
                }
            }
        }
    }

    public void returnItem(String id) throws ItemNotFoundException {
        if (library.getCatalog().containsKey(id)) {
            library.getCatalog().get(id).setAvailable(true);
        } else {
            throw new ItemNotFoundException("No such item");
        }
    }
}
