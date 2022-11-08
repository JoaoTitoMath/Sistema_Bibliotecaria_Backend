package com.sistema.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biblioteca.entity.Pais;
import com.sistema.biblioteca.repository.PaisRepository;

@Service
public class PaisServiceImp implements PaisService {

	@Autowired
	private PaisRepository Repository;

	@Override
	public List<Pais> listaTodos() {
		return Repository.findAll();

	}

}
