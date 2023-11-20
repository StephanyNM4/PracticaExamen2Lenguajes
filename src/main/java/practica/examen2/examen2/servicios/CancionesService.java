package practica.examen2.examen2.servicios;

import java.util.List;

import practica.examen2.examen2.modelos.Artista;
import practica.examen2.examen2.modelos.AsociarArtistaCancion;
import practica.examen2.examen2.modelos.Canciones;

public interface CancionesService {
    
    public List<Canciones> buscarCanciones(int codigoArtista);

    public String eliminarCancion(int codigoCancion);

    public String asociacion(AsociarArtistaCancion codigos);

    public Artista obteneArtista(int codigoCancion);


}
