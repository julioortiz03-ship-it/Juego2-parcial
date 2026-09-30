package modelo;

public class Estudiante extends Pieza {
    private int energia;
    private int estres;
    private String carrera;

    public Estudiante(String id, String nombre, int x, int y, int puntosEstabilidad, int energia, int estres, String carrera) {
        super(id, nombre, x, y, puntosEstabilidad);
        this.energia = energia;
        this.estres = estres;
        this.carrera = carrera;
    }

    public Estudiante(String id, String nombre, int x, int y, String carrera) {
        this(id, nombre, x, y, 100, 80, 20, carrera);
    }

    @Override
    public String ejecutarTurno() {
        this.energia -= 5;
        this.estres += 5;
        return nombre + " busca cafe por el campus. Energia: " + energia + ", Estres: " + estres;
    }

    @Override
    public String getTipo() {
        return "Estudiante";
    }

    public void descansar() {
        this.energia += 15;
        this.estres -= 10;
    }

    public void descansar(int horas) {
        this.energia += horas * 10;
        this.estres -= horas * 5;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getEstres() {
        return estres;
    }

    public void setEstres(int estres) {
        this.estres = estres;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return super.toString() + ", Carrera: " + carrera + ", Energia: " + energia + ", Estres: " + estres;
    }
}
