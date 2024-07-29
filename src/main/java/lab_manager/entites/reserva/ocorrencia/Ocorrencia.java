package lab_manager.entites.reserva.ocorrencia;

import lab_manager.entites.reserva.Reservavel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class Ocorrencia<T extends Reservavel> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    private T item;
    private String descricao;
    private LocalDateTime data;
    @ManyToOne
    private TipoOcorrencia tipoOcorrencia;
}
