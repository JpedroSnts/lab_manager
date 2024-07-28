package lab_manager.entites.ambiente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GradeHorario {
    private Ambiente ambiente;
    private DiaSemana diaSemana;
    private LocalTime inicio;
    private LocalTime fim;
}
