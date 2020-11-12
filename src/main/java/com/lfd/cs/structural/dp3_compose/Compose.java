package com.lfd.cs.structural.dp3_compose;

import java.util.ArrayList;
import java.util.List;

public class Compose {
    public static void main(String[] args) {

        ///Node -> leaf + Branches( Notes ) 树状结构
        Component root = new Composite();
        root.add(new Leaf());

        Component c = new Composite();
        c.add(new Leaf());
        root.add(c);

        root.operation("-");

    }
}

interface Component{

    void operation(String pad);
    void add(Component c);
    void remote(Component c);
    Component getChild(int n);

}

class Leaf implements Component{

    @Override
    public void operation(String pad) {
        System.out.println(pad + "leaf operation");
    }

    @Override
    public void add(Component c) {

    }

    @Override
    public void remote(Component c) {

    }

    @Override
    public Component getChild(int n) {
        return null;
    }
}

class Composite implements Component{

    private List<Component> children = new ArrayList<>();


    @Override
    public void operation(String pad) {
        System.out.println(pad + "composite operation");
        for (Component child : children) {
            child.operation(pad + pad.charAt(0));
        }
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remote(Component c) {
        children.remove(c);
    }

    @Override
    public Component getChild(int n) {
        return children.get(n);
    }
}