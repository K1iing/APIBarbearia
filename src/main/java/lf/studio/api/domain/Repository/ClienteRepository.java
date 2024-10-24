package lf.studio.api.domain.Repository;

import lf.studio.api.domain.model.cliente.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Page<ClienteEntity> findAllByAtivoTrue(Pageable paginacao);
}
