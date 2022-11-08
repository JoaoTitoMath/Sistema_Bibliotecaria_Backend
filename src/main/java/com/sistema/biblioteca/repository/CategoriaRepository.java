package com.sistema.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.biblioteca.entity.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
	

}
