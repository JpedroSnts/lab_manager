package lab_manager.entites.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
	@Id
	private long codigo;
	private String nome;
	private String email;
	private String senha;
	private String imagem;
	@ManyToOne
	private TipoUsuario tipoUsuario;
}
