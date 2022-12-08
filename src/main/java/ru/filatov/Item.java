package ru.filatov;

public class Item {
    public int value;
    public Item next;

    public Item(int value, Item next){
        this.value = value;
        this.next = next;
    }

    public Item(int value){
        this(value, null);
    }
}
