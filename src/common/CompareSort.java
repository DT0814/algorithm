package common;

import java.util.Arrays;
import java.util.Random;

public class CompareSort {
    private Sort sortObj;
    private int frequency;

    public CompareSort(Sort sort, int frequency) {
        sortObj = sort;
        this.frequency = frequency;
    }

    private void start() {
        Random random = new Random();
        random.nextInt(10);
        int[] arr;
        int[] arrays;
        int[] sort;
        int len;
        boolean right = true;
        for (int i = 0; i < frequency; i++) {
            len = random.nextInt(20) + 1;
            arr = new int[len];
            for (int a = 0; a < arr.length; a++) {
                arr[a] = random.nextInt(100) + 1;
            }
            arrays = copyArr(arr);
            Arrays.sort(arrays);
            sort = copyArr(arr);
            sortObj.sort(sort);
            int a = 0, b = 0;
            while (a < len && b < len && arrays[a++] == sort[b++]) ;
            if (a != len) {
                printArr(arr);
                printArr(arrays);
                printArr(sort);
                right = false;
            }
        }
        if (right) {
            System.out.println("right");
        }
    }

    private void printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int a : arr) {
            sb.append(a + ",");
        }
        System.out.println(sb.toString());
    }

    private int[] copyArr(int arr[]) {
        int[] copy = new int[arr.length];
        for (int i = 0, j = 0; i < arr.length; ) {
            copy[j++] = arr[i++];
        }
        return copy;
    }

    public static void main(String[] args) {
        new CompareSort(new MergeSort(), 12312).start();

    }

}
