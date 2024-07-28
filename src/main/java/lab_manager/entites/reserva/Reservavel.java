package lab_manager.entites.reserva;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Reservavel {
	private long codigo;
	private String nome;
}
