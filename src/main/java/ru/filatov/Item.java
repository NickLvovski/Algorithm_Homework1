package ru.filatov;

public class Item {
    // значение элемента в очереди
    public int value;
    // указатель на следующий элемент в очереди
    public Item next;

    public Item(int value, Item next){ //2
        this.value = value; //1
        this.next = next; //1
    }

    public Item(int value) //2
    {
        this(value, null);
    }
}
