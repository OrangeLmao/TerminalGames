public class Helpers {
    public static int[] add(int arr[], int ele) {
        int n = arr.length;
        int[] newArray = new int[n + 1];

        //copy original array into new array1
        for (int i = 0; i < n; i++)
            newArray[i] = arr[i];

        //add element to the new array
        newArray[n] = ele;

        return newArray;
    }

    public static int[] remove(int arr[]) {

        int[] newArray = new int[arr.length - 1];
        int n = newArray.length;
        //copy array
        for (int i = 0; i < n; i++)
            newArray[i] = arr[i]; //copies everything except last


        return newArray;

    }

    public static int[] add(int arr[], int ele, int loc) {
        int n = arr.length;
        int[] newArray = new int[n + 1];
        int g = 0;
        boolean skip = true;
        while (skip) {
            newArray[g] = arr[g];
            if (g == loc) {
                newArray[g] = ele;
                skip = false;
            }
            g++;
        }
        for (int i = g; i < n + 1; i++) {

            newArray[i] = arr[i - 1];
        }
        return newArray;
    }

    public static int[] remove(int arr[], int loc) {
        int[] newArray = new int[arr.length - 1];


        for (int i = 0; i < loc; i++) {
            newArray[i] = arr[i];
        }

        int g = loc + 1;
        for (int i = g; i <= newArray.length; i++) {
            newArray[i - 1] = arr[i];
        }

        return newArray;

    }

    public static int[] replace(int[] arr, int b, int loc) {
        int n = arr.length;
        int[] newArray = new int[n];
        int g = 0;
        boolean skip = true;
        while (skip) {
            newArray[g] = arr[g];
            if (g == loc) {
                newArray[g] = b;
                skip = false;
            }
            g++;
        }
        for (int i = g; i < n; i++) {

            newArray[i] = arr[i];
        }
        return newArray;

    }

    public static void display(int[] a) {
        int sizeTemp1 = a.length;
        for (int temp : a)
            System.out.print(temp++ + " ");
        System.out.println();


    }

    public static void reverseArray(int[] a) {

        //int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //god tier array
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean existsInArray(int[] a, int check) {
        boolean toggle = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == check) {
                toggle = true;
            }
        }
        if (toggle)
            return true;
        else
            return false;

    }

    public static int numberOf(int[] a, int num) {
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == num) {
                counter++;
            }
        }
        return counter;
    }
    public static int findIndex(int arr[], int t){


        int len = arr.length;
        int i = 0;

        while (i < len) {

            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
}