package pe.edu.vallegrande.viajes_backend.repository;

import pe.edu.vallegrande.viajes_backend.model.Destino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Integer> {
}