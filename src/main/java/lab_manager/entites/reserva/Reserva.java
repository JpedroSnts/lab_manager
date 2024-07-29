package lab_manager.entites.reserva;

import lab_manager.entites.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Reserva<T extends Reservavel> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@ManyToOne
	private T item;
	@ManyToOne
	private Usuario usuario;
	private LocalDateTime saidaPrevista;
	private LocalDateTime devolucaoPrevista;
	private LocalDateTime saida;
	private LocalDateTime devolucao;
	private LocalDateTime cancelamento;
	private EReservavel reservavel;
}
