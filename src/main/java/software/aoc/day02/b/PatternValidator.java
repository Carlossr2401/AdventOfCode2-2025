package software.aoc.day02.b;

public class PatternValidator {

    public static boolean isRepeatingSequence(String numberAsString) {
        int length = numberAsString.length();

        for (int sequenceLength = 1; sequenceLength <= length / 2; sequenceLength++) {

            if (length % sequenceLength == 0) {

                String sequence = numberAsString.substring(0, sequenceLength);
                int repeatCount = length / sequenceLength;

                StringBuilder reconstructed = new StringBuilder();

                reconstructed.append(sequence.repeat(repeatCount));

                if (reconstructed.toString().equals(numberAsString)) {
                    return true;
                }
            }
        }

        return false;
    }
}