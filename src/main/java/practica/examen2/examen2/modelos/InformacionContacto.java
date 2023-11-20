package practica.examen2.examen2.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "informacioncontacto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformacionContacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigocontacto")
    private int codigoContacto;

    private String pais;

    private String ciudad;

    private String telefono;

    private String correo;

    @JsonIgnore
    @OneToOne(mappedBy = "informacionContacto")
    private Artista artista;

}
