package in.gugan.tambolagenerator.service;

import in.gugan.tambolagenerator.component.TicketGeneratorComponent;
import in.gugan.tambolagenerator.dba.entity.Tickets;
import in.gugan.tambolagenerator.dba.repository.TicketsRepository;
import in.gugan.tambolagenerator.dto.response.TicketSetsResponse;
import in.gugan.tambolagenerator.dto.response.TicketSetsResponsePaged;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketGeneratorComponent ticketGeneratorComponent;
    private final TicketsRepository ticketsRepository;

    public TicketSetsResponse createTicketSets(int numberOfSets) {
        List<Tickets> tickets = ticketsRepository.saveAll(
                ticketGeneratorComponent.generateTickets(numberOfSets).stream()
                        .map(it -> new Tickets(null, it)).toList()
        );
        return TicketSetsResponse.builder()
                .tickets(tickets.stream().collect(Collectors.toMap(Tickets::getId, Tickets::getTicket, (k, v) -> v, LinkedHashMap::new)))
                .build();
    }

    public TicketSetsResponsePaged getTicketsPaged(int pageNumber, int pageSize) {
        Page<Tickets> ticketsPage = ticketsRepository.findAll(PageRequest.of(pageNumber, pageSize));
        return TicketSetsResponsePaged.builder()
                .tickets(ticketsPage.stream().collect(Collectors.toMap(Tickets::getId, Tickets::getTicket, (k, v) -> v, LinkedHashMap::new)))
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .totalPages(ticketsPage.getTotalPages())
                .numberOfItems(ticketsPage.getNumberOfElements())
                .build();

    }

}
