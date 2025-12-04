package software.aoc.day02.a;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

    static void main(String[] args) throws IOException {

        FileInstructionReader reader = new FileInstructionReader("src/main/resources/ranges");
        ArrayList<String> lista = reader.readAllInstructions();

        AtomicLong addition = new AtomicLong(0);

        lista.forEach(range -> {
            long sumOfRange = sumList(new Range(range).checkInvalidIds());
            addition.addAndGet(sumOfRange);
        });

        System.out.println("Suma total de IDs inválidos: " + addition.get());
    }

    private static long sumList(ArrayList<Long> numbers) {
        return numbers.stream().mapToLong(Long::longValue).sum();
    }
}