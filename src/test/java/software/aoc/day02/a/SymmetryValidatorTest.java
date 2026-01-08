package software.aoc.day02.a;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SymmetryValidatorTest {

    private final SymmetryValidator validator = new SymmetryValidator();

    @Test
    public void testValidSymmetricIds() {
        assertTrue("55 should be valid", validator.isValid(55));
        assertTrue("6464 should be valid", validator.isValid(6464));
        assertTrue("123123 should be valid", validator.isValid(123123));
    }

    @Test
    public void testInvalidIdsOddLength() {
        assertFalse("101 should be invalid (odd length)", validator.isValid(101));
        assertFalse("1 should be invalid (odd length)", validator.isValid(1));
        assertFalse("12345 should be invalid (odd length)", validator.isValid(12345));
    }

    @Test
    public void testInvalidIdsNotSymmetric() {
        assertFalse("1234 should be invalid (not symmetric)", validator.isValid(1234));
        assertFalse("1020 should be invalid (not symmetric)", validator.isValid(1020));
        assertFalse("1122 should be invalid (not symmetric)", validator.isValid(1122));
    }
}
