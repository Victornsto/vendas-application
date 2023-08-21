FROM openjdk

WORKDIR /app

COPY target/vendas-0.0.1-SNAPSHOT.jar /app/vendas.jar

ENTRYPOINT ["java", "-jar", "vendas.jar"]
