package ru.filatov;

public class CountingSort {
    public static Queue sort(Queue queue, int min, int max) throws Exception{
        int[] count = new int[max - min + 1];
        Queue sortedQueue = new Queue();
        Item oldTail = queue.tail;
        Item curentItem = queue.pop();

        count[oldTail.value - min] += 1;
        while (curentItem != oldTail){
            count[curentItem.value - min] += 1;
            curentItem = queue.pop();
        }

        int index = 0;
        for (int i = 0; i < count.length; i++){
            for (int j = 0; j < count[i]; j++){
                sortedQueue.push(new Item(i+min));
            }
        }

        return sortedQueue;
    }
}
