package MultihilosYProcesosConcurrentes;

 import MultihilosYProcesosConcurrentes.soporteVital;
 import MultihilosYProcesosConcurrentes.controlTermico;
 import MultihilosYProcesosConcurrentes.Comunicaciones;
 import MultihilosYProcesosConcurrentes.Navegacion;

 import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.printf("Simulación de misión espacial iniciada...");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<String> nav = executor.submit(new Navegacion());
        Future<String> vital = executor.submit(new soporteVital());
        Future<String> com = executor.submit(new Comunicaciones());
        Future<String> termico = executor.submit(new controlTermico());

        System.out.println(nav.get());
        System.out.println(vital.get());
        System.out.println(com.get());
        System.out.println(termico.get());

        executor.shutdown();
        System.out.println("Todos los sistemas reportan estado operativo.");
    }
}