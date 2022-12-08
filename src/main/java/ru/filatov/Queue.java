package ru.filatov;


public class Queue{
    public Item head = null;
    public Item tail = null;

    public Queue() {
    }

    public void push(Item value){
        if(head == null && tail == null){
            head = value;
        }
        else{
            tail.next = value;
        }

        tail = value;
        tail.next = null;
    }

    public Item pop() throws Exception{
        if (head == null){
            throw new Exception("The queue is empty");
        }
        if (head == tail){
            tail = null;
        }
        Item result = head;
        head = head.next;

        return result;
    }

    public int get(int index) throws Exception{
        Item oldHead = head;
        for(int i = 0; i < index; i++){
            push(pop());
        }
        int result = head.value;
        while(head != oldHead){
            push(pop());
        }

        return result;
    }

    public void set(int index, int value) throws Exception{
        Item oldHead = head;
        for(int i = 0; i < index; i++){
            push(pop());
        }
        head.value = value;
        while(head != oldHead){
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
