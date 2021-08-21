FROM openjdk:11
VOLUME /tmp
ADD target/eva-exchange*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]