FROM openjdk:17
EXPOSE 7070
ADD target/productApp.jar productApp.jar
ENTRYPOINT ["java","-jar","/productApp.jar"]