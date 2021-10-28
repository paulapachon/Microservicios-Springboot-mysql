package com.formacion.springboot.app.examenes.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.springboot.commons.examenes.models.entity.Asignatura;
import com.formacion.springboot.commons.examenes.models.entity.Examen;
import com.formacion.springboot.commons.services.CommonServiceImpl;
import com.formacion.springboot.app.examenes.models.repository.AsignaturaRepository;
import com.formacion.springboot.app.examenes.models.repository.ExamenRepository;






@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen,ExamenRepository>  implements ExamenService {

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Examen> findByNombre(String term) {
		return repository.findByNombre(term);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Asignatura> findAllAsignatura() {
		return (List<Asignatura>) asignaturaRepository.findAll();
	}

}

