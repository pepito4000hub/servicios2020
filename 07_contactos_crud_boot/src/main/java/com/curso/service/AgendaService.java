package com.curso.service;

import java.util.List;

import com.curso.model.Contacto;

public interface AgendaService {
	//a�ade el contacto si no est� repetido el
	//email
	void altaContacto(Contacto contacto);
	List<Contacto> obtenerContactos();
	void eliminar(int idContacto);
	void eliminar(String email);
	void actualizarContacto(Contacto contacto);
	Contacto recuperarPorEmail(String email);
	Contacto recuperarPorId(int idContacto);
}
