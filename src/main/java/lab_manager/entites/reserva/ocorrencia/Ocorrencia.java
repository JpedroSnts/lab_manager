package lab_manager.entites.reserva.ocorrencia;

import lab_manager.entites.reserva.Reservavel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ocorrencia<T extends Reservavel> {
    private T item;
    private String descricao;
    private LocalDateTime data;
    private TipoOcorrencia tipoOcorrencia;
}
