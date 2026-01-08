package software.aoc.day02.b;

import org.junit.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class SolverTest {

    @Test
    public void testSolveWithRepeatingPatterns() throws IOException {
        InstructionReader mockReader = () -> List.of("1-10", "1210-1215");

        Solver solver = new Solver(mockReader);
        long result = solver.solve();

        assertEquals(1212, result);
    }
}
