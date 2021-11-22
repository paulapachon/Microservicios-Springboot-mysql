FROM openjdk:16
VOLUME /tmp
EXPOSE 8890
ADD ./target/microservicio-usuarios-0.0.1-SNAPSHOT.jar servicio-usuarios.jar
ENTRYPOINT ["java","-jar","/servicio-usuarios.jar"]