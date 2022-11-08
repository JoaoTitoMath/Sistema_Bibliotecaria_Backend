package com.sistema.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biblioteca.entity.Sede;
import com.sistema.biblioteca.repository.SedeRepository;

@Service
public class SedeServiceImp implements SedeService {

	@Autowired
	private SedeRepository Repository;

	@Override
	public List<Sede> listaTodos() {
		return Repository.findAll();

	}

}
