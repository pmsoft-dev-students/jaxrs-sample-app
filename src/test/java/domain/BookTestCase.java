package domain;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.fail;

public class BookTestCase {

    @Test
    public void constructor_withNullId_shouldThrowIllegalArgumentException() {
        try {
            new Book(null);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("'id' can't be null"));
            return;
        }

        fail();
    }
}
