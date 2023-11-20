package practica.examen2.examen2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import practica.examen2.examen2.modelos.Artista;
import practica.examen2.examen2.modelos.AsociarArtistaCancion;
import practica.examen2.examen2.modelos.Canciones;
import practica.examen2.examen2.servicios.impl.CancionesServiceImpl;

@RestController
@RequestMapping("/api/canciones")
public class CancionesController {
    
    @Autowired
    private CancionesServiceImpl cancionesServiceImpl;

    @GetMapping("/prueba")
    public String prueba(){
        return "Funciona";
    }

    @GetMapping("/obtenerTodas")
    public List<Canciones> buscarCanciones(@RequestParam(name = "codigoArtista") int codigoArtista) {
        return this.cancionesServiceImpl.buscarCanciones(codigoArtista);
    }

    @DeleteMapping("/eliminar")
    public String eliminarCancion(@RequestParam(name = "codigoCancion") int codigoCancion) {
        return this.cancionesServiceImpl.eliminarCancion(codigoCancion);
    }

    @GetMapping("/asociar")
    public String asociacion(@RequestBody AsociarArtistaCancion codigos) {
        return this.cancionesServiceImpl.asociacion(codigos);
    }

    @GetMapping("/obtenerArtista")
    public Artista obteneArtista(@RequestParam(name = "codigoCancion") int codigoCancion) {
        return this.cancionesServiceImpl.obteneArtista(codigoCancion);
    }
}
