package com.lfd.cs.behavioral.dp9_strategy;

import java.util.Arrays;
import java.util.Comparator;

public class StrategyTest {

    public static void main(String[] args) {

        ///comparator
        Item[] arr = {new Item(1,"x",true),new Item(2,"a",false)};
        Arrays.sort(arr, Comparator.comparing(o -> o.p1));
        Arrays.sort(arr, Comparator.comparing(o -> o.p2));
        Arrays.sort(arr, Comparator.comparing(o -> o.p3));
        ///*多种算法互相替换，多if-else问题
        ///*但是导致创建很多策略类
        Context ctx = new Context();
        ctx.setStrategy(new AddStrategy());
        int result = ctx.execute(1,2);
        System.out.println(result);
    }
}


class Item{

    Integer p1;
    String p2;
    Boolean p3;

    public Item(int p1, String p2, boolean p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
}

interface Strategy{
    int calc(int a,int b);
}

class AddStrategy implements Strategy{
    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}

class Context{

    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    int execute(int a, int b){
        return strategy.calc(a,b);
    }
}