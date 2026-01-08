package software.aoc.day02.b;

import org.junit.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class SolverTest {

    @Test
    public void testSolveWithRepeatingPatterns() throws IOException {
        // Mock Reader
        InstructionReader mockReader = () -> List.of("1-10", "1210-1215");

        // Range 1-10:
        // 1-9: Invalid (length 1, repetition needs at least length * k? 
        // Wait, logic says: for sequenceLength 1 to N/2.
        // If N=1, loop doesn't run. Invalid.
        // 10: invalid.

        // Range 1210-1215:
        // 1210: inv
        // 1211: inv
        // 1212: valid (12 x 2) => sum += 1212
        // 1213: inv
        // 1214: inv
        // 1215: inv

        Solver solver = new Solver(mockReader);
        long result = solver.solve();

        assertEquals(1212, result);
    }
}
