# **Gestor_Bibliotecas**

##**Integrantes:** 

- Jaider Alejandro Muñoz Ortega
- Jose Antonio Mogollon

**Descripcion:**
El proyecto se basa en un gestor de bibliotecas creado en java el cual nos permite gestionar el inventario de una biblioteca mediante el registro de libros con su titulo, autor y categoria, el registro de usuarios con su nombre, email y telefono el cual le permite realizar prestamos y devoluciones de libros a la vez que puede consultar la disponibilidad de estos.

**Tabla de contenido:**

1. Instalacion
2. Funciones
3. Uso

**Instalacion**

Para instalar este proyecto clona el repositorio en el git de tu terminal, una vez clonado abre el proyecto desde el IDE de tu preferencia, ejecuta el proyecto y listo.

**Funciones**

El proyecto esta dividido en 7 clases:

- Biblioteca:
- Categoria: Enumera los tipos de categoria
- ElementoBiblioteca: clase para establecer la base de un libro para su gestion como su titulo y si esta disponible o no
- Libro: Representa un libro con sus atributos
- Prestable: Interfaz para definir los metodos para información sobre los préstamos de libros 
- Usuario: Representa a un usuario de la biblioteca
- InterfazGrafica: Define y maneja la interfaz gráfica

**Uso**

Una vez abierto el proyecto en tu IDE el proyecto se ejecuta desde la clase InterfazGrafica el cual abrira un panel en el quue en la parte derecha estaran las funcionalidades para gestionar la biblioteca, veras un area para escribir el titulo, autor y una lista de categorias para registrar el libro y mas abajo hay una area para registrar los usuarios con su nombre, correo y telefono tambien se encuentran botones que permiten prestar, devolver y consultar la disponibilidad de los libros, todo este registro aparecera en un area que ocupa casi todo el panel, este panel solo es para mostrar los registros y no se puede editar su texto.
