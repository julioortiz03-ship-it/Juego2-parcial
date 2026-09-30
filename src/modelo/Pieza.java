package modelo;

public abstract class Pieza implements Comparable<Pieza> {
    protected String id;
    protected String nombre;
    protected int x;
    protected int y;
    protected int puntosEstabilidad;

    public Pieza(String id, String nombre, int x, int y, int puntosEstabilidad) {
        this.id = id;
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.puntosEstabilidad = puntosEstabilidad;
    }

    public Pieza(String id, String nombre, int puntosEstabilidad) {
        this(id, nombre, 0, 0, puntosEstabilidad);
    }

    public abstract String ejecutarTurno();

    public abstract String getTipo();

    public void mover(int nuevoX, int nuevoY) {
        this.x = nuevoX;
        this.y = nuevoY;
    }

    public void mover(int deltaX, int deltaY, boolean relativo) {
        if (relativo) {
            this.x += deltaX;
            this.y += deltaY;
        } else {
            mover(deltaX, deltaY);
        }
    }

    public void modificarEstabilidad(int delta) {
        this.puntosEstabilidad += delta;
        if (this.puntosEstabilidad < 0) {
            this.puntosEstabilidad = 0;
        }
    }

    public void modificarEstabilidad(int delta, String razon) {
        modificarEstabilidad(delta);
    }

    @Override
    public int compareTo(Pieza otra) {
        if (otra == null) return 1;
        int comp = Integer.compare(this.puntosEstabilidad, otra.puntosEstabilidad);
        if (comp != 0) return comp;
        return this.nombre.compareToIgnoreCase(otra.nombre);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPuntosEstabilidad() {
        return puntosEstabilidad;
    }

    public void setPuntosEstabilidad(int puntosEstabilidad) {
        this.puntosEstabilidad = Math.max(0, puntosEstabilidad);
    }

    @Override
    public String toString() {
        return "[" + getTipo() + "] ID: " + id + ", Nombre: " + nombre + ", Pos: (" + x + ", " + y + "), Estabilidad: " + puntosEstabilidad;
    }
}
