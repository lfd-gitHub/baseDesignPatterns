package com.lfd.cs.structural.dp2_bridge;

public class Bridge {

    public static void main(String[] args) {

        Implementor imp = new ConcreteImplementA();
        new RefinedAbstraction(imp).operation();

        ///window sample
        new IconWindow(new XWindowImp()).drawBorder();
        new TransWindow(new XWindowImp()).drawCloseBox();

    }

}

abstract class Abstraction{

    Implementor imp;

    public Abstraction(Implementor imp) {
        this.imp = imp;
    }

    abstract void operation();

}


interface Implementor{
    void operationImpl();
}


class RefinedAbstraction extends Abstraction{
    public RefinedAbstraction(Implementor imp) {
        super(imp);
    }

    @Override
    void operation() {
        System.out.println("RefinedAbstraction.operation()");
        imp.operationImpl();
    }
}


class ConcreteImplementA implements Implementor{
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementA.operationImpl()");
    }
}

class ConcreteImplementB implements Implementor{
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementB.operationImpl()");
    }
}

///////Window Sample///////////

abstract class Window{

    WindowImplementor imp;

    public Window(WindowImplementor imp) {
        this.imp = imp;
    }

    void drawText(){
        System.out.println("window draw text");
        imp.devDrawText();
    }

    void drawRect(){
        System.out.println("window draw rect");
        imp.devDrawLine();
        imp.devDrawLine();
        imp.devDrawLine();
        imp.devDrawLine();
    }

}

interface WindowImplementor{

    void devDrawText();
    void devDrawLine();

}

class IconWindow extends Window{

    public IconWindow(WindowImplementor imp) {
        super(imp);
    }

    void drawBorder(){
        System.out.println("icon window draw border");
        drawRect();
    }

}

class TransWindow extends Window{

    public TransWindow(WindowImplementor imp) {
        super(imp);
    }

    void drawCloseBox(){
        System.out.println("TransWindow.drawCloseBox");
        drawRect();
    }
}


class XWindowImp implements WindowImplementor{

    @Override
    public void devDrawText() {
        System.out.println("x draw text");
    }

    @Override
    public void devDrawLine() {
        System.out.println("x draw line");
    }
}

class PwWindowImp implements WindowImplementor{

    @Override
    public void devDrawText() {
        System.out.println("pw draw text");
    }

    @Override
    public void devDrawLine() {
        System.out.println("pw draw line");
    }
}







