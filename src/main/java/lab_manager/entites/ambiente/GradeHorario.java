package lab_manager.entites.ambiente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GradeHorario {
    @EmbeddedId
    private GradeHorarioKey id;

    @ManyToOne
    @MapsId("ambienteCodigo")
    @JoinColumn(name = "ambiente_codigo")
    private Ambiente ambiente;

    @ManyToOne
    @MapsId("diaSemanaCodigo")
    @JoinColumn(name = "dia_semana_codigo")
    private DiaSemana diaSemana;
}
