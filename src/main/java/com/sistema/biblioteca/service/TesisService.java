package com.sistema.biblioteca.service;

import java.util.List;

import com.sistema.biblioteca.entity.Tesis;

public interface TesisService {

	public abstract List<Tesis> listaTesis();

	public abstract Tesis insertaActualizaTesis(Tesis obj);

	public abstract List<Tesis> listaTesisPorTituloTemaAlumno(String titulo, String tema, int idAlumno, int estado);
}
