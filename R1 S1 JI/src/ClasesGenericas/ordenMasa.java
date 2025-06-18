package ClasesGenericas;

public class ordenMasa extends ordenProduccion {
    public ordenMasa(String codigo, int cantidad) {
        super(codigo, cantidad);
    }

    @Override
    public void mostrarResumen() {
        System.out.println("ordenMasa - Código: " + getCodigo() + " - Cantidad: " + getCantidad());
    }
}
