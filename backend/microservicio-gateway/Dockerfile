FROM openjdk:16
VOLUME /tmp
EXPOSE 8090
ADD ./target/microservicio-gateway-0.0.1-SNAPSHOT.jar servicio-gateway.jar
ENTRYPOINT ["java","-jar","/servicio-gateway.jar"]