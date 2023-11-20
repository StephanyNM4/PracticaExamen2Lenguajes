package practica.examen2.examen2.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practica.examen2.examen2.modelos.Artista;
import practica.examen2.examen2.modelos.Canciones;
import practica.examen2.examen2.modelos.Direccion;
import practica.examen2.examen2.repositorios.ArtistaRepository;
import practica.examen2.examen2.servicios.ArtistaService;

@Service
public class ArtistaServiceImpl implements ArtistaService{

    @Autowired
    private ArtistaRepository artistaRepository;

    @Override
    public Artista crearArtista(Artista artista) {
        if(artista.getInformacionContacto() != null){
            artista.getInformacionContacto().setArtista(artista);
        }

        if(artista.getCanciones() != null){
            for (Canciones cancion : artista.getCanciones()) {
                cancion.setArtista(artista);
            }
        }

        return this.artistaRepository.save(artista);
    }

    @Override
    public String eliminarArtista(int codigoArtista) {
        Artista artista = this.artistaRepository.findById(codigoArtista).get();

        if(artista != null){
            this.artistaRepository.delete(artista);
            return "Artista eliminado";
        }

        return "Artista no existe";
    }

    @Override
    public String actualizarDireccion(int codigoArtista, Direccion direccion) {
        Artista artista = this.artistaRepository.findById(codigoArtista).get();

        if (artista != null) {
            artista.getInformacionContacto().setPais(direccion.getPais());
            artista.getInformacionContacto().setCiudad(direccion.getCiudad());
            return "Direccion actualizada";
        }

        return "Artista no existe";
    }

    @Override
    public Artista buscarArtista(int codigoArtista) {
        return this.artistaRepository.findById(codigoArtista).get();
    }

    @Override
    public List<Artista> obtenerTodos() {
        return this.artistaRepository.findAll();
    }
    
}
