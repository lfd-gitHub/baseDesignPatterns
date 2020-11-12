package com.lfd.cs.behavioral.dp8_state;

import sun.tools.jconsole.JConsole;

class Client{
    public static void main(String[] args) {

        Context context = new Context();
        context.request();
        context.request();

    }
}

class Context{

    private State state;

    public Context() {
        this.state = new ConcreteState1();
    }

    public void changeState(State state) {
        this.state = state;
    }

    void request(){
        state.handle(this);
    }
}

interface State {
    void handle(Context context);
}

class ConcreteState1 implements State{
    @Override
    public void handle(Context context) {
        System.out.println("state1 handle");
        context.changeState(new ConcreteState2());
    }
}

class ConcreteState2 implements State{
    @Override
    public void handle(Context context) {
        System.out.println("state2 handle");
    }
}


/////////