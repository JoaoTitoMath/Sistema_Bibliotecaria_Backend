package com.sistema.biblioteca.service;

import java.util.List;

import com.sistema.biblioteca.entity.Sala;

public interface SalaService {

	public List<Sala> listaSala();

	public Sala insertaActualizaSala(Sala objsala);

	public abstract List<Sala> listaSalaNumeroFechaSede(String numero, int numAlumnos, int idSede, int estado);
}
