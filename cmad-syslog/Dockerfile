FROM maven:3.6.1-jdk-8-slim

WORKDIR /app

COPY .  .

RUN mvn package -pl cmad-syslog && \
    mv target/*.jar /run/cmad-syslog.jar && \
    rm -rf /app/*

CMD java  -jar /run/cmad-syslog.jar

