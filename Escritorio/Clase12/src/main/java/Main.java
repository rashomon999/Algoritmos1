import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        int[] valores = {1, 3, 5, 5, 5, 7, 9, 12};
        ArrayList<Integer> resultado = buscarBinario(5, valores);
        System.out.println(resultado);
    }

    public static ArrayList<Integer> buscarBinario(int valor, int[] valores) {
        ArrayList<Integer> posiciones = new ArrayList<>();
        int inicio = 0;
        int fin = valores.length - 1;


        int primeraAparicion = -1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (valores[medio] == valor) {
                primeraAparicion = medio;
                fin = medio - 1;
            } else if (valores[medio] > valor) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }



        posiciones.add(primeraAparicion);

        inicio = 0;
        fin = valores.length - 1;
        int ultimaAparicion = -1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (valores[medio] == valor) {
                ultimaAparicion = medio;
                inicio = medio + 1;
            } else if (valores[medio] > valor) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }


        posiciones.add(ultimaAparicion);

        return posiciones;
    }
}


