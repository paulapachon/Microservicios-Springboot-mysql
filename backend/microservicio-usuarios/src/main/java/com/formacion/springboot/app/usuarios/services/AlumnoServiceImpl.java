package com.formacion.springboot.app.usuarios.services;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.springboot.app.usuarios.models.repository.AlumnoRepository;
import com.formacion.springboot.commons.alumnos.models.entity.Alumno;
import com.formacion.springboot.commons.services.CommonServiceImpl;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements AlumnoService {

	@Override
	@Transactional(readOnly= true)
	public List<Alumno> findByNombreOrApellido(String term) {
		return repository.findByNombreOrApellido(term);
	}

	
}
