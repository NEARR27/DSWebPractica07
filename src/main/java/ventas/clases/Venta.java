/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventas.clases;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author near
 */
@Entity
@Table(name = "venta")
public class Venta implements Serializable {
    
   
    @Id
    @GeneratedValue(generator = "venta_idventa_seq",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "venta_idventa_seq",sequenceName = "venta_idventa_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "idventa")
    private int idVenta;
    
    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "total")
    private BigDecimal total;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcliente",referencedColumnName = "idcliente")
    //@Column(name = "idcliente")
    private Cliente cli;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "venta")
    private List<VentaDetalle> ventaDetalles= new ArrayList<>();

    public List<VentaDetalle> getVentaDetalles() {
        return ventaDetalles;
    }

    public void setVentaDetalles(List<VentaDetalle> ventaDetalles) {
        this.ventaDetalles = ventaDetalles;
    }
    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }
}
