package in.gugan.tambolagenerator.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class TicketSetsResponsePaged {
    private Map<Long, int[][]> tickets;
    int pageSize;
    int pageNumber;
    int totalPages;
    int numberOfItems;
}
