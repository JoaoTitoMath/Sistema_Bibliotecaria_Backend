package com.sistema.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.biblioteca.entity.Proveedor;

import java.util.HashMap;
import java.util.List;
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

	public List<Proveedor> ListFiltroproveedorJpaGetData(HashMap<String, Object> conditions);
}
