package com.lfd.cs.behavioral.dp2_cmd;

import java.util.ArrayList;
import java.util.List;

class Client {

    public static void main(String[] args) {

        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        invoker.addCommand(new ConcreteCommand1(receiver));
        invoker.addCommand(new ConcreteCommand2(receiver));
        invoker.invoke();

        //samples
    }
}


class Invoker{

    private List<Command> commands = new ArrayList<>();



    public void addCommand(Command command) {
        this.commands.add(command);
    }

    void invoke(){
        while(commands.size() > 0){
            Command c = commands.remove(0);
            c.execute();
        }
    }
}

interface Command{
    void execute();
}

class ConcreteCommand1 implements Command{

    Receiver receiver;

    public ConcreteCommand1(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action1();
    }
}

class ConcreteCommand2 implements Command{

    Receiver receiver;

    public ConcreteCommand2(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action2();
    }
}

class Receiver{
    void action1(){
        System.out.println("action1");
    }
    void action2(){
        System.out.println("action2");
    }
}