package com.sistema.biblioteca.service;

import java.util.List;

import com.sistema.biblioteca.entity.Autor;



public interface AutorService {

	public abstract List<Autor> listaAutor();
	public abstract Autor insertaActualizaAutor(Autor obj);
	public abstract List<Autor> listaAutorPorNombresTelefonoGrado(String nombres, String telefono, int idGrado, int estado);
	
	
}
