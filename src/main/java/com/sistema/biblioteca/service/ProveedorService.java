package com.sistema.biblioteca.service;

import java.util.List;

import com.sistema.biblioteca.entity.Proveedor;

public interface ProveedorService {

	public Proveedor registrarProveedor(Proveedor obj);

	public List<Proveedor> listaProveedor();

	public List<Proveedor> listaFiltroProveedor(String ruc, int estado, int pais, String razonsocial);
}