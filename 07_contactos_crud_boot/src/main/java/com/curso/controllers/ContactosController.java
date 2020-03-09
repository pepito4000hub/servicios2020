package com.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Contacto;
import com.curso.service.AgendaService;

@RestController
public class ContactosController {
	@Autowired
	AgendaService agenda;
	@GetMapping(value="/contactos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Contacto> recuperarContactos() {
		return agenda.obtenerContactos();
	}
	@GetMapping(value="/contacto/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Contacto buscarContacto(@PathVariable("email") String email) {
		return agenda.recuperarPorEmail(email);
	}
	
	@PostMapping(value="/contacto",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void guardarContacto(@RequestBody Contacto contacto) {
		agenda.altaContacto(contacto);
		
	}
	@PutMapping(value="/contacto",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarContacto(@RequestBody Contacto contacto) {
		agenda.actualizarContacto(contacto);
		
	}
	@DeleteMapping(value="/contacto/{idContacto}")
	public void eliminarPorId(@PathVariable("idContacto") int idContacto) {
		
		agenda.eliminar(idContacto);
	}
	
}


