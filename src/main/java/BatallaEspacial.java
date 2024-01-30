public class BatallaEspacial {

    /*
     * Método estático para calcular el ganador de la batalla
     * */
    private static String calcularGanador (NaveEstelar n1, NaveEstelar n2) {
        if (n1.getPosicion() > n2.getPosicion())
            return n1.getNombre();
        else if (n1.getPosicion() < n2.getPosicion())
            return n2.getNombre();
        else
            return null;
    }
    public static void main(String[] args) {

        // 1. Instancio cada nave dándole su nombre
        NaveEstelar nave1 = new NaveEstelar("Zorg");
        NaveEstelar nave2 = new NaveEstelar("Blip");

        // 2. Creo los dos hilos, uno por cada nave
        Thread t1 = new Thread(nave1);
        Thread t2 = new Thread(nave2);

        // 3. Llamo a sus respectivos 'run'
        t1.start();
        t2.start();

        // 4. Hago que los hilos se esperen entre sí
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ie) {
            System.err.println(ie.getMessage());
        }

        // 5. Compruebo cómo ha terminado la batalla
        String ganador = calcularGanador(nave1, nave2);
        if (ganador != null)
            System.out.println("Esta batalla la ha ganado Nave " + ganador);
        else
            System.out.println("Esta batalla ha terminado en empate.");
    }
}


