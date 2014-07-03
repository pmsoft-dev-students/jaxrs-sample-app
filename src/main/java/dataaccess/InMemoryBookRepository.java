package dataaccess;

import domain.Book;
import domain.BookRepository;

import java.util.Collection;

public class InMemoryBookRepository implements BookRepository {

    private final Collection<Book> _baseCollection;

    public InMemoryBookRepository(Collection<Book> baseCollection) {
        if (baseCollection == null)
            throw new IllegalArgumentException("Parameter 'baseCollection' can't be null");

        _baseCollection = baseCollection;
    }

    @Override
    public void add(Book book) {
        _baseCollection.add(book);
    }

    @Override
    public void remove(Book book) {
        _baseCollection.remove(book);
    }

    @Override
    public Iterable<Book> getAll() {
        return _baseCollection;
    }
}
