package com.sistema.biblioteca.service;

import java.util.List;

import com.sistema.biblioteca.entity.Alumno;

public interface AlumnoService {

	public abstract List<Alumno> listaTodos();

	public abstract Alumno insertaActualizaAlumno(Alumno obj);

}
