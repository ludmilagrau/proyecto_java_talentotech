package com.talentotech.ecommerce.services;

import com.talentotech.ecommerce.models.ArticuloModel;
import com.talentotech.ecommerce.repositories.IArticuloRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloService implements IArticuloService {

    private final IArticuloRepository articuloRepository;

    @Autowired
        public ArticuloService(IArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public ArrayList<ArticuloModel> listarArticulos() {
        return (ArrayList<ArticuloModel>) articuloRepository.findAll();
    }

    public ArticuloModel crearArticulo(ArticuloModel articulo) {
        return (ArticuloModel) articuloRepository.save(articulo);
    }

    public Optional<ArticuloModel> buscarPorId(Long id) {
        return articuloRepository.findById(id);
    }

    public List<ArticuloModel> buscarPorNombre(String nombre) {
        return articuloRepository.findByNombreIgnoreCase(nombre);
    }

    public ArticuloModel actualizarArticulo(Long id, ArticuloModel articulo) {
        articulo.setId(id);
        return (ArticuloModel) articuloRepository.save(articulo);
    }

    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }

    public List<ArticuloModel> buscarPorPrecioAsc() {
        return articuloRepository.findAllByOrderByPrecioAsc();
    }

    public List<ArticuloModel> buscarPorContieneTexto(String nombre) {
        return articuloRepository.findByNombreContaining(nombre);
    }

    public List<ArticuloModel> buscarPorPrecioMayor(Double precio) {
        return articuloRepository.findByPrecioGreaterThan(precio);
    }
}
