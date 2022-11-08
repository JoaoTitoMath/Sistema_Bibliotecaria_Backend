package com.sistema.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.biblioteca.entity.Alumno;



public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	

}
