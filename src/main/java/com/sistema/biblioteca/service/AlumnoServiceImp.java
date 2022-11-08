package com.sistema.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.biblioteca.entity.Alumno;
import com.sistema.biblioteca.repository.AlumnoRepository;



@Service
public class AlumnoServiceImp implements AlumnoService {

	@Autowired
	private AlumnoRepository Repository;

	@Override
	public List<Alumno> listaTodos() {
		return Repository.findAll();

	}

	@Override
	public Alumno insertaActualizaAlumno(Alumno obj) {
		// TODO Auto-generated method stub
		return Repository.save(obj);
	}

}
