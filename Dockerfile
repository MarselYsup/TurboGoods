FROM openjdk:17

ADD build/libs/TurboGoods-0.0.1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]