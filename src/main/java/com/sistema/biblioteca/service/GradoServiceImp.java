package com.sistema.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biblioteca.entity.Grado;
import com.sistema.biblioteca.repository.GradoRepository;

@Service
public class GradoServiceImp implements GradoService {

	@Autowired
	private GradoRepository Repository;

	@Override
	public List<Grado> listaTodos() {
		return Repository.findAll();

	}

}
