package software.aoc.day02.a;

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
        return divideValue(i);
    }

    private boolean divideValue(String i) {
        if (i.length() % 2 != 0) {
            return false;
        }

        int halfLength = i.length() / 2;

        String firstSubstring = i.substring(0, halfLength);
        String secondSustring = i.substring(halfLength);

        return  firstSubstring.equals(secondSustring);
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