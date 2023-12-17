#Задаем базовый образ для контейнер
FROM openjdk:8-jdk-alpine

#Внутренний порт REST-приложения
EXPOSE 8081

#Добавление файла сборки в образ
ADD build/libs/auth-service-0.0.1.jar app.jar

#Инструкция для запуска моего приложения добавленного в контейнер
CMD ["java", "-jar", "app.jar"]