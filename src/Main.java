import modelo.Catedratico;
import modelo.Estudiante;
import modelo.Pieza;
import modelo.Recurso;

public class Main {
    public static void main(String[] args) {
        Pieza estudiante = new Estudiante("E1", "Carlos", 2, 3, "Sistemas");
        Pieza catedratico = new Catedratico("C1", "Dr. Perez", 2, 4, "POO");
        Pieza recurso = new Recurso("R1", "Proyector", 5);

        System.out.println(estudiante);
        System.out.println(catedratico);
        System.out.println(recurso);

        System.out.println(estudiante.ejecutarTurno());
        System.out.println(catedratico.ejecutarTurno());
        System.out.println(recurso.ejecutarTurno());
    }
}
