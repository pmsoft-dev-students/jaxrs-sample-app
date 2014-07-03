package domain;

public interface BookRepository {
    void add(Book book);
    void remove(Book book);
    Iterable<Book> getAll();
}
