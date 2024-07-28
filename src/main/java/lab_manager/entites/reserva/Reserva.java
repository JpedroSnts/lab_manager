package lab_manager.entites.reserva;

import lab_manager.entites.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reserva<T extends Reservavel> {
	private T item;
	private Usuario usuario;
	private LocalDateTime saidaPrevista;
	private LocalDateTime devolucaoPrevista;
	private LocalDateTime saida;
	private LocalDateTime devolucao;
	private LocalDateTime cancelamento;
	private EReservavel reservavel;
}
