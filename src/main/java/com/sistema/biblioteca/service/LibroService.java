package com.sistema.biblioteca.service;

import java.util.List;

import com.sistema.biblioteca.entity.Libro;

public interface LibroService {

	public abstract List<Libro> listaLibro();

	public abstract Libro insertaActualizaLibro(Libro obj);

	public abstract List<Libro> listaLibroPorTituloAnioCategoria(String titulo, int anio, int idCategoria, int estado);
}
