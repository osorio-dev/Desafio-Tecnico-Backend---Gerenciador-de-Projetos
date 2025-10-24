package br.com.osorio.dev.Gerenciador.de.Projetos.repository;

import br.com.osorio.dev.Gerenciador.de.Projetos.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
}
