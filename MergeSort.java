import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6,3,9,5,2,8};
        mergeSortInPlace(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


  public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;

        int[] leftArray = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] rightArray = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(leftArray, rightArray);

    }
    public static int[] merge(int[] first,int[] second) {
        int[] mix = new int[first.length + second.length];
        int i=0;
       int j=0;
       int k=0;
        while(i<first.length && j<second.length) {
            if(first[i]<second[j]) {
                mix[k] = first[i];
                i++;
            } else {
                mix[k] = second[j];
                j++;
            }
            k++;
        }
        while(i<first.length) {
            mix[k] = first[i];
            i++;
            k++;
        }
        while(j<second.length) {
            mix[k] = second[j];
            j++;
            k++;
        }
        return mix;
    }
    static void mergeSortInPlace(int[] arr, int s, int e) {
        if (s>=e) {
            return;
        }

        int mid = s + (e - s) / 2;

        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid+1, e);

        mergeInPlace(arr, s, mid, e);
    }
    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s + 1];

        int i = s;
        int j = m+1;
        int k = 0;

        while (i <= m && j <= e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i <= m) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j <= e) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }

}



