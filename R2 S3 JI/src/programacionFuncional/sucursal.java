package programacionFuncional;

import java.util.List;

public class sucursal {
    private final String nombre;
    private final List<encuesta> encuestas;

    public sucursal (String nombre, List<encuesta> encuestas) {
        this.nombre = nombre;
        this.encuestas = encuestas;
    }

    public String getNombre() { return nombre; }
    public List<encuesta> getEncuestas() { return encuestas; }
}
