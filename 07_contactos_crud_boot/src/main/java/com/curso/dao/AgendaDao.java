package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.curso.model.Contacto;

public interface AgendaDao extends JpaRepository<Contacto,Integer>{
	Contacto findByEmail(String email);
	@Transactional
	@Modifying
	@Query("Delete From Contacto c Where c.email=?1")
	void eliminarContacto(String email);

}