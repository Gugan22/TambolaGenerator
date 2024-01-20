package in.gugan.tambolagenerator.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class TicketSetsResponse {
    private Map<Long, int[][]> tickets;
}
