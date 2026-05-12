package pe.edu.vallegrande.viajes_backend.service.impl;

import pe.edu.vallegrande.viajes_backend.model.Destino;
import pe.edu.vallegrande.viajes_backend.repository.DestinoRepository;
import pe.edu.vallegrande.viajes_backend.service.DestinoService; // ← import correcto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DestinoServiceImpl implements DestinoService { // ← implementa la interfaz

    @Autowired
    private DestinoRepository destinoRepository;

    @Override
    public List<Destino> listarTodos() {
        return destinoRepository.findAll();
    }

    @Override
    public Optional<Destino> obtenerPorId(Integer id) {
        return destinoRepository.findById(id);
    }

    @Override
    public Destino guardar(Destino destino) {
        return destinoRepository.save(destino);
    }

    @Override
    @Transactional
    public Destino actualizar(Integer id, Destino destino) {
        return destinoRepository.findById(id)
                .map(existente -> {
                    existente.setNombre(destino.getNombre());
                    existente.setDescripcion(destino.getDescripcion());
                    existente.setPrecio(destino.getPrecio());
                    existente.setImagenUrl(destino.getImagenUrl());
                    return destinoRepository.save(existente);
                })
                .orElseThrow(() -> new RuntimeException("Destino no encontrado con id: " + id));
    }

    @Override
    public void eliminar(Integer id) {
        destinoRepository.deleteById(id);
    }
}