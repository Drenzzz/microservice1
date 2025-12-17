# Gunakan image dasar Java yang stabil (LTS)
FROM eclipse-temurin:21-jdk

# Tambahkan JAR hasil build dari Maven
COPY target/*.jar app.jar

# Tentukan port aplikasi
EXPOSE 8081

# Jalankan aplikasi
ENTRYPOINT ["java", "-jar", "/app.jar"]
