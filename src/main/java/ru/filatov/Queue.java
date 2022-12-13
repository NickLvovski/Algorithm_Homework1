package ru.filatov;


public class Queue{
    public Item head = null;
    public Item tail = null;
    public Long N_op = 0L;

    public Queue() { }

    public void push(Item value){ //10
        N_op++;
        N_op += 3;
        if(head == null && tail == null){ //3
            head = value; N_op++; //1
        }
        else{
            tail.next = value; N_op+=2; //2
        }

        tail = value; N_op++;//1
        tail.next = null; N_op+=2; //2
    }

    public Item pop() throws Exception{ //6
        N_op++;
        if (head == null){ //1
            throw new Exception("The queue is empty");
        }
        N_op++;
        if (head == tail){ //1
            tail = null; N_op++; //1
        }
        Item result = head; N_op++; //1
        head = head.next; N_op+=2; //2

        return result;
    }

    public int get(int index) throws Exception{ //7 + 35n
        Item oldHead = head; N_op++;//1
        N_op+=2;
        for(int i = 0; i < index; i++){ //2 + 18*n
            N_op+=2;
            push(pop()); //18
        }
        int result = head.value; N_op+=2;//2
        N_op++;
        while(head != oldHead){ //1 + 17*n
            N_op++;
            push(pop()); //17
        }

        return result;
    }

    public void set(int index, int value) throws Exception{ //8 + 35n
        Item oldHead = head; N_op++;//1
        N_op+=2;
        for(int i = 0; i < index; i++){ //2 + 18 * n
            N_op+=2;
            push(pop()); //18
        }
        head.value = value; N_op+=2; //2
        while(head != oldHead){ //1 + 17n
            N_op++;
            push(pop());
        }
    }

    public void print(){
        Item current = head;
        while (current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}
