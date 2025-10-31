package utils;

import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@UtilityClass
public class RandomUtils {
    private final int ASCII_CAPITAL_LETTER_MIN = 65;
    private final int ASCII_CAPITAL_LETTER_MAX = 90;
    private final int ASCII_LOWER_LETTER_MIN = 97;
    private final int ASCII_LOWER_LETTER_MAX = 122;
    private final String SPECIAL_CHARACTERS = "%&$_-!^?";

    public int generateInt(int minInclusive, int maxExclusive) {
        return ThreadLocalRandom.current().nextInt(minInclusive, maxExclusive);
    }

    public char generateUpperChar() {
        return (char) generateInt(ASCII_CAPITAL_LETTER_MIN, ASCII_CAPITAL_LETTER_MAX + 1);
    }

    public char generateLowerChar() {
        return (char) generateInt(ASCII_LOWER_LETTER_MIN, ASCII_LOWER_LETTER_MAX + 1);
    }

    public char generateSpecialChar() {
        return SPECIAL_CHARACTERS.charAt(generateInt(0, SPECIAL_CHARACTERS.length()));
    }

    public String generateAlphabeticString(int length) {
        return ThreadLocalRandom
                .current()
                .ints(ASCII_CAPITAL_LETTER_MIN, ASCII_LOWER_LETTER_MAX + 1)
                .filter(i -> !(i < ASCII_LOWER_LETTER_MIN && i > ASCII_CAPITAL_LETTER_MAX))
                .limit(length)
                .mapToObj(i -> (char) i)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    public String generatePassword(int length) {
        if (length < 4) {
            throw new IllegalArgumentException("Password length should at least be 4");
        }
        StringBuilder output = new StringBuilder();

        output.append('0' + generateInt(0, 10));
        output.append(generateLowerChar());
        output.append(generateUpperChar());
        output.append(generateSpecialChar());

        if (output.length() < length) {
            output.append(generateAlphabeticString(length - output.length()));
        }

        return shuffleString(output.toString());
    }

    public String generateEmail(int localLength, int domainLength) {
        return "%s@%s.%s".formatted(generateAlphabeticString(localLength), generateAlphabeticString(domainLength),
                                    generateAlphabeticString(2).toLowerCase());
    }

    public String shuffleString(String input) {
        List<Character> characters = input
                .chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toList());
        Collections.shuffle(characters);
        StringBuilder output = new StringBuilder(input.length());
        characters.forEach(output::append);
        return output.toString();
    }
}
