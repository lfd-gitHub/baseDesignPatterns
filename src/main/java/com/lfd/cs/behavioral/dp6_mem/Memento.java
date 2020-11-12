package com.lfd.cs.behavioral.dp6_mem;

import com.sun.tools.corba.se.idl.constExpr.Or;

import javax.swing.text.Caret;

class Client {

    public static void main(String[] args) {

        Caretaker aCaretaker = new Caretaker();

        Originator originator = new Originator();

        originator.setState("0");

        System.out.println("currentState:"+originator.state);

        aCaretaker.keepMemento(originator);

        originator.setState("1");

        System.out.println("currentState:"+originator.state);

        originator.restoreMemento(aCaretaker.getMemento());

        System.out.println("currentState:"+originator.state);



    }

}


class Memento{

    String state;

    public Memento(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}


class Originator{

    String state;

    public void setState(String state) {
        this.state = state;
    }

    Memento createMemento(){
        return new Memento(state);
    }

    void restoreMemento(Memento memento){
        this.state = memento.getState();
    }
}


class Caretaker{

    Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void keepMemento(Originator originator) {
        this.memento = originator.createMemento();
    }
}



//////////sample///////////