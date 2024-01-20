package in.gugan.tambolagenerator.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private final String message;
    private final String cause;
    private final HttpStatusCode status;
}
