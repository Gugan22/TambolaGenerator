package in.gugan.tambolagenerator.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@Getter
@Setter
public class SystemException extends Exception {
    private final String message;
    private final String errorCause;
    private final HttpStatusCode status;
}
