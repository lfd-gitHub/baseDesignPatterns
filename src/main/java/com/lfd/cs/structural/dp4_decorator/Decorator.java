package com.lfd.cs.structural.dp4_decorator;

class Client {
    public static void main(String[] args) {
        new ConcreteDecorator(new ConcreteComponent()).operation();
    }
}


interface Component{
    void operation();
}

class ConcreteComponent implements Component{

    @Override
    public void operation() {
        System.out.println("ConcreteComponent operation");
    }
}

public class Decorator implements Component{

    Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}

class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }

    public void addBehavior(){
        System.out.println("concreteDecorator add behavior");
    }
}


