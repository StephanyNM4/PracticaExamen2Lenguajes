package practica.examen2.examen2.modelos;

import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "artista")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Artista {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigoartista")
    private int codigoArtista;

    @Column(name = "nombreartistico")
    private String nombreArtistico;

    private String nombre;

    private String apellido;

    @Column(name = "fechanacimiento")
    private Date fechaNacimiento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codigocontacto", referencedColumnName = "codigocontacto")
    private InformacionContacto informacionContacto;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Canciones> canciones;
}
