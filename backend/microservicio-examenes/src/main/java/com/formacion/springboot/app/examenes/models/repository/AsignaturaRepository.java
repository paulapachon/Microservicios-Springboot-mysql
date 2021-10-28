package com.formacion.springboot.app.examenes.models.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.formacion.springboot.commons.examenes.models.entity.Asignatura;

public interface AsignaturaRepository extends PagingAndSortingRepository<Asignatura, Long> {

}
