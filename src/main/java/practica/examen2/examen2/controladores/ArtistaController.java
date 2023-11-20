package practica.examen2.examen2.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import practica.examen2.examen2.modelos.Artista;
import practica.examen2.examen2.modelos.Direccion;
import practica.examen2.examen2.servicios.impl.ArtistaServiceImpl;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {
    
    @Autowired
    private ArtistaServiceImpl artistaServiceImpl;

    @GetMapping("/prueba")
    public String prueba(){
        return "Funciona";
    }

    @PostMapping("/guardar")
    public Artista crearArtista(@RequestBody Artista artista) {
        return this.artistaServiceImpl.crearArtista(artista);
    }

    @DeleteMapping("/eliminar")
    public String eliminarArtista(@RequestParam(name = "codigoArtista") int codigoArtista) {
        return this.artistaServiceImpl.eliminarArtista(codigoArtista);
    }

    @PutMapping("/actualizarDireccion")
    public String actualizarDireccion(@RequestParam(name = "codigoArtista") int codigoArtista,@RequestBody Direccion direccion) {
        return this.artistaServiceImpl.actualizarDireccion(codigoArtista, direccion);
    }

    @GetMapping("/buscar/{codigoArtista}")
    public Artista buscarArtista(@PathVariable(name = "codigoArtista") int codigoArtista) {
        return this.artistaServiceImpl.buscarArtista(codigoArtista);
    }

    @GetMapping("/obtenerTodos")
    public List<Artista> obtenerTodos() {
        return this.artistaServiceImpl.obtenerTodos();
    }
}
