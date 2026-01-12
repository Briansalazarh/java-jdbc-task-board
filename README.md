# java-jdbc-task-board
tablero de tareas ProjectBoard CLI

# Project Board CLI - JDBC Implementation

Este proyecto es un gestor de tareas (Kanban board) mediante línea de comandos, implementado con **Java 21** y **JDBC** sin el uso de frameworks de alto nivel, con el fin de demostrar el manejo directo de la persistencia de datos.

## Tecnologías

* **Java 21**
* **Maven**
* **MySQL** (Driver 8.3.0)
* **JDBC** (Java Database Connectivity)
* **Lombok**

## Estructura del Banco de Datos

El script de inicialización del banco se encuentra en `scripts/init.sql`. La aplicación se conecta a MySQL en el puerto estándar `3306` a la base de datos `board_db`.

## Patrones de Proyecto

* **DAO (Data Access Object):** Para encapsular la lógica de acceso a datos.
* **DTO (Data Transfer Object):** Para el transporte de datos entre capas.
* **Connection Factory:** Para centralizar la gestión de conexiones.

## Cómo ejecutar

1. Ejecuta el script `scripts/init.sql` en tu MySQL.
2. Ajusta las credenciales en `ConnectionFactory.java`.
3. Compila y ejecuta la clase `Main`.
