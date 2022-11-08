package com.sistema.biblioteca.service;

import java.util.List;

import com.sistema.biblioteca.entity.Opcion;
import com.sistema.biblioteca.entity.Rol;
import com.sistema.biblioteca.entity.Usuario;


public interface UsuarioService {

	public abstract Usuario login(Usuario bean);

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	public abstract Usuario buscaPorLogin(String login);
}
