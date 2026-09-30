Diseño general

El campus se representa con un tablero cuadriculado en memoria donde se colocan distintos tipos de piezas. El diseño usa herencia, polimorfismo, sobrecarga de métodos y constructores, y el patrón MVC, con tres paquetes (modelo, vista y controlador) y la clase Main fuera de ellos.

Capa Modelo

Pieza es la clase abstracta base e implementa Comparable(pieza)
para ordenar por puntos de estabilidad. Tiene los atributos id, nombre, x, y y puntosEstabilidad, un constructor completo y otro que usa una posición por defecto. Sus métodos abstractos son ejecutarTurno() y getTipo(), y tiene dos métodos sobrecargados: mover(nuevoX, nuevoY) junto con mover(deltaX, deltaY, relativo), y modificarEstabilidad(delta) junto con modificarEstabilidad(delta, razon). También incluye compareTo(), getters, setters y toString().

De Pieza heredan tres clases. Estudiante tiene energía y estrés (ambos de 0 a 100) y una carrera; su ejecutarTurno() baja la energía y sube el estrés, y tiene descansar() y descansar(int horas) sobrecargados. Catedratico tiene radioEfecto y curso; su turno afecta a los estudiantes dentro de su radio, y tiene asignarProyecto(est) y asignarProyecto(est, impactoExtra). Recurso tiene durabilidad y su turno muestra el estado y la disponibilidad; tiene usar() y usar(int cantidad). MaquinaCafe hereda de Recurso, tiene tipoCafe y su método interactuar(Estudiante e) recupera energía, reduce estrés y consume un uso.

Tablero administra el campus con filas, columnas y una lista polimórfica piezaguarda estudiantes, catedráticos y recursos juntos. Su método cargarPiezasIniciales() crea al menos 10 piezas de distintos tipos, buscarPieza() está sobrecargado para buscar por id o por nombre, obtenerPiezasOrdenadasPorEstabilidad() ordena usando Comparable y ejecutarTurnoCampus() recorre todas las piezas y llama a ejecutarTurno() de cada una.

Capa Vista

CampusView se encarga solo de la consola, sin lógica de juego. Muestra el menú, la lista de piezas, el detalle de una pieza y el mapa del tablero, y pide texto y enteros al usuario.

Capa Controlador

CampusController tiene un Tablero y una CampusView. Su método iniciar() mantiene el ciclo del menú y sus métodos privados atienden cada opción (listar, buscar, ordenar, mostrar el mapa y ejecutar turnos): reciben la opción, operan sobre el Tablero y envían el resultado a la Vista.

Driver Program

Main crea el Tablero, la vista y el controlador, y llama a iniciar().

Polimorfismo, sobrecarga y MVC

El polimorfismo se aplica con ejecutarTurno(): el Tablero no necesita saber qué tipo de pieza recorre, solo llama al método y Java ejecuta la versión que corresponde a cada objeto. La sobrecarga se aplica en mover, modificarEstabilidad, descansar, asignarProyecto, usar, buscarPieza y en los constructores. Con esto se cumplen los requisitos del ejercicio: herencia, polimorfismo, sobrecarga, Comparable para ordenar y separación del programa con MVC.