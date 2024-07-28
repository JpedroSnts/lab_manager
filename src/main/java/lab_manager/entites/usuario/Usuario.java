package lab_manager.entites.usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	private long codigo;
	private String nome;
	private String email;
	private String senha;
	private String imagem;
	private TipoUsuario tipoUsuario;
}
