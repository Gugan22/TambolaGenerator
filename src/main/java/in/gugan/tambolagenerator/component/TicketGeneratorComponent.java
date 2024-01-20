package in.gugan.tambolagenerator.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class TicketGeneratorComponent {

    @Value("${tickets.row}")
    private Integer ROWS;

    @Value("${tickets.column}")
    private Integer COLUMNS;

    @Value("${tickets.max_number}")
    private Integer MAX_NUMBER;

    @Value("${tickets.tickets_per_set}")
    private Integer TICKETS_PER_SET;

    private static final Random random = new Random();

    /**
     * Generate n ticketSets with conditions applied
     **/
    public List<int[][]> generateTickets(int numberOfSets) {
        List<int[][]> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfSets; i++)
            tickets.addAll(Arrays.stream(generateTicketSet()).toList());
        return tickets;
    }

    /**
     * Generate Tickets with conditions applied
     **/
    public int[][][] generateTicketSet() {
        int[][][] tickets = new int[TICKETS_PER_SET][ROWS][COLUMNS];
        for (int i = 0; i < 90; i++)
            tickets[random.nextInt(0, TICKETS_PER_SET)][random.nextInt(0, ROWS)][i / 10] = i;
        return tickets;
    }

}
