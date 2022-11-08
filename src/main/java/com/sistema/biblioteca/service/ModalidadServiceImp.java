package com.sistema.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biblioteca.entity.Modalidad;
import com.sistema.biblioteca.repository.ModalidadRepository;


@Service
public class ModalidadServiceImp implements ModalidadService {

	@Autowired
	private ModalidadRepository Repository;

	@Override
	public List<Modalidad> listaTodos() {
		return Repository.findAll();

	}

}
