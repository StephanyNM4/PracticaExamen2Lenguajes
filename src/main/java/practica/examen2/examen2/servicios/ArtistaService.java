package practica.examen2.examen2.servicios;

import java.util.List;

import practica.examen2.examen2.modelos.Artista;
import practica.examen2.examen2.modelos.Direccion;

public interface ArtistaService {
    

    public Artista crearArtista(Artista artista);

    public String eliminarArtista(int codigoArtista);

    public String actualizarDireccion(int codigoArtista, Direccion direccion);

    public Artista buscarArtista(int codigoArtista);

    public List<Artista> obtenerTodos();

}

