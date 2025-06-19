package programacionFuncional;

import java.util.*;

public class procesadorEncuestas {

    public static void main(String[] args) {

        List<sucursal> sucursales = List.of(
                new sucursal("Centro", List.of(
                       new encuesta("Ana", "El tiempo de espera fue largo.", 2),
                        new encuesta("Luis", null, 5)
                )),
                new sucursal("Norte", List.of(
                        new encuesta("Marta", "La atencion fue buena, pero la limpieza puede mejorar", 3),
                        new encuesta("Pedro", null, 5)
                )),
                new sucursal("Sur", List.of(
                        new encuesta("Carlos", null, 2),
                        new encuesta("Sofia", "No encontré el medicamento que necesitaba", 1)
                ))
        );

        System.out.println("Seguimiento de pacientes insatisfechos");

        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(e -> e.getCalificacion() <= 3)
                                .map(encuesta -> new seguimiento(encuesta, sucursal.getNombre()))
                )
                .filter(seg -> seg.encuesta().getComentario().isPresent())
                .map(seg -> {
                    String comentario = seg.encuesta().getComentario().get();
                    return "Sucursal " + seg.sucursal() +
                            " : Seguimiento a paciente con comentario: \"" + comentario + "\"";
                })
                .forEach(System.out::println);
    }
    record seguimiento(encuesta encuesta, String sucursal){
    }
}
