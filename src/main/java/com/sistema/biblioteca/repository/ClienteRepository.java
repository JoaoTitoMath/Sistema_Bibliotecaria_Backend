package com.sistema.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.biblioteca.entity.Alumno;



public interface ClienteRepository extends JpaRepository<Alumno, Integer> {

	

}
