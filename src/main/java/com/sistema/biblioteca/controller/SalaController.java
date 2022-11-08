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

import com.sistema.biblioteca.entity.Sala;
import com.sistema.biblioteca.service.SalaService;
import com.sistema.biblioteca.utils.AppSettings;
import com.sistema.biblioteca.utils.Constantes;

@RestController
@RequestMapping("/url/sala")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class SalaController {

	@Autowired
	private SalaService salaService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Sala>> listaSala() {

		List<Sala> lista = salaService.listaSala();
		return ResponseEntity.ok(lista);

	}

	/*
	 * Inserta datos en sala - Jacqueline Flores
	 */

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> insertaSala(@Valid @RequestBody Sala obj, Errors erros) {
		Map<String, Object> salida = new HashMap<>();
		List<String> lstMensajes = new ArrayList<>();
		salida.put("sala", lstMensajes);

		List<ObjectError> lstErros = erros.getAllErrors();
		for (ObjectError objectError : lstErros) {
			objectError.getDefaultMessage();
			lstMensajes.add(objectError.getDefaultMessage());
		}
		if (!CollectionUtils.isEmpty(lstMensajes)) {
			return ResponseEntity.ok(salida);

		}

		Sala objSalida = salaService.insertaActualizaSala(obj);
		if (objSalida == null) {
			lstMensajes.add("Error al Registrar Sala");
		} else {

			lstMensajes.add("Se Registro Correctamente la Sala de ID => " + objSalida.getIdSala());
		}

		return ResponseEntity.ok(salida);
	}

	@GetMapping("/listaSalaConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaSalaNumeroFechaSede(
			@RequestParam(name = "numero", required = false, defaultValue = "") String numero,
			@RequestParam(name = "numAlumnos", required = false, defaultValue = "0") int numAlumnos,
			@RequestParam(name = "idSede", required = false, defaultValue = "-1") int idSede,
			@RequestParam(name = "estado", required = true, defaultValue = "1") int estado) {
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Sala> lista = salaService.listaSalaNumeroFechaSede("%" + numero + "%", numAlumnos, idSede, estado);
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
