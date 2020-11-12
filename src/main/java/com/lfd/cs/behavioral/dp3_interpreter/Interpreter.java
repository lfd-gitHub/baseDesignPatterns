package com.lfd.cs.behavioral.dp3_interpreter;
import java.util.*;

public class Interpreter {

    public static void main(String[] args) {

        int result1 = new Calculator().calc("1+((2+3)*4)-5");
        int result2 = new Calculator().calc("1+2*(3-4)-5*6");
        System.out.println("result->"+result1);
        System.out.println("result->"+result2);
    }

}

class Context{

    Stack<AbstractExpression> expressions = new Stack<>();


}

interface AbstractExpression{
    void interpret(Context context);
}

class TerminalExpression implements AbstractExpression{

    @Override
    public void interpret(Context context) {

    }
}

class NonTerminalExpression implements AbstractExpression{

    AbstractExpression abstractExpression1;
    AbstractExpression abstractExpression2;

    @Override
    public void interpret(Context context) {

    }
}


///
class Calculator{

    static Map<String,Integer> OpLevel = new HashMap<>();

    static{
        OpLevel.put("+",1);
        OpLevel.put("-",1);
        OpLevel.put("*",2);
        OpLevel.put("/",2);
    }

    int calc(String expression){
        Stack<String> rpnStack = toRpn(expression);
        List<String> rpnList = new ArrayList<>(rpnStack);

        Stack<EvalExpression> expStack = new Stack<>();

        for (String value : rpnList) {
            if(isNum(value)){
                expStack.add(new ValExp(value));
            }else{
                EvalExpression right = expStack.pop();
                EvalExpression left = expStack.pop();
                switch (value) {
                    case "+":
                        expStack.push(new AddExp(left,right));
                        break;
                    case "-":
                        expStack.push(new MinusExp(left,right));
                        break;
                    case "*":
                        expStack.push(new TimesExp(left,right));
                        break;
                    case "/":
                        expStack.push(new DivExp(left,right));
                        break;
                }
            }

            System.out.print("[");
            for (EvalExpression evalExpression : expStack) {
                System.out.print(evalExpression.getClass().getSimpleName() + ",");
            }
            System.out.println("]");
        }
        return expStack.pop().interpret(null);
    }

    //ref:https://my.oschina.net/maojindaoGG/blog/1810559
    //ref:https://blog.csdn.net/yuan_xw/article/details/104436091
    Stack<String> toRpn(String expression){
        StringTokenizer st = new StringTokenizer(expression,"()+-*/",true);

        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        while (st.hasMoreElements()) {
            String token = st.nextToken().trim();
            if(token.isEmpty()){
                continue;
            }
            //数字入栈
            if(isNum(token)){
                s1.push(token);
            }else{
                if(s2.isEmpty()){
                    s2.push(token);
                }else if("(".equals(token)){
                    s2.push(token);
                }else if(")".equals(token)){
                    String sOp;
                    while (!(sOp = s2.pop()).equals("(")){
                        s1.push(sOp);
                    }
                }else if("(".equals(s2.lastElement())){
                    s2.push(token);
                }else{
                    int op1Level = OpLevel.get(token);
                    int op2Level = OpLevel.get(s2.lastElement());
                    while (op1Level <= op2Level){
                        s1.push(s2.pop());
                        if(s2.size() > 0){
                            String last2 = s2.lastElement();
                            if(!isNum(last2)){
                                op2Level = OpLevel.get(last2);
                            }else{
                                break;
                            }
                        }else{
                            break;
                        }

                    }
                    s2.push(token);
                }
            }
            System.out.println(token + ": " +s1 + " => " + s2);
        }

        while (s2.size() > 0){
            s1.push(s2.pop());
        }
        return s1;
    }

    static boolean isNum(String str){
        return str.matches("[0-9]+");
    }

}

interface EvalExpression{
    int interpret(Context context);
}

abstract class SymbolExpression implements EvalExpression{

    protected EvalExpression left;
    protected EvalExpression right;

    public SymbolExpression(EvalExpression left, EvalExpression right) {
        this.left = left;
        this.right = right;
    }

}

class ValExp implements EvalExpression {

    String val;

    public ValExp(String val) {
        this.val = val;
    }

    @Override
    public int interpret(Context context) {
        return Integer.parseInt(val);
    }
}

class AddExp extends SymbolExpression{
    public AddExp(EvalExpression left, EvalExpression right) {
        super(left, right);
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}

class MinusExp extends SymbolExpression{
    public MinusExp(EvalExpression left, EvalExpression right) {
        super(left, right);
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }
}

class TimesExp extends SymbolExpression{
    public TimesExp(EvalExpression left, EvalExpression right) {
        super(left, right);
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) * right.interpret(context);
    }
}

class DivExp extends SymbolExpression{
    public DivExp(EvalExpression left, EvalExpression right) {
        super(left, right);
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) / right.interpret(context);
    }
}










