# Practica1_JDBC_WORLD

Primera práctica de JDBC del ciclo de DAM (octubre de 2022). Es un proyecto Maven en Java que accede por JDBC a la base de datos de ejemplo `world` de MySQL, con el patrón DAO: una interfaz y una clase por cada tabla (`city`, `country` y `countrylanguage`) y las clases del modelo.

## Estado

Es una práctica que no llegó a terminarse del todo.

- Compila con Java 17 y Maven.
- `CityDaoImpl` tiene hechos listar, comprobar, consultar, añadir y cambiar el nombre de una ciudad, y comprobar si una ciudad pertenece a un país. No lo he probado contra una base de datos real, solo la compilación.
- `CountryDaoImpl` y `CountryLanguageDaoImpl` están a medias: algunas consultas todavía hay que revisarlas (por ejemplo la comprobación de si existe un país busca por `id` en lugar de por `code`).
- `App.java` es solo una prueba manual con las llamadas comentadas.

## Cómo probarlo

Hace falta tener cargada la base de datos `world` de MySQL. La conexión está escrita a mano en `src/main/java/utils/DatabaseConnection.java` (una máquina virtual local en `192.168.56.101`, usuario `user`); habrá que cambiarla por la tuya.

```
mvn compile
mvn exec:java -Dexec.mainClass=App
```

---

# Practica1_JDBC_WORLD (English)

First JDBC assignment of my DAM vocational course (October 2022). A Maven project in Java that talks to MySQL's sample `world` database through JDBC using the DAO pattern: an interface and a class for each table (`city`, `country` and `countrylanguage`) plus the model classes.

## Status

The assignment was never fully finished.

- It builds with Java 17 and Maven.
- `CityDaoImpl` can list, check, look up, add and rename a city, and check whether a city belongs to a country. I have only checked that it compiles, not run it against a real database.
- `CountryDaoImpl` and `CountryLanguageDaoImpl` are half done: some queries still need fixing (for example, the check for whether a country exists looks it up by `id` instead of `code`).
- `App.java` is just a manual test with most calls commented out.

## Trying it

You need the `world` database loaded in MySQL. The connection is hardcoded in `src/main/java/utils/DatabaseConnection.java` (a local virtual machine at `192.168.56.101`, user `user`); change it to yours.

```
mvn compile
mvn exec:java -Dexec.mainClass=App
```
