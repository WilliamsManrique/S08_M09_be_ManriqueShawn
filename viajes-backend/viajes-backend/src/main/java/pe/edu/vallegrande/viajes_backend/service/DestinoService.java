package pe.edu.vallegrande.viajes_backend.service;

import pe.edu.vallegrande.viajes_backend.model.Destino;
import java.util.List;
import java.util.Optional;

public interface DestinoService {
    List<Destino> listarTodos();
    Optional<Destino> obtenerPorId(Integer id);
    Destino guardar(Destino destino);
    Destino actualizar(Integer id, Destino destino);
    void eliminar(Integer id);
}