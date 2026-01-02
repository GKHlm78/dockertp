# ingnum, RentalService

Service de location développé avec Spring Boot et Docker.

## Prérequis

- Java SDK 21
- Docker Desktop

## Installation et démarrage en local

### 1. Installer le projet

```bash
cd chemin/vers/votre/dossier
git clone <url-du-repo>
git branch -M main
git push -u origin main
```

### 2. Installation de Java SDK 21

Téléchargez et installez Java SDK 21 depuis le site d'Oracle.

Vérifiez l'installation :
```bash
java -version
```

### 3. Build de l'application

```bash
cd RentalService
.\gradlew build
```

### 4. Lancer l'application localement

```bash
# Être à la racine du service ./RentalService
java -jar build/libs/RentalService-0.0.1-SNAPSHOT.jar
```

Checker l'application dans votre navigateur : `http://localhost:8080/bonjour`

### 5. Créer dockerfile

Ecrire ceci dans un fichier dockerfile a la racine du micro service :

```bash
FROM eclipse-temurin:21
VOLUME /tmp
EXPOSE 8080
ADD ./build/libs/RentalService-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/urandom", "-jar", "/app.jar"]
```

### 6. Build et lancement avec Docker

#### Construire l'image Docker :
```bash
cd RentalService
docker build -t rentalservice .
```

#### Lancer le conteneur :
```bash
docker run -p 8080:8080 <ID IMAGE>
```

L'application sera accessible sur `http://localhost:8080`
