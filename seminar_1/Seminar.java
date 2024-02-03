import java.util.ArrayList;

public class Seminar {
    public static void main (String [] args){
        System.out.println("Сумма");
        System.out.println(summ(100));
        System.out.println("Сумма по Гауссу");
        System.out.println(gauss(100));
        // System.out.println(simple(100));
        // System.out.println(cubeReq(2, 2));
        long start;
        long finish;
        for (int i = 10; i <= 50; i+=10) {
            System.out.println("Фибоначчи с рекурсией");
            start = System.nanoTime();
            System.out.println(fib(i));
            finish = System.nanoTime();
            long dur = finish - start;
            System.out.println("Продолжительность рекурсии Фибоначчи для " + i + " - " + dur);
            System.out.println("Фибоначчи с циклом");
            start = System.nanoTime();
            System.out.println(fibFor(i));
            finish = System.nanoTime();
            dur = finish - start;
            System.out.println("Продолжительность цикла Фибоначчи для " + i + " - " + dur);
        }
    }

/*
 Необходимо написать алгоритм, считающий сумму всех чисел 
от 1 до N. Согласно свойствам линейной сложности, 
количество итераций цикла будет линейно изменяться 
относительно изменения размера N.
 */

    public static Integer summ (Integer number) {
        Integer sumNum = 0;
        for (int i = 1; i <= number; i++) {
            sumNum+=i;
        }
        return sumNum;
    }

    public static Integer gauss (Integer number) {
        Integer sumNum = (1 + number)*100/2;
        return sumNum;
    }

/*
 Написать алгоритм поиска простых чисел (делятся только на себя и 
на 1) в диапазоне от 1 до N. В алгоритме будет использоваться 
вложенный for, что явно говорит о квадратичной сложности, на этом 
стоит акцентировать внимание
 */

    public static ArrayList <Integer> simple (Integer number) {
        ArrayList <Integer> list = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            boolean check = true;
            for (int j = 2; j < i; j++) {
                if (i%j == 0) {
                    check = false;
                    break;
                }
            }
            if (check == true) {
                list.add(i);
            }
        }
        return list;
    }


/*
1. Необходимо написать алгоритм поиска всех доступных комбинаций 
(посчитать количество) для количества кубиков K с количеством граней N. 
2. У вас есть 2 варианта на выбор – количество кубиков может быть строго 
ограничено (4 кубика, например), либо их количество будет 
динамическим. Выбор за вами. 
3. Если вы реализуете простой вариант, обращает внимание, что данное 
решение имеет сложность O(n4
), но если количество кубиков сделать 
переменной, то она трансформируется в O(nk
), что будет представлять 
собой экспоненциальную сложность. Для второго решения очевидно, что 
его сложность O(nk
) с самого начала.
 */
    public static ArrayList <Integer> cube (int k) {
        ArrayList <Integer> list = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                for (int m = 1; m <= k; m++) {
                    for (int t = 1; t <= k; t++) {
                        list.add(i);
                        list.add(j);
                        list.add(m);
                        list.add(t);
                        list.add(00);
                    }
                }
            }
        }
        return list;
    }


    public static int cubeReq (int n, int k) {
        if (k<=0) return 0;
        return reqCount(1, n, k);
}

    public static int reqCount (int depth, int maxDepth, int side) {
        int count = 0;
        for (int i = 1; i <= side; i++) {
            if (depth == maxDepth) count++;
            else count+=reqCount(depth+1, maxDepth, side);
        }
        return count;
    }

/*
1. Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
2. Считаем, что 1 и 2 значения последовательности равны 1. 
3. Искать будем по формуле On=On-1+On-2 что предполагает использовать 
рекурсивного алгоритма.
 */

    static int fib (int N) {
        if (N <= 1) return N;
        int fibo = fib(N-1) + fib(N-2);
        return fibo;
    }

    static int fibFor (int N) {
        int first = 0;
        int second = 1;
        int fibo = 1;
        for (int i = 1; i < N; i++) {
            fibo = first + second;
            first = second;
            second = fibo;
        }
        return fibo;
    }
}
