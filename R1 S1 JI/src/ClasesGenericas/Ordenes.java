package ClasesGenericas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Ordenes {

    //Cualquier tipo de orden
    public static void mostrarOrdenes(List<? extends ordenProduccion> lista) {
        System.out.println("Órdenes registradas: ");
        for (ordenProduccion orden : lista) {
            orden.mostrarResumen();
        }
        System.out.println();
    }

    //Orden personalizada
    public static void procesarPersonalizada (List<? super ordenPersonalizada> lista, int costoAdicional) {
    System.out.println("Procesado órden personalizada... ");
    for (Object obj : lista) {
        if (obj instanceof ordenPersonalizada) {
            ordenPersonalizada op = (ordenPersonalizada) obj;
            System.out.println("Órden " + op.getCodigo() + "ajustada de costo adicional de $ " + costoAdicional + " MX.");
            }
        }
    }

    //Contador de ordenes (de cada tipo)
    public static void contarOrdenes (List<? extends ordenProduccion>... listas){
        int masa = 0, personalizada = 0, prototipo = 0;
        for (List<? extends ordenProduccion> lista : listas) {
            for (ordenProduccion orden : lista) {
                if (orden instanceof ordenMasa) masa++;
                else if (orden instanceof ordenPersonalizada) personalizada++;
                else if (orden instanceof ordenPrototipo) prototipo++;
            }
        }
        System.out.println("Resumen total de órdenes: ");
        System.out.println("Producción en masa: " + masa);
        System.out.println("Personalizadas: " + personalizada);
        System.out.println("Prototipos: " + prototipo);
    }

    //Main
    public static void main(String[] args) {
        List<ordenMasa> ordenMasas = Arrays.asList(
                new ordenMasa(" A123 ", 500),
                new ordenMasa(" A124 ", 750)
        );

        List<ordenPersonalizada> ordenPersonalizadas = Arrays.asList(
                new ordenPersonalizada(" P456 ", 100, " ClienteX" ),
                new ordenPersonalizada(" P789 ", 150, " ClienteY ")
        );

        List<ordenPrototipo> ordenesPrototipo = Arrays.asList(
                new ordenPrototipo(" T789 ", 10, " Diseño "),
                new ordenPrototipo(" T790 ", 5, " Pruebas ")
        );

        //Todas las ordenes
        Ordenes.mostrarOrdenes(ordenMasas);
        Ordenes.mostrarOrdenes(ordenPersonalizadas);
        Ordenes.mostrarOrdenes(ordenesPrototipo);

        //Costo adicional
        Ordenes.procesarPersonalizada(new ArrayList<>(ordenPersonalizadas), 200);

        //Contador
        Ordenes.contarOrdenes(ordenMasas, ordenPersonalizadas, ordenesPrototipo);
    }
}
