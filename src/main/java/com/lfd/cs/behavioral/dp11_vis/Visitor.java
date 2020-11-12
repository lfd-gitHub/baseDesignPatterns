package com.lfd.cs.behavioral.dp11_vis;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Client {

    public static void main(String[] args) {

        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new ConcreteElement1());
        objectStructure.add(new ConcreteElement2());

        objectStructure.visit(new ConcreteVisitor1());
        objectStructure.visit(new ConcreteVisitor2());

        //数据操作和数据结构分离
        VisitorBehave[] visitors = new VisitorBehave[]{
                new ChildVisitor(100),
                new ChildVisitor(180),
                new OldVisitor(99),
                new OldVisitor(199)
        };
        Zoo zoo = new SeaZoo();
        for (VisitorBehave visitor : visitors) {
            visitor.accept(zoo);
        }
        System.out.println("-----------");
        ///
        try {
            ClassReader reader = new ClassReader(ChildVisitor.class.getName());
            reader.accept(new ClassVisitor(Opcodes.ASM4) {
                @Override
                public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
//                    System.out.println(version);
//                    System.out.println(access);
//                    System.out.println(name);
//                    System.out.println(signature);
//                    System.out.println(superName);
//                    System.out.println(Arrays.toString(interfaces));
                }

                @Override
                public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions){
                    System.out.println("==========="+name+"===================");
                    System.out.println(access);
                    System.out.println(descriptor);
                    System.out.println(signature);
                    System.out.println(Arrays.toString(exceptions));
                    System.out.println("==================================");
                    return super.visitMethod(access, name, descriptor, signature, exceptions);
                }
            }, ClassReader.SKIP_CODE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

////structure
interface Visitor{
    void visConcreteElement1(ConcreteElement1 element1);
    void visConcreteElement2(ConcreteElement2 element2);
}

class ConcreteVisitor1 implements Visitor{
    @Override
    public void visConcreteElement1(ConcreteElement1 element1) {
        System.out.print("v1: ");
        element1.op1();
    }

    @Override
    public void visConcreteElement2(ConcreteElement2 element2) {
        System.out.print("v1: ");
        element2.op2();
    }
}

class ConcreteVisitor2 implements Visitor{
    @Override
    public void visConcreteElement1(ConcreteElement1 element1) {
        System.out.print("v2: ");
        element1.op1();
    }

    @Override
    public void visConcreteElement2(ConcreteElement2 element2) {
        System.out.print("v2: ");
        element2.op2();
    }
}


interface Element{
    void accept(Visitor visitor);
}

class ConcreteElement1 implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visConcreteElement1(this);
    }

    void op1(){
        System.out.println("op1");
    }
}

class ConcreteElement2 implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visConcreteElement2(this);
    }

    void op2(){
        System.out.println("op2");
    }
}

class ObjectStructure{

    private List<Element> elementList = new ArrayList<>();

    void visit(Visitor visitor){
        for (Element element : elementList) {
            element.accept(visitor);
        }
    }

    void add(Element element){
        elementList.add(element);
    }

    void remote(Element element){
        elementList.remove(element);
    }
}


////demo
interface VisitorBehave {
    void accept(Zoo zoo);
}

class ChildVisitor implements VisitorBehave {

    int stature;

    public ChildVisitor(int stature) {
        this.stature = stature;
    }

    @Override
    public void accept(Zoo zoo) {
        zoo.printTicket(this);
    }

    int getStature() {
        return stature;
    }
}

class OldVisitor implements VisitorBehave {

    int age;

    public OldVisitor(int age) {
        this.age = age;
    }

    @Override
    public void accept(Zoo zoo) {
        zoo.printTicket(this);
    }

    int getAge() {
        return age;
    }
}

interface Zoo {

    void printTicket(ChildVisitor child);

    void printTicket(OldVisitor visitor);
}

class SeaZoo implements Zoo {

    @Override
    public void printTicket(ChildVisitor child) {
        System.out.println("票价 ￥" + (child.getStature() < 100 ? 0 : 1000));
    }

    @Override
    public void printTicket(OldVisitor older) {
        System.out.println("票价 ￥" + (older.getAge() < 100 ? 0 : 1000));
    }
}


/////////




