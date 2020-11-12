package com.lfd.cs.structural.dp1_adaptor;

public class Adaptor {

    public static void main(String[] args) {
        new ClassAdapter().request();
        new ObjectAdapter(new Adaptee()).request();
    }

}

interface Target{
    void request();
}

class Adaptee{
    void specificRequest(){
        System.out.println("spec");
    }
}

///class adapter
class ClassAdapter extends Adaptee implements Target{
    @Override
    public void request() {
        specificRequest();
    }
}

///object adapter
class ObjectAdapter implements Target{

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        this.adaptee.specificRequest();
    }
}
