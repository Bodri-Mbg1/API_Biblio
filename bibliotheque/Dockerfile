FROM ubuntu:latest
LABEL authors="Bodri Mbg"

ENTRYPOINT ["top", "-b"]

# Étape 1 : Utiliser une image de base Java
FROM openjdk:17-jdk-slim

# Étape 2 : Définir le répertoire de travail
WORKDIR /app

# Étape 3 : Copier le fichier JAR dans le conteneur
COPY target/bibliotheque-0.0.1-SNAPSHOT.jar app.jar

# Étape 4 : Exposer le port utilisé par l'application
EXPOSE 8080

# Étape 5 : Exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
