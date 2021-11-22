FROM openjdk:16
VOLUME /tmp
EXPOSE 8443
ADD ./target/microservicio-respuestas-0.0.1-SNAPSHOT.jar servicio-respuestas.jar
ENTRYPOINT ["java","-jar","/servicio-respuestas.jar"]