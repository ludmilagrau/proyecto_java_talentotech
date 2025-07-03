package com.talentotech.ecommerce.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Pedidos")

public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nroPedido;

    private String emailCliente;
    private Long dniCliente;
    private Double total;
    private String fechaPedido;
    @ManyToMany
    private List<ArticuloModel> articulos;

    public PedidoModel() {
    }

    public PedidoModel(long nroPedido, String emailCliente, Long dniCliente, double total, String fechaPedido,
            List<ArticuloModel> articulos) {
        this.nroPedido = nroPedido;
        this.emailCliente = emailCliente;
        this.dniCliente = dniCliente;
        this.total = total;
        this.fechaPedido = fechaPedido;
        this.articulos = articulos;

    }
    public long getNroPedido() {
        return nroPedido;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public Long getdniCliente() {
        return dniCliente;
    }

    public Double getTotal() {
        return total;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public List<ArticuloModel> getArticulos() {
        return articulos;
    }

    public void setNroPedido(Long nroPedido) {
        this.nroPedido = nroPedido;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public void setDniCliente(Long dniCliente) {
        this.dniCliente = dniCliente;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setArticulos(List<ArticuloModel> articulos) {
        this.articulos = articulos;
    }
}
