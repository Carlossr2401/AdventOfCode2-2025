package software.aoc.day02.b;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Solver {

    private final InstructionReader reader;

    public Solver(InstructionReader reader) {
        this.reader = reader;
    }


    public long solve() throws IOException {
        List<String> lista = reader.readAllInstructions();
        IdValidator validator = new PatternValidator();
        AtomicLong addition = new AtomicLong(0);

        lista.forEach(line -> {
            Range range = Range.fromString(line);
            long invalidCount = java.util.stream.LongStream.rangeClosed(range.start(), range.end())
                    .filter(validator::isValid)
                    .sum();
            addition.addAndGet(invalidCount);
        });

        return addition.get();
    }

}
