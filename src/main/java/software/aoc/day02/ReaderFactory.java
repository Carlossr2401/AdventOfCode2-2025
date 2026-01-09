package software.aoc.day02;

public class ReaderFactory {
    public static InstructionReader createReader(String filePath) {
        return new FileInstructionReader(filePath);
    }
}
