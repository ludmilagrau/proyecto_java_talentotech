package com.talentotech.ecommerce.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentotech.ecommerce.models.PedidoModel;
import com.talentotech.ecommerce.repositories.IPedidoRepository;

@Service
public class PedidoService implements IPedidoService {
    private final IPedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(IPedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoModel crearPedido(PedidoModel pedido) {
        return pedidoRepository.save(pedido);
    }
}