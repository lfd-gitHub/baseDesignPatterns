package com.lfd.cs.structural.dp7_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Calendar;
import static java.lang.reflect.Proxy.newProxyInstance;

public class Proxy {
    public static void main(String[] args) {
        //静态代理
        //new TimeProxy(new AddCalc()).oper();
        //①JDK动态代理-全方法，任意类
        AddCalc addCalc = new AddCalc();
        ///
        //System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        //②动态生成class，反射方法,asm
        Calculate addCalcProxy = (Calculate) newProxyInstance(Proxy.class.getClassLoader(), new Class[]{Calculate.class}, (proxy, method, args1) -> {
            Object result = method.invoke(addCalc,args1);
            System.out.println("---after:"+method.getName()+"---");
            return result;
        });
        addCalcProxy.oper();
        //③cglib,asm  
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(AddCalc.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib interceptor :" + method.getName());
                return methodProxy.invokeSuper(o,objects);
            }
        });
        Calculate cgCalcProxy = (Calculate) enhancer.create();
        cgCalcProxy.oper();
    }
}


interface Calculate{
    void oper();
}

class AddCalc implements Calculate{
    @Override
    public void oper() {
        System.out.println("add");
    }
}


class TimeProxy implements Calculate{
    Calculate calculate;

    public TimeProxy(Calculate calculate) {
        this.calculate = calculate;
    }

    @Override
    public void oper() {
        System.out.println(Calendar.getInstance().getTimeInMillis());
        calculate.oper();
    }
}