package sit.cp23ms2.sportconnect.enums;

import lombok.Getter;

@Getter
public enum Gender {
    NotKnown,
    Male,
    Female,
    NotApplicable;

    public static Gender fromInteger(int x) {
        switch(x) {
            case 0:
                return NotKnown;
            case 1:
                return Male;
            case 2:
                return Female;
            case 9:
                return NotApplicable;
        }
        return null;
    }

    public static Integer fromEnum(Gender gender) {
        switch(gender) {
            case NotKnown:
                return 0;
            case Male:
                return 1;
            case Female:
                return 2;
            case NotApplicable:
                return 9;
        }
        return null;
    }
}
