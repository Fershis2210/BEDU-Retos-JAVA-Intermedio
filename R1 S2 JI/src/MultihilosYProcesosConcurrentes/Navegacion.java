package MultihilosYProcesosConcurrentes;

import java.util.concurrent.Callable;

public class Navegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Navegación: Trayectoría corregida con éxito.";
    }
}
