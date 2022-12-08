package ru.filatov;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception{
        Random random = new Random();
        Queue queue = new Queue();
        int min = 10000;
        int max = 0;
        int number;

        for (int i = 0; i < random.nextInt(10, 1000); i++){
            number = random.nextInt(0, 1000);
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
