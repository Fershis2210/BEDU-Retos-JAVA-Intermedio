package procesosAsincronos;

import javax.swing.text.StyledEditorKit;
import java.util.concurrent.*;
import java.util.Random;

public class controlAeropuerto {

    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.printf("Verificando candiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pistaFuture = verificarPista();
        CompletableFuture<Boolean> climaFuture = verificarClima();
        CompletableFuture<Boolean> traficoFuture = verificarTrafico();
        CompletableFuture<Boolean> personalFuture = verificarPersonal();

        CompletableFuture<Void> controlAterrizaje = CompletableFuture.allOf(pistaFuture, climaFuture, traficoFuture, personalFuture)
                .thenAccept(v -> {
                    try {
                        boolean pista = pistaFuture.get();
                        boolean clima = climaFuture.get();
                        boolean trafico = traficoFuture.get();
                        boolean personal = personalFuture.get();

                        if (pista && clima && trafico && personal) {
                            System.out.println("\n Aterrizaje autorizado: todas las condiciones óptimas.");
                        } else {
                            System.out.println("\n Aterrizaje denegado: condiciones no óptimas.");
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("\n Error en la evaluación de condiciones: " + e.getMessage());
                    }
                })
                .exceptionally(ex -> {
                    System.out.println("\n Error en el proceso de aterrizaje " + ex.getMessage());
                    return null;
                });

        controlAterrizaje.join();
    }

    public static CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Verificando pista...");
            dormir(2);
            boolean disponible = random.nextInt(100) < 80;
            System.out.println("Pista disponible: " + disponible);
            return disponible;
        });
    }

    public static CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Verificando clima...");
            dormir(3);
            boolean bueno = random.nextInt(100) < 90;
            System.out.println("Clima favorable: " + bueno);
            return bueno;
        });
    }

    public static CompletableFuture<Boolean> verificarTrafico() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Verificando tráfico aéreo...");
            dormir(1);
            boolean libre = random.nextInt(100) < 90;
            System.out.println("Trafico aéreo despejado: " + libre);
            return libre;
        });
    }

    public static CompletableFuture<Boolean> verificarPersonal(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Verificando personal en tierra...");
            dormir(2);
            boolean disponible = random.nextInt(100) < 90;
            System.out.println("Personal disponible: " + disponible);
            return disponible;
        });
    }
    public static void dormir(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
































