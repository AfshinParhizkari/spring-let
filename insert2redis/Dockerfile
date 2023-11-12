FROM localhost:5000/openjdk:11
MAINTAINER "Afshin.Parhizkari@gmail.com"
VOLUME /insert2redis
ARG JAR_FILE=target/insert2redis-1.jar
COPY target/insert2redis-1.jar insert2redis.jar
EXPOSE 3030
ENTRYPOINT ["java", "-jar", "/insert2redis.jar"]
