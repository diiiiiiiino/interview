FROM openjdk:11.0.14.1-jre as builder
WORKDIR layer
COPY build/libs/*.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM azul/zulu-openjdk:11.0.17

RUN apt-get update
RUN apt-get install -y curl

VOLUME /app/log

WORKDIR layer
COPY --from=builder layer/dependencies/ ./
COPY --from=builder layer/spring-boot-loader/ ./
COPY --from=builder layer/snapshot-dependencies/ ./
COPY --from=builder layer/application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

