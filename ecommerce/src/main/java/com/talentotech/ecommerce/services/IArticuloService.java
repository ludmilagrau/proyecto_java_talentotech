package com.talentotech.ecommerce.services;

import java.util.List;
import java.util.Optional;

import com.talentotech.ecommerce.models.ArticuloModel;

public interface IArticuloService {
    List<ArticuloModel> listarArticulos();

    Optional<ArticuloModel> buscarPorId(Long id);

    ArticuloModel crearArticulo(ArticuloModel articulo);

    ArticuloModel actualizarArticulo(Long id, ArticuloModel articulo);

    void eliminarArticulo(Long id);

    List<ArticuloModel> buscarPorNombre(String nombre);
}