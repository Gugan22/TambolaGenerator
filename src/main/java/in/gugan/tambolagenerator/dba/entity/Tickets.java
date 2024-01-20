package in.gugan.tambolagenerator.dba.entity;

import in.gugan.tambolagenerator.dba.convertor.IntArrayConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Convert(converter = IntArrayConverter.class)
    @Column(columnDefinition = "TEXT")
    private int[][] ticket;
}
