package modelo;

public class Recurso extends Pieza {
    protected int durabilidad;

    public Recurso(String id, String nombre, int x, int y, int puntosEstabilidad, int durabilidad) {
        super(id, nombre, x, y, puntosEstabilidad);
        this.durabilidad = durabilidad;
    }

    public Recurso(String id, String nombre, int durabilidad) {
        this(id, nombre, 0, 0, 50, durabilidad);
    }

    @Override
    public String ejecutarTurno() {
        return nombre + " disponible con " + durabilidad + " usos restantes.";
    }

    @Override
    public String getTipo() {
        return "Recurso";
    }

    public void usar() {
        if (durabilidad > 0) {
            durabilidad--;
        }
    }

    public void usar(int cantidad) {
        durabilidad = Math.max(0, durabilidad - cantidad);
    }

    public int getDurabilidad() {
        return durabilidad;
    }

    public void setDurabilidad(int durabilidad) {
        this.durabilidad = durabilidad;
    }

    @Override
    public String toString() {
        return super.toString() + ", Usos restantes: " + durabilidad;
    }
}
