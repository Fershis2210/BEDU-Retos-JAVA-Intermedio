package hospital;

public class profesional  implements Runnable {

    private final String nombre;
    private final recursoMedico recurso;

    public profesional(String nombre, recursoMedico recurso) {
        this.nombre = nombre;
        this.recurso = recurso;
    }

    @Override
    public void run() {
        recurso.usar(nombre);
    }
}
