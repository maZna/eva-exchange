#Build Stage
FROM maven:3.8.2-jdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#Package Stage
FROM openjdk:11
EXPOSE 8081:8081
COPY --from=build /home/app/target/eva-exchange-1.0.0.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch eva-exchange-1.0.0.jar'
ENTRYPOINT ["java","-jar","eva-exchange-1.0.0.jar"]