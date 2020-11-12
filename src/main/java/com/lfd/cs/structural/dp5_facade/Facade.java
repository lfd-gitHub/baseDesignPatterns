package com.lfd.cs.structural.dp5_facade;

public class Facade {

    public static void main(String[] args) {
        new Compiler().compiler("a.c","a.o");
    }

}

class Scanner{
    void scan(){
        System.out.println("scan");
    }
}
class ProgramNodeBuilder{

}
class Parser{
    void parse(Scanner scanner,ProgramNodeBuilder builder){
        System.out.println("scanner parse");
    }
}
class RsiCodeGenerator{
    void generator(String output){
        System.out.println("generator to "+ output);
    }
}

class Compiler{

    void compiler(String input,String output){
        Scanner scanner = new Scanner();
        ProgramNodeBuilder builder = new ProgramNodeBuilder();
        Parser parser = new Parser();
        parser.parse(scanner,builder);
        RsiCodeGenerator rsiCodeGenerator = new RsiCodeGenerator();
        rsiCodeGenerator.generator(output);
        //.....
    }

}
