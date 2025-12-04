# Advent of Code 2025 - Día 2: Sistema de Gestión de Inventario

Este repositorio contiene la solución para el Día 2 del Advent of Code 2025. El desafío consiste en identificar IDs de productos "inválidos" dentro de rangos específicos basándose en patrones de dígitos repetidos.

## Descripción del Problema

Los elfos de la tienda de regalos del Polo Norte han añadido accidentalmente IDs de productos inválidos a su base de datos. Se nos proporciona una lista de rangos de IDs (por ejemplo, `11-22`, `95-115`) y necesitamos encontrar la suma de todos los IDs inválidos dentro de estos rangos.

### Parte 1

Un ID se considera **inválido** si consiste en una secuencia de dígitos repetida exactamente **dos veces**.

- Ejemplos: `55` (5 repetido dos veces), `6464` (64 repetido dos veces).
- No ejemplos: `101` (válido).

### Parte 2

La definición de un ID inválido se expande. Un ID ahora es **inválido** si consiste en una secuencia de dígitos repetida **al menos dos veces**.

- Ejemplos: `12341234` (1234 dos veces), `123123123` (123 tres veces), `1111111` (1 siete veces).

## Estructura del Proyecto

El proyecto es una aplicación Java organizada usando Maven. La solución está dividida en dos paquetes para cada parte del desafío:

- `src/main/java/software/aoc/day02/a`: Contiene la solución para la Parte 1.
  - `Main.java`: Punto de entrada, lee los rangos y suma los IDs inválidos.
  - `Range.java`: Lógica para generar números en un rango y validarlos (comprobar si al dividirlos por la mitad son iguales).
  - `FileInstructionReader.java`: Ayudante para leer el archivo de entrada.
- `src/main/java/software/aoc/day02/b`: Contiene la solución para la Parte 2.
  - `Main.java`: Punto de entrada para la Parte 2.
  - `Range.java`: Lógica para generar números y delegar la validación.
  - `PatternValidator.java`: Lógica para comprobar si un número está formado por _cualquier_ secuencia repetida (no solo dividido por la mitad).

## Requisitos

- Java 21 o superior (usa tipos `record`).
- Maven.

## Cómo Ejecutar

1.  **Datos de Entrada**: Asegúrate de que tu entrada del puzzle esté ubicada en `src/main/resources/ranges`. El archivo debe contener rangos separados por comas (ej. `11-22,95-115`).

2.  **Ejecutar Parte 1**:
    Puedes ejecutar el método `main` en `software.aoc.day02.a.Main`.

3.  **Ejecutar Parte 2**:
    Puedes ejecutar el método `main` en `software.aoc.day02.b.Main`.

## Detalles de Implementación

### Enfoque Parte 1

Para cada número en los rangos dados, lo convertimos a cadena. Comprobamos si la longitud de la cadena es par. Si es así, la dividimos en dos mitades y comprobamos si son idénticas.

### Enfoque Parte 2

Para cada número, comprobamos si puede formarse repitiendo una subsecuencia. Iteramos a través de posibles longitudes de secuencia (desde 1 hasta la mitad de la longitud del número). Si la longitud total es divisible por la longitud de la secuencia, repetimos la subsecuencia para ver si reconstruye el número original.

## Análisis de Principios de Diseño de Software

Este proyecto ha sido desarrollado con un enfoque en escribir código limpio y mantenible, adhiriéndose a principios clave de ingeniería de software.

### Modularidad

La solución es altamente modular, con una clara separación de preocupaciones:

- **Estructura de Paquetes**: El código está organizado en paquetes distintos (`a` para la Parte 1, `b` para la Parte 2) para mantener las soluciones independientes mientras comparten una estructura similar.
- **Separación de Clases**: Clases distintas manejan tareas específicas. Por ejemplo, `FileInstructionReader` maneja la entrada/salida, mientras que `Range` y `PatternValidator` manejan la lógica del dominio. Esto hace que el código sea más fácil de navegar y probar.

### Principio de Responsabilidad Única (SRP)

Cada clase tiene un propósito único y bien definido:

- **`FileInstructionReader`**: Su **única** responsabilidad es leer y analizar el archivo de entrada. No sabe sobre IDs inválidos o matemáticas; solo proporciona los datos crudos.
- **`PatternValidator` (Parte 2)**: Esta clase es puramente responsable de la lógica algorítmica de comprobar secuencias repetidas. Está desacoplada del objeto `Range` en sí.
- **`Range`**: Representa los datos de un rango numérico. En la Parte 2, delega la lógica de validación compleja a `PatternValidator`, actuando principalmente como un contenedor de datos y coordinador para sus valores de rango específicos.
- **`Main`**: Actúa como el orquestador. Une el lector, los objetos de datos y la salida, sin contener la lógica de negocio en sí misma.

## Autor

Proyecto creado para la asignatura de Ingeniería de Software.
