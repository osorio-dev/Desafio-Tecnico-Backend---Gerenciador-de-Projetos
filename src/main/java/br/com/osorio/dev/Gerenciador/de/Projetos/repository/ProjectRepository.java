package br.com.osorio.dev.Gerenciador.de.Projetos.repository;

import br.com.osorio.dev.Gerenciador.de.Projetos.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
