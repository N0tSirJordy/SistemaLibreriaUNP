# SistemaLibreriaUNP

Sistema básico de gestión de préstamos de libros desarrollado en Java como proyecto académico.  
Permite registrar libros en memoria, prestar ejemplares a usuarios y procesar devoluciones con cálculo de multas por retraso.

---

## Descripción general

El sistema simula el funcionamiento de una biblioteca mediante una aplicación de consola.  
Está diseñado para:

- Registrar un conjunto de libros en un arreglo.
- Permitir que un usuario solicite un libro.
- Verificar si el libro se encuentra disponible.
- Cambiar el estado del libro entre "Disponible" y "Prestado".
- Procesar devoluciones aplicando multas por demora.

El programa está compuesto por cuatro clases principales:

- Libro  
- Usuario  
- Prestamo  
- Main  

---

## Estructura del proyecto

SistemaLibreriaUNP/
│
├── Libro.java  
├── Usuario.java  
├── Prestamo.java  
└── Main.java  

---

## Explicación de Clases

### Clase Libro

Representa un libro dentro de la biblioteca.

Atributos:

- nombre  
- autor  
- editorial  
- codigo  
- estado: puede ser "Disponible" o "Prestado"

Responsabilidades:

- Almacenar la información de cada libro.
- Permitir la consulta y modificación de sus datos mediante métodos get y set.
- Controlar el estado del libro durante los procesos de préstamo y devolución.

---

### Clase Usuario

Representa a la persona que solicita un libro.

Atributos:

- nombre_Alum  
- dni  

Responsabilidades:

- Guardar los datos básicos del usuario.
- Permitir acceder a la información mediante métodos get.

---

### Clase Prestamo

Gestiona la información relacionada con un préstamo de libro.

Características:

- Asigna automáticamente una fecha límite de devolución de 15 días a partir del día actual.
- Muestra un ticket con los datos del préstamo.
- Calcula multas en caso de retraso.

Reglas de multa:

- Se cobra 0.50 soles por cada día de retraso.
- Si el libro se entrega antes o en la fecha límite, no se aplica cobro.

---

### Clase Main

Contiene la lógica principal del sistema y la interacción con el usuario.

Funciones principales:

- Mostrar el menú de opciones.
- Registrar un conjunto de libros utilizando arreglos.
- Solicitar datos del usuario.
- Buscar libros dentro del arreglo.
- Procesar préstamos y devoluciones.

El sistema trabaja con un arreglo de objetos Libro que representa la biblioteca durante la ejecución del programa.

---

## Flujo del programa

1. El encargado registra una cantidad determinada de libros.  
2. Un usuario ingresa su nombre y DNI.  
3. El usuario indica el libro que desea.  
4. El sistema busca el libro en el arreglo:
   - Si está disponible, se realiza el préstamo y se muestra un ticket.
   - Si está prestado, se informa que no se puede entregar.  
5. En la devolución se verifica la fecha:
   - Si hay retraso, se calcula la multa.
   - Si no hay retraso, se confirma la entrega a tiempo.

---

## Ejecución

### Requisitos

- Java JDK 8 o superior  
- Cualquier IDE compatible con Java o consola del sistema

### Compilación por consola

javac *.java  
java Main  

---

## Validaciones y consideraciones

- El sistema depende de que primero se registren los libros antes de realizar préstamos.  
- La búsqueda del libro se realiza comparando el título ingresado con los almacenados en el arreglo.  
- El estado del libro cambia automáticamente al prestar o devolver.

---

## Mejoras recomendadas

- Agregar opción para mostrar todos los libros registrados.  
- Permitir búsqueda por código además del título.  
- Incorporar almacenamiento permanente en archivos o base de datos.  

---

## Autor

Proyecto académico – SistemaLibreriaUNP  
Desarrollado en Java.
