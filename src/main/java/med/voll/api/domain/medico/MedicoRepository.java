package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query(value = """
            select * from medicos m
             where
                m.ativo = 1
             and
                m.especialidade
             and
                m.id not in(
                    select c.medico_id from consultas c
                     where
                        c.data
            )
            order by rand()
            limit 1
            """, nativeQuery = true)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);

    @Query(value = """
            select m.ativo
              from medicos m
             where
               m.id = :id
            """, nativeQuery = true)
    Boolean findAtivoById(Long id);
}
