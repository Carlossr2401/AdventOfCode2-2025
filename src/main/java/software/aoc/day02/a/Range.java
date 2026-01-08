package software.aoc.day02.a;


public record Range(long start, long end) {

    public static Range fromString(String range) {
        String[] parts = range.split("-");
        return new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
    }
}
