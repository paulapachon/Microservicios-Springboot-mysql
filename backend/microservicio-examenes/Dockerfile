FROM openjdk:16
VOLUME /tmp
EXPOSE 8020
ADD ./target/microservicio-examenes-0.0.1-SNAPSHOT.jar servicio-examenes.jar
ENTRYPOINT ["java","-jar","/servicio-examenes.jar"]