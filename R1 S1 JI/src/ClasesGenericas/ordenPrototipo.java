package ClasesGenericas;

public class ordenPrototipo extends ordenProduccion {
    private final String faseDesarrollo;

    public ordenPrototipo (String codigo, int cantidad, String faseDesarrollo) {
        super(codigo, cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }

    public String getFaseDesarrollo() { return faseDesarrollo; }

    @Override
    public void mostrarResumen() {
        System.out.println("OrdenPrototipo - Código " + getCodigo() +
                " - Cantidad: " + getCantidad() +
                " - Fase: " + faseDesarrollo);
    }
}
