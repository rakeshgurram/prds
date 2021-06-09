FROM openjdk:8
ADD target/prdsboot.jar prdsboot.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "prdsboot.jar"]
