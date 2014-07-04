package ru.pmsoft.jaxrssampleapp.rest;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.fail;

public class BooksResourceTestCase {

    @Test
    public void constructor_withNullBaseCollection_shouldThrowIllegalArgumentException() {
        try {
            new BooksResource(null);
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("'repository' can't be null"));
            return;
        }

        fail();
    }
}
