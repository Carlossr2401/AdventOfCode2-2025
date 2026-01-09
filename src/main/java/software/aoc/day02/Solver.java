package software.aoc.day02;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Solver {

    protected final InstructionReader reader;
    protected final IdValidator validator;

    public Solver(InstructionReader reader, IdValidator validator) {
        this.reader = reader;
        this.validator = validator;
    }

    public long solve() throws IOException {
        List<String> lista = reader.readAllInstructions();
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
