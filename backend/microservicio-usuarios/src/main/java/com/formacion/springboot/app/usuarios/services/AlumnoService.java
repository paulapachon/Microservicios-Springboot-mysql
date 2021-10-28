package com.formacion.springboot.app.usuarios.services;


import java.util.List;

import com.formacion.springboot.commons.alumnos.models.entity.Alumno;
import com.formacion.springboot.commons.services.CommonService;

public interface AlumnoService extends CommonService<Alumno> {
	

	public List<Alumno> findByNombreOrApellido(String term);
	
	

}
