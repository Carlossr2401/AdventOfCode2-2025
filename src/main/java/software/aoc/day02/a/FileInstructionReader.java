package software.aoc.day02.a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public record FileInstructionReader(String filePath) implements InstructionReader {

    @Override
    public List<String> readAllInstructions() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()              // Flujo de líneas (Java 8+)
                         .flatMap(line -> parseLine(line).stream()) 
                         .toList();
        }
    }

    // Este método es el candidato a SRP. 
    // Podría incluso estar en una clase "InstructionParser" si el parseo fuera complejo.
    private List<String> parseLine(String line) {
        if (line == null || line.isBlank()) return List.of();
        
        return Arrays.stream(line.split(","))
                     .map(String::trim)
                     .filter(s -> !s.isEmpty())
                     .toList();
    }
}