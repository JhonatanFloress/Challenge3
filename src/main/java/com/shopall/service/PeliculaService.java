package com.shopall.service;

import com.shopall.model.Pelicula;
import com.shopall.repository.PeliculaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> obtenerTodas() {
        return peliculaRepository.findAll();
    }

    public List<Pelicula> obtenerDisponibles() {
        return peliculaRepository.findByDisponible(true);
    }

    public List<Pelicula> obtenerNoDisponibles() {
        return peliculaRepository.findByDisponible(false);
    }

    public Pelicula agregar(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public void eliminar(int id) {
        peliculaRepository.deleteById(id);
    }

    public Pelicula marcarComoDisponible(int id) {
        Optional<Pelicula> optional = peliculaRepository.findById(id);
        if (optional.isPresent()) {
            Pelicula pelicula = optional.get();
            pelicula.setDisponible(true);
            return peliculaRepository.save(pelicula);
        }
        return null;
    }
}