package lab_manager.entites.equipamento;

import lab_manager.entites.reserva.Reservavel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipamento extends Reservavel {
	private Boolean danificado;
}
