package com.lfd.cs.behavioral.dp10_tm;

public class TemplateMethod {
    public static void main(String[] args) {
        Application application = new ConcreteApplication();
        application.templateMethod();
    }
}


abstract class Application{

    void templateMethod(){
        op1();
        op2();
        op3();
    }

    abstract void op1();
    abstract void op2();
    abstract void op3();

}

class ConcreteApplication extends Application{

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }

    @Override
    void op3() {
        System.out.println("op3");
    }
}