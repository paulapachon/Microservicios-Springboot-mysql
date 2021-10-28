package com.formacion.springboot.app.respuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.formacion.springboot.app.respuestas.models.entity",
	"com.formacion.springboot.commons.alumnos.models.entity",
	"com.formacion.springboot.commons.examenes.models.entity"
})
public class MicroservicioRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioRespuestasApplication.class, args);
	}

}
