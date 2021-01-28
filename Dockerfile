FROM openjdk:8
COPY target/eye-of-anu-2.2.0.jar /opt/project/eye-of-anu-2.2.0.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/opt/project/eye-of-anu-2.2.0.jar"]
