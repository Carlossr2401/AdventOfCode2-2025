package software.aoc.day02.b;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class PatternValidatorTest {

    private final PatternValidator validator = new PatternValidator();

    @Test
    public void testRepeatingTwice() {
        // Same as symmetric (if < N/2 length pattern)
        assertTrue("1212 should be valid (12 x 2)", validator.isValid(1212));
    }

    @Test
    public void testRepeatingThrice() {
        assertTrue("123123123 should be valid (123 x 3)", validator.isValid(123123123L));
    }

    @Test
    public void testRepeatingSingleDigit() {
        assertTrue("111 should be valid (1 x 3)", validator.isValid(111));
        assertTrue("55555 should be valid (5 x 5)", validator.isValid(55555));
    }

    @Test
    public void testNoPattern() {
        assertFalse("1234 should be invalid", validator.isValid(1234));
        assertFalse("1213 should be invalid", validator.isValid(1213));
    }

    @Test
    public void testPrimeLengthNoRepetition() {
        // 7 digits, no repeating pattern unless it's 1 digit repeated 7 times
        assertFalse("1234567 should be invalid", validator.isValid(1234567));
    }
}
