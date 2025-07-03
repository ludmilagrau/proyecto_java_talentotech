package com.talentotech.ecommerce.controllers;

import com.talentotech.ecommerce.models.ArticuloModel;
import com.talentotech.ecommerce.services.ArticuloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    @Autowired
    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping
    public ArrayList<ArticuloModel> listarArticulos() {
        return articuloService.listarArticulos();
    }

    @PostMapping
    public ArticuloModel crearArticulo(@RequestBody ArticuloModel articulo) {
        return articuloService.crearArticulo(articulo);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ArticuloModel> buscarPorId(@PathVariable Long id) {
        return articuloService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ArticuloModel>> buscarPorNombre(@PathVariable String nombre) {

        if (articuloService.buscarPorNombre(nombre).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(articuloService.buscarPorNombre(nombre));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<ArticuloModel> actualizarArticulo(@PathVariable Long id,
            @RequestBody ArticuloModel articulo) {
        if (articuloService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(articuloService.actualizarArticulo(id, articulo));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (articuloService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        articuloService.eliminarArticulo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/precioasc")
    public List<ArticuloModel> buscarPorPrecioAsc() {
        return articuloService.buscarPorPrecioAsc();
    }

    @GetMapping("/contiene/{nombre}")
    public List<ArticuloModel> buscarPorContieneTexto(@PathVariable String nombre) {
        return articuloService.buscarPorContieneTexto(nombre);
    }

    @GetMapping("/mayora/{precio}")
    public List<ArticuloModel> buscarPorPrecioMayor(@PathVariable Double precio) {
        return articuloService.buscarPorPrecioMayor(precio);
    }
}
