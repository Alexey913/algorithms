package Les2;
import java.util.Random;

public class Seminar2 {
    public static void main(String[] args) {
        int n = 11;
        int [] newArray = new int [n];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = new Random().nextInt(0, 10);
        }
        
        for (int i : newArray) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        
        // sortArray(newArray);

        int val = newArray[newArray.length/2];
        quickSort(newArray, 0, newArray.length-1);
        
        for (int i : newArray) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        System.out.println(val);
        System.out.println();
        System.out.println(binarySearch(newArray, val, 0, newArray.length-1));
        timeOfSearch();
    }


// Сравнение бинарного и линейного поисков
    public static void timeOfSearch() {
        for (int n = 10000; n <= 100000; n+=10000) {
            int [] newArray = new int [n];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = new Random().nextInt(-100, 100);
            }

            int val = newArray[newArray.length/2];
            quickSort(newArray, 0, newArray.length-1);

            long start1 = System.nanoTime();
            System.out.println(binarySearch(newArray, val, 0, newArray.length-1));
            long finish1 = System.nanoTime();
            long result = finish1 - start1;
            
            long start2 = System.nanoTime();
            System.out.println(lineSearch(newArray, val));
            long finish2 = System.nanoTime();
            long result2 = finish2 - start2;
            System.out.println("binary search = " + result + " - " + "linear search = " + result2);
        }
    }   
    
/* Задание 3
 1.Пишем тесты для сравнения производительности сортировки больших 
массивов. 
2.Для наглядного результата стоит сравнивать массивы до 100 000 элементов. 
При таком подходе будет явно видно, какая из сортировок окажется быстрее.
//  */
//         for (int n = 10000; n <= 100000; n+=10000) {
//             int [] newArray = new int [n];
//         for (int i = 0; i < newArray.length; i++) {
//             newArray[i] = new Random().nextInt(-1000, 1000);
//         }

//         int [] newArray2 = newArray.clone();
        
//         System.out.println();

//         long start1 = System.nanoTime();
//         sortArray(newArray);
//         long finish1 = System.nanoTime();
//         long result = finish1 - start1;
//         System.out.println("ChoiseSort = " + result);
        
//         long start2 = System.nanoTime();
//         quickSort(newArray2, 0, newArray2.length-1);
//         long finish2 = System.nanoTime();
//         long result2 = finish2 - start2;
//         System.out.println("QuickSort = " + result2);
        
//         }
//     }

/* задание 1
 1.Необходимо написать один из простых алгоритмов сортировки, 
имеющий сложность O(n2
). 
2.Можно выбрать из пузырьковой сортировки, сортировки вставками и 
сортировки выбором. 
3.Следует обратить внимание на сложность данных алгоритмов и 
указать признаки квадратичной сложности для каждого из них.
 */

    public static void sortArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            int minPos = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            if (minPos != i) {
                int temp = array[minPos];
                array[minPos] = array[i];
                array[i] = temp;
            }
        }
    }

    /* Задание 2
    1.Написать алгоритм быстрого поиска (quicksort). 
     */
    public static void quickSort(int [] array, int startPos, int finishPos) {
        int leftPos = startPos;
        int rightPos = finishPos;
        int pivot = array[(startPos + finishPos)/2];
        do {
            while (array[leftPos] < pivot) {
                leftPos++;
            }
            while (array[rightPos] > pivot) {
                rightPos--;
            }
            if (leftPos <= rightPos) {
                if (leftPos < rightPos) {
                    int temp = array[leftPos];
                    array[leftPos] = array[rightPos];
                    array[rightPos] = temp;
                }
                leftPos++;
                rightPos--;
            }
        }
        while (leftPos <= rightPos);
        if (leftPos < finishPos) {
            quickSort(array, leftPos, finishPos);
        }
        if (rightPos > startPos) {
            quickSort(array, startPos, rightPos);
        }
    }

/* Задание 4
 1.После успешной сортировки массива на нем можно использовать бинарный 
поиск. Необходимо реализовать алгоритм бинарного поиска по 
элементам. 
2.Стоит акцентировать внимание, что т.к. алгоритм использует подход 
«разделяй и властвуй», его удобно писать с помощью рекурсии. 
3.Так что стоит акцентировать внимание на алгоритмическую сложность 
данного алгоритма, что его выполнение многократно быстрее простого 
перебора на больших массивах
 */

    public static int binarySearch(int [] array, int value, int minPos, int maxPos) {
        if (minPos >= maxPos) {
            return -1;
        }

        int midPoint = minPos + (maxPos - minPos)/2;
        if (array[midPoint] == value) {
            return midPoint;
        }
        else if (array[midPoint] > value) {
            return binarySearch(array, value, minPos, midPoint-1);
        }
        else {
            return binarySearch(array, value, midPoint+1, maxPos);
        }
    }

    public static int lineSearch(int [] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
