package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.AgendaDao;
import com.curso.model.Contacto;

@Service
public class AgendaServiceImpl implements AgendaService {
	@Autowired
	AgendaDao agendaDao;
	@Override
	public void altaContacto(Contacto contacto) {
		//damos de alta el contacto si no existe
		if(agendaDao.findByEmail(contacto.getEmail())==null) {
			agendaDao.save(contacto);
		}
	}

	@Override
	public List<Contacto> obtenerContactos() {
		return agendaDao.findAll();
	}

	@Override
	public void eliminar(int idContacto) {
		agendaDao.deleteById(idContacto);
	}

	@Override
	public void eliminar(String email) {
		agendaDao.eliminarContacto(email);

	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		agendaDao.save(contacto);
		
	}

	@Override
	public Contacto recuperarPorEmail(String email) {
		return agendaDao.findByEmail(email);
	}

	@Override
	public Contacto recuperarPorId(int idContacto) {
		// TODO Auto-generated method stub
		return agendaDao.findById(idContacto).orElse(null);
	}
	
	
	

}
