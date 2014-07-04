package ru.pmsoft.jaxrssampleapp.domain;

import com.google.common.collect.ObjectArrays;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class BookTestCase {

    private Book createSystemUnderTest(UUID id) {
        return new Book(id == null ? UUID.randomUUID() : id);
    }

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

    @Test(dataProvider = "equalsTestData")
    public void equals_always_shouldReturnExpectedResult(Book sut, Object toCompare, boolean expected) {
        boolean actual = sut.equals(toCompare);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] equalsTestData() {
        Object[][] result = new Object[][]{
                new Object[]{createSystemUnderTest(null), null, false}
        };
        result = ObjectArrays.concat(result, hashCodeTestData(), Object[].class);
        return result;
    }

    @Test(dataProvider = "hashCodeTestData")
    public void hashCode_always_shouldReturnExpectedResult(Book sut, Object toCompare, boolean expected) {
        boolean actual = sut.hashCode() == toCompare.hashCode();
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] hashCodeTestData() {
        UUID id = UUID.randomUUID();

        return new Object[][]{
                new Object[]{
                        createSystemUnderTest(null),
                        new Object(),
                        false},
                new Object[]{
                        createSystemUnderTest(UUID.randomUUID()),
                        createSystemUnderTest(UUID.randomUUID()),
                        false},
                new Object[]{
                        createSystemUnderTest(id),
                        createSystemUnderTest(id),
                        true
                }
        };
    }
}
