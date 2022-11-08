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

import com.sistema.biblioteca.entity.Proveedor;
import com.sistema.biblioteca.service.ProveedorService;
import com.sistema.biblioteca.utils.AppSettings;
import com.sistema.biblioteca.utils.Constantes;

@RestController
@RequestMapping("/url/proveedor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Proveedor>> listaProveedor() {
		List<Proveedor> lista = proveedorService.listaProveedor();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> agregarProveedor(@Valid @RequestBody Proveedor obj, Errors errors) {
		Map<String, Object> salida = new HashMap<>();
		List<String> lstMensajes = new ArrayList<>();
		salida.put("salida", lstMensajes);

		List<ObjectError> lstErrors = errors.getAllErrors();
		for (ObjectError objectError : lstErrors) {
			objectError.getDefaultMessage();
			lstMensajes.add(objectError.getDefaultMessage());
		}
		if (!CollectionUtils.isEmpty(lstMensajes)) {
			return ResponseEntity.ok(salida);
		}

		Proveedor objSalida = proveedorService.registrarProveedor(obj);
		if (objSalida == null) {
			lstMensajes.add("Error en el registro");
		} else {
			lstMensajes.add("Se registró el Proveedor con ID ==> " + objSalida.getIdProveedor());
		}

		return ResponseEntity.ok(salida);
	}

	@GetMapping("/listaProveedorConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaSalaNumeroFechaSede(
			@RequestParam(name = "ruc", required = false, defaultValue = "") String ruc,
			@RequestParam(name = "estado", required = true, defaultValue = "-1") int estado,
			@RequestParam(name = "idPais", required = false, defaultValue = "-1") int pais,
			@RequestParam(name = "razonSocial", required = false, defaultValue = "") String razonsocial) {
		Map<String, Object> salida = new HashMap<>();
		try {
			// List<Proveedor> listaProveedor =
			// proveedorService.listaFiltroProveedor("%"+ruc+"%", estado, pais,
			// "%"+razonSocial+"%");

			List<Proveedor> listaProveedor = proveedorService.listaFiltroProveedor(ruc, estado, pais, razonsocial);

			if (CollectionUtils.isEmpty(listaProveedor)) {
				salida.put("mensaje", "No existen datos para mostrar");
			} else {
				salida.put("lista", listaProveedor);
				salida.put("mensaje", "Existen " + listaProveedor.size() + " elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
}