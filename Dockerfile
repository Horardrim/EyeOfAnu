FROM openjdk:8
COPY target/eye-of-anu-2.2.1.jar /opt/project/eye-of-anu-2.2.1.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/opt/project/eye-of-anu-2.2.1.jar"]
