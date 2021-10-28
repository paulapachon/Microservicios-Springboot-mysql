package com.formacion.springboot.app.examenes.services;

import java.util.List;

import com.formacion.springboot.commons.examenes.models.entity.Asignatura;
import com.formacion.springboot.commons.examenes.models.entity.Examen;
import com.formacion.springboot.commons.services.CommonService;

public interface ExamenService extends CommonService<Examen> {
	
	public List<Examen> findByNombre(String term);
	
	public List<Asignatura> findAllAsignatura();

}
