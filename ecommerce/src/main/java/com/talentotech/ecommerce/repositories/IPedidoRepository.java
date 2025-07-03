package com.talentotech.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talentotech.ecommerce.models.PedidoModel;

public interface IPedidoRepository extends JpaRepository<PedidoModel, Long> {

}
