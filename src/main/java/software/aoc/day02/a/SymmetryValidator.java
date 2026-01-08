package software.aoc.day02.a;

public class SymmetryValidator implements IdValidator {

    @Override
    public boolean isValid(long id) {
        String s = String.valueOf(id);
        if (s.length() % 2 != 0) {
            return false;
        }

        int halfLength = s.length() / 2;
        String firstSubstring = s.substring(0, halfLength);
        String secondSubstring = s.substring(halfLength);

        return firstSubstring.equals(secondSubstring);
    }
}
