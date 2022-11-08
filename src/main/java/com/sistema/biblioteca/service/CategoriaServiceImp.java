package com.sistema.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biblioteca.entity.Categoria;
import com.sistema.biblioteca.repository.CategoriaRepository;

@Service
public class CategoriaServiceImp implements CategoriaService {

	@Autowired
	private CategoriaRepository Repository;

	@Override
	public List<Categoria> listaTodos() {
		return Repository.findAll();

	}

}
