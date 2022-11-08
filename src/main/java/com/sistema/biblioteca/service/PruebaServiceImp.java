package com.sistema.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biblioteca.entity.Prueba;
import com.sistema.biblioteca.repository.PruebaRepository;

@Service
public class PruebaServiceImp implements PruebaService {

	@Autowired
	private PruebaRepository repository;

	@Override
	public Prueba insertaActualizaPrueba(Prueba obj) {
		return repository.save(obj);
	}

	@Override
	public List<Prueba> listaPrueba() {
		return repository.findAll();
	}
}
