package com.lfd.cs.structural.dp6_flyweight;

import java.util.HashMap;
import java.util.Map;

class Client {

    public static void main(String[] args) {

        //池：常量池，连接池，线程池
        FlyweightFactory factory = new FlyweightFactory();
        factory.getFlyweights("a").operation(1);
        factory.getFlyweights("a").operation(2);

    }

}


class FlyweightFactory{

    public Map<String,Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweights(String key) {
        if(flyweights.containsKey(key)){
            return flyweights.get(key);
        }else{
            Flyweight flyweight = new ConcreteFlyweight(key);
            flyweights.put(key,flyweight);
            return flyweight;
        }
    }
}

interface Flyweight{
    void operation(int state);
}

class ConcreteFlyweight implements Flyweight{
    String name;

    public ConcreteFlyweight(String name) {
        this.name = name;
    }

    @Override
    public void operation(int state) {
        System.out.println(name + "." + hashCode() +" operation() :" + state);
    }
}

