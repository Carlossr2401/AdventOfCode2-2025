package software.aoc.day02.b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public record FileInstructionReader(String filePath) implements InstructionReader {

    public ArrayList<String> readAllInstructions() throws IOException {
        ArrayList<String> instructions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                instructions.addAll(parseLine(line));
            }
        }

        return instructions;
    }

    private ArrayList<String> parseLine(String line) {
        ArrayList<String> values = new ArrayList<>();
        String trimmedLine = line.trim();

        if (trimmedLine.isEmpty()) {
            return values;
        }

        String[] parts = trimmedLine.split(",");

        for (String part : parts) {
            values.add(part.trim());
        }

        return values;
    }
}