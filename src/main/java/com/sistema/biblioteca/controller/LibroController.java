package com.sistema.biblioteca.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.biblioteca.entity.Libro;
import com.sistema.biblioteca.service.LibroService;
import com.sistema.biblioteca.utils.AppSettings;
import com.sistema.biblioteca.utils.Constantes;

@RestController
@RequestMapping("/url/libro")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class LibroController {

	@Autowired
	private LibroService libroService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Libro>> listaAlumno() {
		List<Libro> lista = libroService.listaLibro();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> inserta(@Valid @RequestBody Libro obj, Errors errors) {
		HashMap<String, Object> salida = new HashMap<>();
		List<String> lstMensajes = new ArrayList<String>();
		salida.put("errores", lstMensajes);

		List<ObjectError> lstErrors = errors.getAllErrors();
		for (ObjectError objectError : lstErrors) {
			objectError.getDefaultMessage();
			lstMensajes.add(objectError.getDefaultMessage());
		}

		if (!CollectionUtils.isEmpty(lstMensajes)) {
			return ResponseEntity.ok(salida);
		}

		Libro objSalida = libroService.insertaActualizaLibro(obj);
		if (objSalida == null) {
			lstMensajes.add("Error en el registro");
		} else {
			lstMensajes.add("Se registró el libro con el ID ==> " + objSalida.getIdLibro());
		}
		return ResponseEntity.ok(salida);
	}

	@GetMapping("/listaLibroConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaLibroPorTituloAnioCategoria(
			@RequestParam(name = "titulo", required = false, defaultValue = "") String titulo,
			@RequestParam(name = "anio", required = false, defaultValue = "0") int anio,
			@RequestParam(name = "idCategoria", required = false, defaultValue = "-1") int idCategoria,
			@RequestParam(name = "estado", required = true, defaultValue = "1") int estado) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Libro> lista = libroService.listaLibroPorTituloAnioCategoria("%" + titulo + "%", anio, idCategoria,
					estado);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos para mostrar");
			} else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen " + lista.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
