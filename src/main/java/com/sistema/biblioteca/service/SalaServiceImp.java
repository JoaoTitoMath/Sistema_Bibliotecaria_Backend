package com.sistema.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biblioteca.entity.Sala;
import com.sistema.biblioteca.repository.SalaRepository;

@Service
public class SalaServiceImp implements SalaService {

	@Autowired
	private SalaRepository reposala;

	@Override
	public List<Sala> listaSala() {
		return reposala.findAll();
	}

	@Override
	public Sala insertaActualizaSala(Sala objsala) {
		return reposala.save(objsala);
	}

	@Override
	public List<Sala> listaSalaNumeroFechaSede(String numero, int numAlumnos, int idSede, int estado) {

		return reposala.listaSalaPorNumeroFechaSedeEstado(numero, numAlumnos, idSede, estado);
	}

}
