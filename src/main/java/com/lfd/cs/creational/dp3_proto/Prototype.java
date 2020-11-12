package com.lfd.cs.creational.dp3_proto;

public class Prototype {

    public static void main(String[] args) throws CloneNotSupportedException {

        //Object.clone
        System.out.println(new People(100).clone().getAge());

    }

}

class People implements Cloneable{

    public People(int age) {
        this.age = age;
    }

    int age;

    public int getAge() {
        return age;
    }

    @Override
    protected People clone() throws CloneNotSupportedException {
        return (People) super.clone();
    }
}