package MultihilosYProcesosConcurrentes;

import java.util.concurrent.Callable;

public class controlTermico implements Callable<String> {
    @Override
    public String call() throws Exception{
        Thread.sleep(1100);
        return "Control térmico: temperatura estable (22°C).";
    }
}
