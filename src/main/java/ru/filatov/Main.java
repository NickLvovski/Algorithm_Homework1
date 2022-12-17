package ru.filatov;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Random;

public class Main {
    static Random random = new Random();
    public static void main(String[] args) throws Exception{
        int[] sortElems = {300, 600, 900, 1200, 1500, 1800, 2100, 2400, 2700, 3000};
        initSorts(sortElems);
        sortOneQueue(100);
    }
    private static void initSorts(int[] elements) throws Exception{
        StopWatch stopWatch = new StopWatch();

        for (int i = 0; i < elements.length; i++){
            stopWatch.start();
            Queue queue = new Queue();
            int min = 1000000000;
            int max = 0;
            int number;
            for (int j = 0; j < elements[i]; j++){
                number = random.nextInt(0, 1000);
                if (number < min) min = number;
                if (number > max) max = number;
                queue.push(new Item(number));
            }
            queue = CountingSort.sort(queue, min, max);
            stopWatch.stop();
            System.out.printf("Номер сортировки: %d Количество отсортированных элементов: %d Время сортировки(нс): " +
                    "%d Количество операций (N_op): %d\n",
                    i+1, elements[i], stopWatch.getNanoTime(), queue.N_op);
            stopWatch.reset();
        }
    }

    private static void sortOneQueue(int elem) throws Exception{
        Queue queue = new Queue();
        int min = 1000000000;
        int max = 0;
        int number;
        for (int i = 0; i < elem; i++){
            number = random.nextInt(0, 10000);
            if (number < min) min = number;
            if (number > max) max = number;
            queue.push(new Item(number));
        }
        System.out.println("Before sorting:");
        queue.print();
        queue = CountingSort.sort(queue, min, max);
        System.out.println("After sorting:");
        queue.print();
    }
}
