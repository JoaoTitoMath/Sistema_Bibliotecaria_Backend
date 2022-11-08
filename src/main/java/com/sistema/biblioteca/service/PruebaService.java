package com.sistema.biblioteca.service;

import java.util.List;

import com.sistema.biblioteca.entity.Prueba;

public interface PruebaService {

	public abstract List<Prueba> listaPrueba();

	public abstract Prueba insertaActualizaPrueba(Prueba obj);

}
