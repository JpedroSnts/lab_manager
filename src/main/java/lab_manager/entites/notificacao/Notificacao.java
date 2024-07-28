package lab_manager.entites.notificacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notificacao {
    private long codigo;
    private String titulo;
    private String conteudo;
    private LocalDateTime data;
}
