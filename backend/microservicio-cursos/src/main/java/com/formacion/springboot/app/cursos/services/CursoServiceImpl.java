package com.formacion.springboot.app.cursos.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.springboot.app.cursos.clients.RespuestaFeignClient;
import com.formacion.springboot.app.cursos.models.entity.Curso;
import com.formacion.springboot.app.cursos.models.repository.CursoRepository;
import com.formacion.springboot.commons.services.CommonServiceImpl;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {

	@Autowired
	private RespuestaFeignClient client;
	
	@Override
	@Transactional(readOnly=true)
	public Curso findCursoByAlumnoId(Long id) {
		return repository.findCursoByAlumnoId(id);
	}

	@Override
	public Iterable<Long> obtenerExamenesConRespuestasAlumno(Long alumnoId) {
		return client.obtenerExamenesConRespuestasAlumno(alumnoId);
	}

	

}
