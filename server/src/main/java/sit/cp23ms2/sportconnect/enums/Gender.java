package sit.cp23ms2.sportconnect.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Gender {
    Male,
    Female,
    Other,
    NotApplicable,
    Unknown;

    public static Gender fromInteger(int x) {
        return switch (x) {
            case 0 -> Male;
            case 1 -> Female;
            case 2 -> Other;
            case 3 -> NotApplicable;
            case 4 -> Unknown;
            default -> null;
        };
    }

    public static Integer fromEnum(Gender gender) {
        return switch (gender) {
            case Male -> 0;
            case Female -> 1;
            case Other -> 2;
            case NotApplicable -> 3;
            case Unknown -> 4;
        };
    }
}
