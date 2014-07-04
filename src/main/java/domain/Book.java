package domain;

import java.util.UUID;

@SuppressWarnings("UnusedDeclaration")
public final class Book {

    private final UUID _id;
    private String _title;
    private String _author;

    public Book(UUID id) {
        if (id == null)
            throw new IllegalArgumentException("Parameter 'id' can't be null");

        _id = id;
    }

    public UUID getId() {
        return _id;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Book book = (Book) o;

        return _id.equals(book._id);

    }

    @Override
    public int hashCode() {
        return _id.hashCode();
    }
}
