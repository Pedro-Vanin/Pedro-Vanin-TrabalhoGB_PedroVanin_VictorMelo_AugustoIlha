package trabalhoSorts;

import java.util.Arrays;
import java.util.Random;

public class SortsTeste {

    public static void main(String[] args) {
        int[] tamanhos = {128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536};
        Random random = new Random();

        for (int tamanho : tamanhos) {
            int[] array = new int[tamanho];

            // Array em ordem crescente
            for (int i = 0; i < tamanho; i++) {
                array[i] = i;
            }
            testarSorts(array, tamanho, "Array em ordem crescente");

            // Array em ordem decrescente
            for (int i = 0; i < tamanho; i++) {
                array[i] = tamanho - i;
            }
            testarSorts(array, tamanho, "Array em ordem decrescente");

            // Array aleat贸rio sem valores repetidos
            for (int i = 0; i < tamanho; i++) {
                array[i] = i;
            }
            embaralharArray(array);
            testarSorts(array, tamanho, "Array aleat贸rio sem valores repetidos");

            // Array aleat贸rio com valores repetidos
            for (int i = 0; i < tamanho; i++) {
                array[i] = random.nextInt(tamanho / 2);
            }
            testarSorts(array, tamanho, "Array aleat贸rio com valores repetidos");
        }
    }

    private static void testarSorts(int[] array, int tamanho, String tipoArray) {
        int[] copy;

        copy = Arrays.copyOf(array, array.length);
        medirTempo(copy, Sorts::bubbleSort, "Bubble Sort", tipoArray, tamanho);

        copy = Arrays.copyOf(array, array.length);
        medirTempo(copy, Sorts::insertionSort, "Insertion Sort", tipoArray, tamanho);

        copy = Arrays.copyOf(array, array.length);
        medirTempo(copy, Sorts::selectionSort, "Selection Sort", tipoArray, tamanho);

        copy = Arrays.copyOf(array, array.length);
        medirTempo(copy, Sorts::heapSort, "Heap Sort", tipoArray, tamanho);

        copy = Arrays.copyOf(array, array.length);
        medirTempo(copy, Sorts::shellSort, "Shell Sort", tipoArray, tamanho);

        copy = Arrays.copyOf(array, array.length);
        medirTempo(copy, Sorts::mergeSort, "Merge Sort", tipoArray, tamanho);

        copy = Arrays.copyOf(array, array.length);
        medirTempo(copy, Sorts::quickSort, "Quick Sort", tipoArray, tamanho);
    }

    private static void medirTempo(int[] array, MetodoSort metodo, String tipoSort, String scenario, int size) {
        long startTime = System.nanoTime();
        metodo.sort(array);
        long endTime = System.nanoTime();
        System.out.println(tipoSort + " " + scenario + " com tamanho " + size + " levou " + (endTime - startTime) + " ns");
    }

    @FunctionalInterface
    interface MetodoSort {
        void sort(int[] array);
    }

    private static void embaralharArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
