package pe.edu.vallegrande.viajes_backend.controller;

import pe.edu.vallegrande.viajes_backend.model.Destino;
import pe.edu.vallegrande.viajes_backend.service.DestinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    @Autowired
    private DestinoService service;

    @GetMapping
    public ResponseEntity<List<Destino>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Destino> crear(@Valid @RequestBody Destino destino) {
        Destino nuevo = service.guardar(destino);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destino> actualizar(@PathVariable Integer id, @Valid @RequestBody Destino destino) {
        try {
            Destino actualizado = service.actualizar(id, destino);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}