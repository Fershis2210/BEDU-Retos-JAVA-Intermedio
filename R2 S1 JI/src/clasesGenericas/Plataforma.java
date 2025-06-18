package clasesGenericas;

import java.util.*;
import java.util.function.Predicate;

public class Plataforma {

    public static void mostrarMateriales(List<? extends materialCurso> lista) {
        System.out.printf("Materiales del curso: ");
        for (materialCurso material: lista) {
           material.mostrarDetalle();
        }
    }

    public static void duracionVideo(List<? extends Video> lista) {
        int total = 0;
        for (Video v : lista ) {
            total += v.getDuracion();
        }
        System.out.println("Duración total de videos: " + total + " minutos.");
    }

    public static void ejerciciosRevisados(List<? super ejercicio> lista) {
        System.out.println();
        for (Object obj : lista) {
            if (obj instanceof ejercicio) {
                ejercicio e = (ejercicio) obj;
                e.setRevisado(true);
                System.out.println("Ejercicio: " + e.getTitulo() + " - revisado.");
            }
        }
    }

    public static void filtroAutor (List<? extends materialCurso>lista, Predicate<materialCurso> filtro) {
        System.out.println("Filtrando materiales por autor...");
        for (materialCurso material : lista) {
            if (filtro.test(material)) {
                material.mostrarDetalle();
            }
        }
    }

    public static void main(String[] args) {
        List<materialCurso> materiales = Arrays.asList(
                new Video("Introduccion a Java", "Mario", 15),
                new Video("POO en Java", "Carlos", 20),
                new articulo("Historia de Java", "Ana", 1200),
                new articulo("Tipos de datos","Luis", 800),
                new ejercicio("Variables y tipos","Luis"),
                new ejercicio("Condicionales", "Mario")
        );

        List<Video> videos = new ArrayList<>();
        List<ejercicio> ejercicios= new ArrayList<>();
        for (materialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            } else if (m instanceof ejercicio){
                ejercicios.add((ejercicio) m);
            }
        }

        mostrarMateriales(materiales);
        duracionVideo(videos);
        ejerciciosRevisados(ejercicios);
        filtroAutor(materiales, m -> m.getAutor().equals("Ana"));
    }
}
















