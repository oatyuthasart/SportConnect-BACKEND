package sit.cp23ms2.sportconnect.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetail {
    private String field;
    private String errorMessage;
}
