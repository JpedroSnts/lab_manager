package lab_manager.entites.notificacao;

import lab_manager.entites.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class NotificacaoUsuarioKey implements Serializable {
    @Column(name = "usuario_codigo")
    private long usuarioCodigo;
    @Column(name = "notificacao_codigo")
    private long notificacaoCodigo;
}
