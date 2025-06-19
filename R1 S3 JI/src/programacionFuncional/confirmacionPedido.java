package programacionFuncional;

import java.util.*;
import java.util.stream.*;

public class confirmacionPedido {
    public static void main(String[] args) {
        List<pedido> pedidos = List.of(
                new pedido("Juan", "domicilio", "555-1234"),
                new pedido("María", "local", null),
                new pedido("Carlos", "domicilio", null),
                new pedido("Luisa", "domicilio", "555-5678")
        );

        List<String> mensajes = pedidos.stream()
                .filter(pedido -> pedido.getTipoEntrega().equalsIgnoreCase("domicilio"))
                .map(pedido::getTelefono)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(tel -> " Confirmación enviada al número: " + tel)
                .toList();

        System.out.println("Confirmaciones de pedidos a domicilio: ");
        mensajes.forEach(System.out::println);
    }
}