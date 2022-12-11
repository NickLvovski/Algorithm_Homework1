package ru.filatov;

public class CountingSort {
    public static Queue sort(Queue queue, int min, int max) throws Exception{
        // Инициализация массива подсчета
        int[] count = new int[max - min + 1];
        Queue sortedQueue = new Queue();
        Item oldTail = queue.tail;
        Item currentItem = queue.pop();

        count[oldTail.value - min] += 1;
        while (currentItem != oldTail){
            count[currentItem.value - min] += 1;
            currentItem = queue.pop();
        }

        for (int i = 0; i < count.length; i++){
            for (int j = 0; j < count[i]; j++){
                sortedQueue.push(new Item(i + min));
            }
        }

        return sortedQueue;
    }
}
