package dataaccess;

import com.google.common.collect.Sets;
import domain.Book;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class InMemoryBookRepositoryTestCase {

    private InMemoryBookRepository createSystemUnderTest(Collection<Book> baseCollection) {
        return new InMemoryBookRepository(baseCollection);
    }

    private Book createBook() {
        return new Book(UUID.randomUUID());
    }

    @Test
    public void constructor_withNullBaseCollection_shouldThrowIllegalArgumentException() {
        try {
            new InMemoryBookRepository(null);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("'baseCollection' can't be null"));
            return;
        }

        fail();
    }

    @Test
    public void add_always_shouldAddBookToBaseCollection() {
        Collection<Book> baseCollection = new HashSet<>();
        InMemoryBookRepository sut = createSystemUnderTest(baseCollection);
        Book expected = createBook();

        sut.add(null);

        assertThat(baseCollection, hasItem(expected));
    }

    @Test
    public void remove_always_shouldRemoveBookFromBaseCollection() {
        Book toRemove = createBook();
        Collection<Book> baseCollection = Sets.newHashSet(toRemove);
        InMemoryBookRepository sut = createSystemUnderTest(baseCollection);

        sut.remove(toRemove);

        assertThat(baseCollection, not(hasItem(toRemove)));
    }

    @Test
    public void getAll_always_shouldReturnBaseCollection() {
        Collection<Book> expected = Sets.newHashSet(createBook(), createBook());
        InMemoryBookRepository sut = createSystemUnderTest(expected);

        Iterable<Book> actual = sut.getAll();

        assertEquals(actual, expected);
    }
}
