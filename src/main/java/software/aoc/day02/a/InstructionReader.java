package software.aoc.day02.a;

import java.io.IOException;
import java.util.List;

public interface InstructionReader {
    List<String> readAllInstructions() throws IOException;
}
