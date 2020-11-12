package com.lfd.cs.creational.dp4_singleton;

public class St {
}


//type1
class StType1{
    private static StType1 INSTANCE = new StType1();
    private StType1(){}

    public static StType1 getInstance() {
        return INSTANCE;
    }
}

//type2
class StType2{
    private static StType2 INSTANCE;
    private StType2(){}

    public static StType2 getInstance() {
        if(INSTANCE == null){
            INSTANCE = new StType2();
        }
        return INSTANCE;
    }
}

//type3
class StType3{
    private static StType3 INSTANCE;
    private StType3(){}

    public synchronized static StType3 getInstance() {
        if(INSTANCE == null){
            INSTANCE = new StType3();
        }
        return INSTANCE;
    }
}

//type4 DCL
class StType4{
    private static volatile StType4 INSTANCE;
    private StType4(){}

    public synchronized static StType4 getInstance() {
        if(INSTANCE == null){
            synchronized (StType4.class){
                if(INSTANCE == null){
                    INSTANCE = new StType4();
                }
            }
        }
        return INSTANCE;
    }
}

//type5 静态内部类
class StType5{

    private StType5(){}

    private static class Holder{
         private final static StType5 INSTANCE = new StType5();
    }

    public static StType5 getInstance(){
        return Holder.INSTANCE;
    }
}

//type6 enum
enum StType6{
    INSTANCE
}