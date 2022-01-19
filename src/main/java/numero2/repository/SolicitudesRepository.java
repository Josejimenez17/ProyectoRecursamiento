package numero2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import numero2.model.Solicitud;

public interface SolicitudesRepository extends JpaRepository<Solicitud, Integer> {

}
