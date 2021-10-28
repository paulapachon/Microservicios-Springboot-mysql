package com.formacion.springboot.app.cursos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="microservicio-respuestas")
public interface RespuestaFeignClient {
	
	@GetMapping("/alumno/{alumnoId}/examenes-respondidos")
	public Iterable<Long> obtenerExamenesConRespuestasAlumno(@PathVariable Long alumnoId);	
}
