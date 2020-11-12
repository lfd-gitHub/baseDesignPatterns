package com.lfd.cs.behavioral.dp4_itr;

import java.util.Arrays;

class Client{

    public static void main(String[] args) {

        ConcreteAggregate<Integer> iCa = new ConcreteAggregate<>();
        iCa.add(11);
        iCa.add(22);
        iCa.add(33);
        iCa.add(44);

        Iterator<Integer> it = iCa.createIterator();
        while (!it.isDone()) {
            int r = it.next();
            System.out.println(r);
        }

    }

}


public interface Iterator<T> {

    T first();
    T next();
    boolean isDone();
    T currentItem();

}

class ConcreteIterator<T> implements Iterator<T>{

    int currentIndex = 0;
    Aggregate<T> aggregate;

    public ConcreteIterator(Aggregate<T> aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public T first() {
        return aggregate.get(0);
    }

    @Override
    public T next() {
        return aggregate.get(currentIndex++);
    }

    @Override
    public boolean isDone() {
        return currentIndex >= aggregate.size();
    }

    @Override
    public T currentItem() {
        return aggregate.get(currentIndex);
    }
}

interface Aggregate<T>{

    Iterator<T> createIterator();
    void add(T t);
    T remote(T t);
    T get(int index);
    int size();
}

class ConcreteAggregate<T> implements Aggregate<T>{

    private int appendSize = 2;
    private Object[] arr = new Object[appendSize];
    private int size = 0;


    @Override
    public Iterator createIterator() {
        return new ConcreteIterator<T>(this);
    }

    @Override
    public void add(Object o) {
        if(size + 1 >= arr.length){
            arr = Arrays.copyOf(arr,arr.length + appendSize);
        }
        arr[size] = o;
        size ++;
    }

    @Override
    public T remote(Object o) {
        int index = -1;
        Object result = null;
        for (int i = 0; i < arr.length; i++) {
            if(o.equals(arr[i])){
                index = i;
                result = arr[i];
                break;
            }
        }
        if(index < 0){
            return null;
        }
        Object[] arrHead = Arrays.copyOf(arr,index);
        Object[] arrTail = Arrays.copyOfRange(arr,index+1,arr.length);
        Object[] arrTarget = new Object[arr.length];
        for (int i = 0; i < arrHead.length; i++) {
            arrTarget[i] = arrHead[i];
        }
        for (int i = 0; i < arrTail.length; i++) {
            arrTarget[arrHead.length + i] = arrTail[i];
        }
        arr = arrTarget;
        size --;
        return (T)result;
    }

    @Override
    public T get(int index) {
        return (T)arr[index];
    }

    public int size(){
        return size;
    }

}

