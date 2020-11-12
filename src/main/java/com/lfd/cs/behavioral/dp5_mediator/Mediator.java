package com.lfd.cs.behavioral.dp5_mediator;

import java.util.ArrayList;
import java.util.List;

class Client{

    public static void main(String[] args) {

        Mediator mediator = new ConcreteMediator();

        Colleague c1 = new ConcreteColleague1(mediator);
        Colleague c2 = new ConcreteColleague2(mediator);

        mediator.register(c1);
        mediator.register(c2);

        c1.send();
    }

}


public interface Mediator {

    void register(Colleague colleague);
    void relay(Colleague from,String msg);

}

class ConcreteMediator implements Mediator{

    List<Colleague> colleagueList = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        colleagueList.add(colleague);
    }

    @Override
    public void relay(Colleague from,String msg) {
        for (Colleague colleague : colleagueList) {
            if(colleague == from)continue;
            colleague.receive(msg);
        }
    }
}

abstract class Colleague{

    Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    abstract void receive(String msg);
    abstract void send();
}

class ConcreteColleague1 extends Colleague{

    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    @Override
    void receive(String msg) {
        System.out.println("colleague 1 receive : " + msg);
    }

    @Override
    void send() {
        mediator.relay(this,"colleague 1's msg");
    }
}

class ConcreteColleague2 extends Colleague{

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    @Override
    void receive(String msg) {
        System.out.println("colleague 2 receive : " + msg);
    }

    @Override
    void send() {
        mediator.relay(this,"colleague 2's msg");
    }
}
