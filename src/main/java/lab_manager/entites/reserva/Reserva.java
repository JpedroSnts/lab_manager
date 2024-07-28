package lab_manager.entites.reserva;

import lab_manager.entites.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reserva<T extends Reservavel> {
	private T item;
	private Usuario usuario;
}
