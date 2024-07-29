package lab_manager.entites.ambiente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class GradeHorarioKey implements Serializable {
    @Column(name = "dia_semana_codigo")
    private long diaSemanaCodigo;
    @Column(name = "ambiente_codigo")
    private long ambienteCodigo;
    @Column(name = "hr_inicio")
    private LocalTime inicio;
    @Column(name = "hr_fim")
    private LocalTime fim;
}
