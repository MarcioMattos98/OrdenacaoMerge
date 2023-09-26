package merge;

import java.util.Arrays;
import java.util.Random;
public class Merge {

    public static void main(String[] args) {
        Random gerador = new Random();
        int tamanho = 1000;
        
        int v[] = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            v[i] = gerador.nextInt(1001);
        }
        int w[] = new int[v.length];

        mergeSort(v, w, 0, v.length - 1);
        for (int i = 0; i < tamanho; i++) {
            System.out.println(v[i]);
        }
        
    }

    private static void mergeSort(int[] v, int[] w, int ini, int fim) {
        if (ini < fim) {
            int meio = (ini + fim) / 2;
            mergeSort(v, w, ini, meio);
            mergeSort(v, w, meio + 1, fim);
            intercalar(v, w, ini, meio, fim);
        }
    }

    private static void intercalar(int[] v, int[] w, int ini, int meio, int fim) {
        for (int k = ini; k <= fim; k++) {
            w[k] = v[k];
        }
        int i = ini;
        int j = meio + 1;
        for (int k = ini; k <= fim; k++) {
            if (i > meio) {
                v[k] = w[j++];
            } else if (j > fim) {
                v[k] = w[i++];
            } else if (w[i] < w[j]) {
                v[k] = w[i++];
            } else {
                v[k] = w[j++];
            }
        }
    }

}
