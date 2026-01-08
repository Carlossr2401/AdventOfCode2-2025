package software.aoc.day02.a;

import org.junit.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class SolverTest {

    @Test
    public void testSolveWithMixedRanges() throws IOException {
        // Mock InstructionReader using an anonymous class or lambda (if interface allows)
        InstructionReader mockReader = () -> List.of("10-15", "50-55");

        // Range 10-15: 10, 11, 12, 13, 14, 15
        // 10: invalid (10 != 10 reversed? No, split logic. '1' != '0') -> false
        // 11: valid (length 2, '1'=='1') -> true.
        // 12: false
        // 13: false
        // 14: false
        // 15: false
        // Total range 1: 11 has value 11. Sum = 11.

        // Range 50-55: 50, 51, 52, 53, 54, 55
        // 55 is valid. Sum = 55.

        // Total Expected Sum = 11 + 55 = 66.

        Solver solver = new Solver(mockReader);
        long result = solver.solve();

        assertEquals(66, result);
    }

    @Test
    public void testSolveAllInvalid() throws IOException {
        InstructionReader mockReader = () -> List.of("12-14"); // 12, 13, 14 -> all invalid for symmetry
        Solver solver = new Solver(mockReader);
        assertEquals(0, solver.solve());
    }
}
