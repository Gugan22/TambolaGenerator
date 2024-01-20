package in.gugan.tambolagenerator.web;

import in.gugan.tambolagenerator.dto.response.TicketSetsResponse;
import in.gugan.tambolagenerator.dto.response.TicketSetsResponsePaged;
import in.gugan.tambolagenerator.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tambola-ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/{numberOfSets}")
    public ResponseEntity<TicketSetsResponse> createTicketSets(@PathVariable int numberOfSets) {
        return ResponseEntity.ok(ticketService.createTicketSets(numberOfSets));
    }

    @GetMapping("")
    public ResponseEntity<TicketSetsResponsePaged> ticketsPaged(@RequestParam(required = false, defaultValue = "0") int pageNumber, @RequestParam(required = false, defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(ticketService.getTicketsPaged(pageNumber, pageSize));
    }
}
