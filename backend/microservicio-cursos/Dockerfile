FROM openjdk:16
VOLUME /tmp
EXPOSE 8060
ADD ./target/microservicio-cursos-0.0.1-SNAPSHOT.jar servicio-cursos.jar
ENTRYPOINT ["java","-jar","/servicio-cursos.jar"]