# Ejercicio: Problema de los Fumadores y el Estanquero (Versión Simplificada)

## Descripción
Este programa en Java simula el clásico problema de sincronización de los fumadores y el estanquero utilizando hilos (`Thread`), con comunicación y control mediante `synchronized`, `wait()` y `notifyAll()`.

Tres fumadores y un estanquero interactúan en una mesa donde solo pueden aparecer dos ingredientes a la vez. Cada fumador dispone de un ingrediente propio en cantidad infinita y espera que el estanquero ponga en la mesa los otros dos para poder fabricar y fumar un cigarrillo.

## Clases Principales

### Mesa
- Monitor sincronizado que controla la disponibilidad de ingredientes.
- Solo puede estar ocupada con dos ingredientes a la vez.
- Métodos sincronizados para que el estanquero ponga ingredientes, y para que los fumadores esperen y recojan sus ingredientes.
- Controla cuándo el sistema se cierra para terminar la ejecución adecuada de los hilos.

### Estanquero (Thread)
- Cada cierto tiempo, en bucle, coloca dos ingredientes diferentes en la mesa.
- Notifica a los fumadores al poner los ingredientes.
- Repite el proceso un número limitado de veces (15 en esta implementación).
- Al terminar, indica que no pondrá más ingredientes y cierra la mesa.

### Fumador (Thread)
- Cada fumador está asociado a un ingrediente que posee infinitamente.
- Espera a que la mesa tenga los otros dos ingredientes que necesita para hacer un cigarro.
- Cuando puede, recoge los ingredientes, simula liar y fumar un cigarro con pausas aleatorias.
- Finaliza cuando el estanquero cierra la mesa.

### Lanzador (main)
- Crea la mesa, el estanquero y los tres fumadores.
- Arranca los hilos y espera a que el estanquero termine.
- Interrumpe a los fumadores para terminar el programa ordenadamente.

## Ejecución y Salida Ejemplo

## Conceptos y Técnicas
- Sincronización con `synchronized`, `wait()` y `notifyAll()`
- Comunicación entre hilos para acceso exclusivo a recursos compartidos (la mesa)
- Evita condiciones de carrera y deadlocks
- Uso de interrupciones para finalizar hilos ordenadamente

## Consideraciones
- La mesa solo tiene dos ingredientes a la vez.
- Un fumador solo actúa cuando los ingredientes en mesa son los que él necesita.
- El estanquero trabaja hasta colocar un número limitado de ingredientes.

## Cómo compilar y ejecutar

## Autor
- Código desarrollado como solución para ejercicio de sincronización en Java.

----

Este programa es una implementación funcional y didáctica del problema de sincronización clásico que demuestra el uso correcto de primitivas de sincronización Java para evitar condición de carrera y sincronizar acciones entre varios hilos.
