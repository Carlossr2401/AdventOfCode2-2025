package software.aoc.day02.a;

import org.junit.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class SolverTest {

    @Test
    public void testSolveWithMixedRanges() throws IOException {
        InstructionReader mockReader = () -> List.of("10-15", "50-55");

        Solver solver = new Solver(mockReader);
        long result = solver.solve();

        assertEquals(66, result);
    }

    @Test
    public void testSolveAllInvalid() throws IOException {
        InstructionReader mockReader = () -> List.of("12-14");
        Solver solver = new Solver(mockReader);
        assertEquals(0, solver.solve());
    }
}
