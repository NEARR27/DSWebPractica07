
package ventas.clases;

import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author near
 */
@Entity
@Table(name ="cliente")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(generator = "cliente_idcliente_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "cliente_idcliente_seq",sequenceName = "cliente_idcliente_seq",
            initialValue = 1,allocationSize = 1)
    @Column(name = "idcliente")
    private int idCliente;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "rfc")
    private String rfc;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cli")
    private List<Venta> ventas;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}

