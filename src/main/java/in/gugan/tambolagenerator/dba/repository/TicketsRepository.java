package in.gugan.tambolagenerator.dba.repository;

import in.gugan.tambolagenerator.dba.entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {
}
