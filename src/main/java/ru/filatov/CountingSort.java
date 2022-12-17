package ru.filatov;

public class CountingSort {
    public static Queue sort(Queue queue, int min, int max) throws Exception{ //3+4+2+2+8+5+14n+3n*18k
        //F(n)=3+4+2+2+8+5+sum(5+8+1)(i=1;i=n)+sum(3+sum(2+16)[i=1;i=k])[i=1;i=n] =
        //=24+14n+3n+18nk=24+17n+18nk
        //O(F(n))=nk
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

        for (int i = 0; i < count.length; i++){ //3n + 18nk
            sortedQueue.N_op += 3;
            for (int j = 0; j < count[i]; j++){ //18k
                sortedQueue.N_op += 2;
                sortedQueue.push(new Item(i + min)); sortedQueue.N_op+=6; //16
            }
        }

        return sortedQueue;
    }
}
