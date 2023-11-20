package practica.examen2.examen2.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practica.examen2.examen2.modelos.Artista;
import practica.examen2.examen2.modelos.AsociarArtistaCancion;
import practica.examen2.examen2.modelos.Canciones;
import practica.examen2.examen2.repositorios.ArtistaRepository;
import practica.examen2.examen2.repositorios.CancionesRepository;
import practica.examen2.examen2.servicios.CancionesService;

@Service
public class CancionesServiceImpl implements CancionesService{

    @Autowired
    private CancionesRepository cancionesRepository;

    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public List<Canciones> buscarCanciones(int codigoArtista) {
        return this.cancionesRepository.findAll();
    }

    @Override
    public String eliminarCancion(int codigoCancion) {
    Canciones cancion = this.cancionesRepository.findById(codigoCancion).get();
    if(cancion != null) {
        this.cancionesRepository.delete(cancion);
        return "Eliminado";
    }
    return "Cancion no encontrada";
    }

    @Override
    public String asociacion(AsociarArtistaCancion codigos) {
        Artista artista = this.artistaRepository.findById(codigos.getCodigoArtista()).get();

        if(artista != null){
            Canciones cancion = this.cancionesRepository.findById(codigos.getCodigoCancion()).get();
            if(cancion != null){
                if (cancion.getArtista().getCodigoArtista() == artista.getCodigoArtista()) {
                    return "La cancion pertenece al artista";
                }
            }
            
        }
        return "La cancion no pertenece al artista";
    }

    @Override
    public Artista obteneArtista(int codigoCancion) {
        Canciones cancion = this.cancionesRepository.findById(codigoCancion).get();

        if (cancion!= null) {
            return cancion.getArtista();
        }

        return null;
    }
    
}
