package lab_manager.entites.notificacao;

import lab_manager.entites.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificacaoUsuario {
    private Notificacao notificacao;
    private Usuario usuario;
    private Boolean lida;
}
