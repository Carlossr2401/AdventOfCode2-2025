package software.aoc.day02;

import software.aoc.day02.a.SolverA;
import software.aoc.day02.a.SymmetryValidator;
import software.aoc.day02.b.PatternValidator;
import software.aoc.day02.b.SolverB;

public class SolverFactory {
    
    public enum SolverType {
        PART_A,
        PART_B
    }

    public static Solver createSolver(SolverType type, String filePath) {
        InstructionReader reader = ReaderFactory.createReader(filePath);
        
        switch (type) {
            case PART_A:
                return new SolverA(reader, new SymmetryValidator());
            case PART_B:
                return new SolverB(reader, new PatternValidator());
            default:
                throw new IllegalArgumentException("Unknown solver type: " + type);
        }
    }
}
