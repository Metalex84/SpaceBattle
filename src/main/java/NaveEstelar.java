public class NaveEstelar implements Runnable {

    /*
    * Cada nave queda definida por su posición y por su nombre
    * */
    private int posicion;
    private final String nombre;

    /*
    * Constructor
    * */
    public NaveEstelar (String nombre) {
        this.nombre = nombre;
        this.posicion = 0;
    }
    /*
    * getters
    * */
    public int getPosicion() {
        return this.posicion;
    }

    public String getNombre() {
        return this.nombre;
    }
    /*
    * El bloque concurrente
    * */
    public synchronized void Avanzar () {
        // Presupongo avances entre 1 y 5 metros
        int metros = (int) (Math.random() * 5) + 1;
        // Avanzo la posicion de la nave tantos metros como diga el aleatorio anterior
        posicion += metros;
    }

    /*
    * En el metodo 'run', llamo 200 veces a cada 'Avanzar()'
    * */
    @Override
    public void run() {
        for (int i = 1; i <= 200; i++) {
            Avanzar();
            System.out.println("Nave " + nombre + ": Tirada " + i + " - He avanzado " + posicion + " metros!" );
            // Espero 20 milisegundos antes de ir a la siguiente tirada
            try {
                Thread.sleep(20);
            } catch (InterruptedException ie) {
                System.err.println(ie.getMessage());
            }
        }
        System.out.println("Nave " + nombre + ": Batalla espacial concluida");
    }
}
