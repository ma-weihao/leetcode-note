package top.wello.leetcode.sort;

import java.util.Arrays;

/**
 * Created by maweihao on 9/10/21
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {3, 11, 4, 4, 0};
        quickSort(arr);
//        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr) {
        quickSortInner(arr, 0, arr.length - 1);
    }

    private static void quickSortInner(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSortInner(arr, left, partition - 1);
            quickSortInner(arr, partition + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }



}
