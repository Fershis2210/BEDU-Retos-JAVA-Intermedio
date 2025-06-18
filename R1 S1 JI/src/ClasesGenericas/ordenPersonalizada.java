package ClasesGenericas;

public class ordenPersonalizada extends ordenProduccion {
    private final String cliente;

    public ordenPersonalizada (String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    public String getCliente() { return cliente; }

    @Override
    public void mostrarResumen() {
        System.out.println ("ordenPersonalizada - Código: " + getCodigo() +
                " - Cantidad: " + getCantidad() +
                " - Cliente " + cliente);
    }
}
