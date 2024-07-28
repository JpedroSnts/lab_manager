package lab_manager.entites.reserva.ocorrencia;

import lab_manager.entites.reserva.EReservavel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoOcorrencia {
    private long codigo;
    private String nome;
    private EReservavel reservavel;
}
