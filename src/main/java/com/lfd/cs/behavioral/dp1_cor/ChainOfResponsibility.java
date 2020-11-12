package com.lfd.cs.behavioral.dp1_cor;

import java.util.ArrayList;
import java.util.List;

public class ChainOfResponsibility {
    public static void main(String[] args) {

        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        handler1.handleRequest();

        //sample
        Response resp = new Response();
        Chain c = new Chain();

        Chain c2 = new Chain();
        c2.add(new AuthInterceptor());

        c.add(new DecryptInterceptor()).add(c2);

        c.onResp(resp);
    }
}


abstract class Handler{

    Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    abstract void handleRequest();

}

class ConcreteHandler1 extends Handler{
    @Override
    void handleRequest() {
        System.out.println(getClass().getSimpleName() + " handle request");
        if(getNext() != null)
        getNext().handleRequest();
    }
}

class ConcreteHandler2 extends Handler{
    @Override
    void handleRequest() {
        System.out.println(getClass().getSimpleName() + " handle request");
        if(getNext() != null)
        getNext().handleRequest();
    }
}

class ConcreteHandler3 extends Handler{
    @Override
    void handleRequest() {
        System.out.println(getClass().getSimpleName() + " handle request");
        if(getNext() != null)
        getNext().handleRequest();
    }
}


///////////////sample//////////////////

class Chain implements Interceptor{
    private List<Interceptor> interceptorList = new ArrayList<>();

    Chain add(Interceptor interceptor){
        interceptorList.add(interceptor);
        return this;
    }

    @Override
    public boolean onResp(Response response) {
        for (Interceptor interceptor : interceptorList) {
            boolean isOk = interceptor.onResp(response);
            if(!isOk){
                return false;
            }
        }
        return true;
    }
}

class Response{
    String body;
}

interface Interceptor{
    boolean onResp(Response response);
}

class AuthInterceptor implements Interceptor{

    @Override
    public boolean onResp(Response response) {
        System.out.println("auth resp interceptor");
        return true;
    }
}

class DecryptInterceptor implements Interceptor{

    @Override
    public boolean onResp(Response response) {
        System.out.println("decrypt resp interceptor");
        return true;
    }
}

