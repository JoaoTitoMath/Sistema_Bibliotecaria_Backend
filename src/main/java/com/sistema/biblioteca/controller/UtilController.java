package com.sistema.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.biblioteca.entity.Alumno;
import com.sistema.biblioteca.entity.Autor;
import com.sistema.biblioteca.entity.Categoria;
import com.sistema.biblioteca.entity.Grado;
import com.sistema.biblioteca.entity.Modalidad;
import com.sistema.biblioteca.entity.Pais;
import com.sistema.biblioteca.entity.Sede;
import com.sistema.biblioteca.service.AlumnoService;
import com.sistema.biblioteca.service.AutorService;
import com.sistema.biblioteca.service.CategoriaService;
import com.sistema.biblioteca.service.GradoService;
import com.sistema.biblioteca.service.ModalidadService;
import com.sistema.biblioteca.service.PaisService;
import com.sistema.biblioteca.service.SedeService;
import com.sistema.biblioteca.utils.AppSettings;

@RestController
@RequestMapping("/url/util")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UtilController {

	@Autowired
	private PaisService paisService;

	@Autowired
	private GradoService gradoService;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private AlumnoService alumnoService;

	@Autowired
	private AutorService autorService;

	@Autowired
	private ModalidadService modalidadService;

	@Autowired
	private SedeService sedeService;

	@GetMapping("/listaPais")
	@ResponseBody
	public List<Pais> listaPais() {
		return paisService.listaTodos();
	}

	@GetMapping("/listaCategoria")
	@ResponseBody
	public List<Categoria> listaCategoria() {
		return categoriaService.listaTodos();
	}

	@GetMapping("/listaGrado")
	@ResponseBody
	public List<Grado> listaGrado() {
		return gradoService.listaTodos();
	}

	@GetMapping("/listaModalidad")
	@ResponseBody
	public List<Modalidad> listaModalidad() {
		return modalidadService.listaTodos();

	}

	@GetMapping("/listaSede")
	@ResponseBody
	public List<Sede> listaSede() {
		return sedeService.listaTodos();

	}

	@GetMapping("/listaAlumno")
	@ResponseBody
	public List<Alumno> listaAlumno() {
		return alumnoService.listaTodos();

	}

	@GetMapping("/listaAutor")
	@ResponseBody
	public List<Autor> listaAutor() {
		return autorService.listaAutor();
	}

}
