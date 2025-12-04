package software.aoc.day02.b;

import java.util.ArrayList;

public record Range(String range) {

    public ArrayList<Long> checkInvalidIds() {
        ArrayList<Long> invalidIds =  new ArrayList<>();

        for (long i = getStart(); i <= getEnd(); i++) {
            if (checkSymetry(String.valueOf(i))) {
                invalidIds.add(i);
            }
        }
        return invalidIds;
    }

    private Boolean checkSymetry(String i) {
        return PatternValidator.isRepeatingSequence(i);
    }

    private String[] getRangeLimits() {
        return range.split("-");
    }

    public long getStart() {
        return Long.parseLong(getRangeLimits()[0]);
    }

    public long getEnd() {
        return Long.parseLong(getRangeLimits()[1]);
    }
}