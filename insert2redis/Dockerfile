FROM afshin:5000/openjdk:11
MAINTAINER "Afshin.Parhizkari@gmail.com"
VOLUME /redis-service
ARG JAR_FILE=target/insert2redis-1.jar
COPY target/insert2redis-1.jar redis-service.jar
EXPOSE 3030
ENTRYPOINT ["java", "-jar", "/redis-service.jar"]
