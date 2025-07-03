package com.talentotech.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.talentotech.ecommerce.models.ArticuloModel;

@Repository
public interface IArticuloRepository extends JpaRepository<ArticuloModel, Long> {

    // Buscar artículos cuyo nombre contenga una palabra (LIKE '%texto%')
    List<ArticuloModel> findByNombreContaining(String texto);

    // Buscar artículos con precio mayor a un valor dado
    List<ArticuloModel> findByPrecioGreaterThan(Double precio);

    // Buscar por nombre ignorando mayúsculas y minúsculas
    List<ArticuloModel> findByNombreIgnoreCase(String nombre);

    // Buscar artículos ordenados por precio ascendente
    List<ArticuloModel> findAllByOrderByPrecioAsc();
}
