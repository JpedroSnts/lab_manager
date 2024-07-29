package lab_manager.entites.notificacao;

import lab_manager.entites.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NotificacaoUsuario {
    @EmbeddedId
    private NotificacaoUsuarioKey id;

    @ManyToOne
    @MapsId("notificacaoCodigo")
    @JoinColumn(name = "notificacao_codigo")
    private Notificacao notificacao;
    @ManyToOne
    @MapsId("usuarioCodigo")
    @JoinColumn(name = "usuario_codigo")
    private Usuario usuario;
    private Boolean lida;
}
