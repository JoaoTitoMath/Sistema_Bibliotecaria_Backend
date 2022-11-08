package com.sistema.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biblioteca.entity.Autor;
import com.sistema.biblioteca.repository.AutorRepository;

@Service
public class AutorServiceImp implements AutorService {

	@Autowired
	private AutorRepository Repository;

	@Override
	public Autor insertaActualizaAutor(Autor obj) {
		return Repository.save(obj);
	}

	@Override
	public List<Autor> listaAutor() {
		return Repository.findAll();
	}

	@Override
	public List<Autor> listaAutorPorNombresTelefonoGrado(String nombres, String telefono, int idGrado, int estado) {
		return Repository.listaAutorPorNombresTelefonoGrado(nombres, telefono, idGrado, estado);
	}

}
