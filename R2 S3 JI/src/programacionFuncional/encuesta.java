package programacionFuncional;

import java.util.Optional;

public class encuesta {
    private final String paciente;
    private final String comentario;
    private final int calificacion;

    public encuesta(String paciente, String comentario, int calificacion) {
        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public int getCalificacion() { return calificacion; }

    public Optional<String> getComentario() {
        return Optional.ofNullable(comentario);
    }
}
