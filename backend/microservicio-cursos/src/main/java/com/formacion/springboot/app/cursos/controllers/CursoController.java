package com.formacion.springboot.app.cursos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.springboot.app.cursos.models.entity.Curso;
import com.formacion.springboot.app.cursos.services.CursoService;
import com.formacion.springboot.commons.alumnos.models.entity.Alumno;
import com.formacion.springboot.commons.controllers.CommonController;
import com.formacion.springboot.commons.examenes.models.entity.Examen;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

	@Value("${config.balanceador.test}")
	private String balanceadorTest;
	
	@GetMapping("/balanceador-test")
	public ResponseEntity<?> balanceadorTest(){
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("balanceador", balanceadorTest);
		response.put("cursos", service.findAll());
		return ResponseEntity.ok(response);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso curso, BindingResult result, @PathVariable Long id ){
		
		if(result.hasErrors()) {
			return this.validar(result);
		}
		Optional<Curso> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();
		cursoDb.setNombre(curso.getNombre());

		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
					
	}
	
	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id ){
		Optional<Curso> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();
		alumnos.forEach(a ->{
			cursoDb.addAlumnos(a);
		});	
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
					
	}
	
	@PutMapping("/{id}/eliminar-alumnos")
	public ResponseEntity<?> eliminarAlumnos(@RequestBody Alumno alumno, @PathVariable Long id ){
		Optional<Curso> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();
		cursoDb.removeAlumnos(alumno);
	
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
					
	}
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> buscarCursoPorAlumnoId(@PathVariable Long id ){
		Curso curso = service.findCursoByAlumnoId(id);
		if (curso != null) {
			
			List<Long> examenesIds = (List<Long>) service.obtenerExamenesConRespuestasAlumno(id);
			
			List<Examen> examenes = curso.getExamenes().stream().map(examen -> {
					if(examenesIds.contains(examen.getId())) {
						examen.setRespondido(true);
					}
					return examen;
			}).collect(Collectors.toList());
			curso.setExamenes(examenes);
		}
		
		return ResponseEntity.ok(curso);
					
	}
	
	@PutMapping("/{id}/asignar-examenes")
	public ResponseEntity<?> asignarExamenes(@RequestBody List<Examen> examenes, @PathVariable Long id ){
		Optional<Curso> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();
		examenes.forEach(e ->{
			cursoDb.addExamen(e);
		});	
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
					
	}
	
	@PutMapping("/{id}/eliminar-examenes")
	public ResponseEntity<?> eliminarExamenes(@RequestBody Examen examen, @PathVariable Long id ){
		Optional<Curso> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Curso cursoDb = o.get();
		cursoDb.removeExamen(examen);
	
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDb));
					
	}
	
	
	
}
