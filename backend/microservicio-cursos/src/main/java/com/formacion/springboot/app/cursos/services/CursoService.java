package com.formacion.springboot.app.cursos.services;



import com.formacion.springboot.app.cursos.models.entity.Curso;
import com.formacion.springboot.commons.services.CommonService;

public interface CursoService extends CommonService<Curso> {

	public Curso findCursoByAlumnoId(Long id);
	public Iterable<Long> obtenerExamenesConRespuestasAlumno(Long alumnoId);	
}
