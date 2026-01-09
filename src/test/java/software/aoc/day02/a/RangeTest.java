package software.aoc.day02.a;

import org.junit.Test;
import software.aoc.day02.Range;

import static org.junit.Assert.assertEquals;

public class RangeTest {

    @Test
    public void testFromString() {
        Range range = Range.fromString("10-20");
        assertEquals(10, range.start());
        assertEquals(20, range.end());
    }

    @Test
    public void testFromStringLargeNumbers() {
        Range range = Range.fromString("1000-2000");
        assertEquals(1000, range.start());
        assertEquals(2000, range.end());
    }
}
