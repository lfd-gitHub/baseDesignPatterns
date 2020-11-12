package com.lfd.cs.behavioral.dp7_obs;

import java.util.ArrayList;
import java.util.List;


class Client {
    public static void main(String[] args) {

        Subject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserver1());
        subject.attach(new ConcreteObserver2());
        subject.notifyObs();

        //event
        Button button = new Button();
        button.addListener(new ClickListener() {
            @Override
            public void onClick(ActionEvent e) {
                System.out.println(e.source);
            }
        });
        button.preformClick();
    }
}

interface Observer{
    void update();
}

abstract class Subject{

    List<Observer> observers = new ArrayList<>();

    void attach(Observer observer){
        observers.add(observer);
    }
    void detach(Observer observer){
        observers.remove(observer);
    }

    abstract void notifyObs();

}

class ConcreteSubject extends Subject{
    @Override
    void notifyObs() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class ConcreteObserver1 implements Observer{
    @Override
    public void update() {
        System.out.println("observer1 update");
    }
}

class ConcreteObserver2 implements Observer{
    @Override
    public void update() {
        System.out.println("observer2 update");
    }
}


////event demo

interface ClickListener{
    void onClick(ActionEvent e);
}

abstract class ActionEvent{

    Object source;

    public ActionEvent(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }
}

class ClickEvent extends ActionEvent{

    public ClickEvent(Object source) {
        super(source);
    }
}

class Button{

   List<ClickListener> ls = new ArrayList<>();

   void addListener(ClickListener l){
       ls.add(l);
   }

   void preformClick(){
       ls.forEach((e) -> e.onClick(new ClickEvent(this)));
   }
}