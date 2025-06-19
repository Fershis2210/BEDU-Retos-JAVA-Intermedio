package programacionFuncional;

import java.util.Optional;

public class pedido {
    private final String cliente;
    private final String tipoEntrega;
    private final String telefono;

    public pedido (String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    public String getCliente() {return cliente; }
    public String getTipoEntrega() {return tipoEntrega; }

    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }
}
