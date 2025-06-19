package hospital;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando simulación de acceso al recurso...");

        recursoMedico salaCirugia = new recursoMedico ("Sala de cirugía");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new profesional("Dra. Sánchez", salaCirugia));
        executor.submit(new profesional("Dr. Gómez", salaCirugia));
        executor.submit(new profesional("Enfermero López", salaCirugia));
        executor.submit(new profesional("Dra. Ruiz", salaCirugia));

        executor.shutdown();
    }
}