package practica.examen2.examen2.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import practica.examen2.examen2.modelos.Canciones;

public interface CancionesRepository extends JpaRepository<Canciones, Integer>{
    
}
