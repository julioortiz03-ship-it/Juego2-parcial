package modelo;

public class Catedratico extends Pieza {
    private int radioEfecto;
    private String curso;

    public Catedratico(String id, String nombre, int x, int y, int puntosEstabilidad, int radioEfecto, String curso) {
        super(id, nombre, x, y, puntosEstabilidad);
        this.radioEfecto = radioEfecto;
        this.curso = curso;
    }

    public Catedratico(String id, String nombre, int x, int y, String curso) {
        this(id, nombre, x, y, 100, 2, curso);
    }

    @Override
    public String ejecutarTurno() {
        return "Prof. " + nombre + " (" + curso + ") patrulla con radio de efecto " + radioEfecto + " y asigna proyectos sorpresa.";
    }

    @Override
    public String getTipo() {
        return "Catedratico";
    }

    public void asignarProyecto(Estudiante estudiante) {
        estudiante.modificarEstabilidad(-10);
        estudiante.setEstres(estudiante.getEstres() + 20);
    }

    public void asignarProyecto(Estudiante estudiante, int impactoExtra) {
        estudiante.modificarEstabilidad(-10 - impactoExtra);
        estudiante.setEstres(estudiante.getEstres() + 20 + impactoExtra);
    }

    public int getRadioEfecto() {
        return radioEfecto;
    }

    public void setRadioEfecto(int radioEfecto) {
        this.radioEfecto = radioEfecto;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return super.toString() + ", Curso: " + curso + ", Radio AoE: " + radioEfecto;
    }
}
