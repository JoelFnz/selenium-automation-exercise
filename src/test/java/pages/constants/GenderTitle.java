package pages.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderTitle {
    MALE("Mrs"),
    FEMALE("Ms");

    private final String value;
}
