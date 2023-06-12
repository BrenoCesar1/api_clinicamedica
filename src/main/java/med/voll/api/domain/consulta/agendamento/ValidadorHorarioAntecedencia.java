package med.voll.api.domain.consulta.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferençaEmMinutos = Duration.between(agora,dataConsulta).toMinutes();

        if (diferençaEmMinutos < 30){
            throw new ValidacaoException("Consulta deve se agendada com antecedência minima de 30 minutos");
        }
    }
}
