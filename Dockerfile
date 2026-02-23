# Usiamo l'immagine ufficiale Oracle per Java 25
FROM container-registry.oracle.com/java/openjdk:25-oraclelinux9

# Ci spostiamo nella cartella /app del container
WORKDIR /app

# Copiamo il file .jar che si trova nella tua cartella locale 'target' 
# dentro la cartella /app del container rinominandolo 'app.jar'
COPY target/*.jar app.jar

# Espone la porta del gestionale
EXPOSE 8080

# Avvia l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]