package ru.filatov;

public class CountingSort {
    public static Queue sort(Queue queue, int min, int max) throws Exception{ // 21 + 14n + 3n*18k
        // Инициализация массива подсчета
        int[] count = new int[max - min + 1]; queue.N_op+=4; //4
        Queue sortedQueue = new Queue(); queue.N_op+=2; //2
        Item oldTail = queue.tail; queue.N_op+=2; //2
        Item currentItem = queue.pop(); queue.N_op+=2; //8

        count[oldTail.value - min] += 1; queue.N_op+=5; //5
        while (currentItem != oldTail){ //14n
            count[currentItem.value - min] += 1; queue.N_op+=5; //5
            currentItem = queue.pop(); queue.N_op+=2; //8
        }
        sortedQueue.N_op = queue.N_op;

        for (int i = 0; i < count.length; i++){ //3n * 18k
            sortedQueue.N_op += 3;
            for (int j = 0; j < count[i]; j++){ //18k
                sortedQueue.N_op += 2;
                sortedQueue.push(new Item(i + min)); sortedQueue.N_op+=6; //16
            }
        }

        return sortedQueue;
    }
}
