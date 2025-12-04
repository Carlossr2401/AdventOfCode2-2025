import org.junit.Test;
import software.aoc.day02.a.Range;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Day02ATest {

    private ArrayList<String> createRanges(String... ranges) {
        return new ArrayList<>(List.of(ranges));
    }

    @Test
    public void testStartValue() {
        ArrayList<String> ranges = createRanges("110-120");
        Range range = new Range(ranges.getFirst());

        assertEquals(110, range.getStart());
    }

    @Test
    public void testEndValue() {
        ArrayList<String> ranges = createRanges("110-120");
        Range range = new Range(ranges.getFirst());

        assertEquals(120, range.getEnd());
    }

    @Test
    public void checkInvalidIds() {
        ArrayList<String> ranges = createRanges("11-22");
        Range range = new Range(ranges.getFirst());

        ArrayList<Integer> expectedInvalidIds = new ArrayList<>(List.of(
                11, 22
        ));

        assertEquals(expectedInvalidIds, range.checkInvalidIds());
    }
}