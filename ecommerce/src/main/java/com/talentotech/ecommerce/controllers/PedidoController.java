package com.talentotech.ecommerce.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentotech.ecommerce.models.ArticuloModel;
import com.talentotech.ecommerce.models.PedidoModel;
import com.talentotech.ecommerce.services.ArticuloService;
import com.talentotech.ecommerce.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;
    private final ArticuloService articuloService;

    @Autowired
    public PedidoController(PedidoService pedidoService, ArticuloService articuloService) {
        this.pedidoService = pedidoService;
        this.articuloService = articuloService;
    }

@PostMapping
public ResponseEntity<PedidoModel> crearPedido(@RequestBody PedidoModel pedido) {

    List<ArticuloModel> articulosValidos = new ArrayList<>();

    for (ArticuloModel articulo : pedido.getArticulos()) {
        Long id = articulo.getId();

        Optional<ArticuloModel> articuloExistente = articuloService.buscarPorId(id);
        if (articuloExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        articulosValidos.add(articuloExistente.get());
    }

    pedido.setArticulos(articulosValidos);

    double total = articulosValidos.stream()
                    .mapToDouble(ArticuloModel::getPrecio)
                    .sum();
    pedido.setTotal(total);

    return ResponseEntity.ok(pedidoService.crearPedido(pedido));
}

}
