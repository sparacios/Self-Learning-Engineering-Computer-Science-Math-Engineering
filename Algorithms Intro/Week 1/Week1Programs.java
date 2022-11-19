import java.util.*;

public class Week1Programs {
    public static void main(String[] args) {
        String[] arr = new String[16];

        generateTextList(arr, "abcdef");
        mergeSort(arr);

        String[] arr2 = {"a", "b", "c", "d"};

        System.out.print("List: ");
        printArray(arr);
        System.out.println(nonRecursiveBinarySearch("d", arr));
    }

    public static int binarySearch(String key, String[] arr) {
        return binarySearch(key, 0, arr.length, arr);
    }

    public static int binarySearch(String key, int low, int high, String[] arr) {
        if((high - low) < 0)    return -1;

        int mid = low + (high - low) / 2;
        
        if(arr[mid].compareTo(key) > 0)
            return binarySearch(key, low, mid, arr);
        else if(arr[mid].compareTo(key) < 0)
            return binarySearch(key, mid + 1, high, arr);
        else
            return mid;

    }

    public static int nonRecursiveBinarySearch(String key, String[] arr) {
        int high = arr.length;  int low = 0;    int indexFound = -1;

        if((high - low) < 0 )   return -1;

        int mid = low + (high - low) / 2;

        while((high - low) >= 0) {
            mid = low + (high - low) / 2;

            if(arr[mid].compareTo(key) > 0) {
                high = mid;
            }else if(arr[mid].compareTo(key) < 0) {
                low = mid + 1;
            }else {
                indexFound = mid;
                break;
            }
        }
        
        return indexFound;

    }

    public static void insertionSort(Comparable[] arr) {

        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j - 1].compareTo(arr[j]) > 0)
                    swap(arr, j -1, j);
                else break;
            }
        }
    }

    public static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void mergeSort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length);
    }

    public static void sort(Comparable[] arr, Comparable[] aux, int low, int high) {
        if(high - low <= 1) return;
        int mid = low + (high - low) / 2;
        sort(arr, aux, low, mid);
        sort(arr, aux, mid, high);

        merge(arr, aux, low, mid, high);
    }

    public static void merge(Comparable[] arr, Comparable[] aux, int low, int mid, int high) {
        int i = low, j = mid;

        for (int k = low; k < high; k++) {
            if      (i == mid)                 aux[k] = arr[j++];
            else if (j == high)                  aux[k] = arr[i++];
            else if (arr[j].compareTo(arr[i]) < 0) aux[k] = arr[j++];
            else                               aux[k] = arr[i++];
        }

        // copy back
        for (int k = low; k < high; k++)
            arr[k] = aux[k];
    }

    public static void generateTextList(String[] arr, String alphab) {
        Random r = new Random();

        for(int i = 0; i < arr.length; i++) {
            int index = r.nextInt(alphab.length());
            arr[i] = alphab.substring(index, index + 1);
        }
    }

    public static void printArray(String [] arr) {
        for(String a : arr) {
            System.out.print(a + " ");
        }

        System.out.println("");
    }
}