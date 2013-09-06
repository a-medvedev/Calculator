package com.suhorukov.calculator;

import com.suhorukov.commands.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class TestCalculator {
    HashMap<String, Command> cmds = new HashMap<String, Command>();
    Stack<Double> stack;
    HashMap<String, Double> vars = new HashMap<String, Double>();
    Scanner codewalker;

    @Test
    public void FirstRoot(){
        cmds.put("ADD", new Add());
        cmds.put("DEF", new Define());
        cmds.put("DIV", new Div());
        cmds.put("MUL", new Mul());
        cmds.put("POP", new Pop());
        cmds.put("PRN", new Print());
        cmds.put("PSH", new Push());
        cmds.put("SQR", new Sqrt());
        cmds.put("SUB", new Sub());

        stack  = new Stack<Double>();
        StringBuilder code = new StringBuilder();
        code.append("def a 2.0\n");
        code.append("def b 3.0\n");
        code.append("def c 1.0\n");
        code.append("psh 2\n");
        code.append("psh a\n");
        code.append("mul\n");
        code.append("psh 4\n");
        code.append("psh a\n");
        code.append("mul\n");
        code.append("psh c\n");
        code.append("mul\n");
        code.append("psh b\n");
        code.append("psh b\n");
        code.append("mul\n");
        code.append("sub\n");
        code.append("sqr\n");
        code.append("psh b\n");
        code.append("psh 0\n");
        code.append("sub\n");
        code.append("add\n");
        code.append("div\n");

        //используем строку с переносами в качестве источника для сканера
        codewalker = new Scanner(code.toString());
        while (codewalker.hasNext()){
            String cmd = codewalker.nextLine();
            String[] splitCmd = cmd.split(" ");
            cmds.get(splitCmd[0].toUpperCase()).execute(stack, vars, splitCmd);
        }

        assert (stack.peek() == -0.5);
    }

    @Test
    public void SecondRoot(){
        cmds.put("ADD", new Add());
        cmds.put("DEF", new Define());
        cmds.put("DIV", new Div());
        cmds.put("MUL", new Mul());
        cmds.put("POP", new Pop());
        cmds.put("PRN", new Print());
        cmds.put("PSH", new Push());
        cmds.put("SQR", new Sqrt());
        cmds.put("SUB", new Sub());

        stack  = new Stack<Double>();
        StringBuilder code = new StringBuilder();
        code.append("def a 2.0\n");
        code.append("def b 3.0\n");
        code.append("def c 1.0\n");
        code.append("psh 2\n");
        code.append("psh a\n");
        code.append("mul\n");
        code.append("psh 4\n");
        code.append("psh a\n");
        code.append("mul\n");
        code.append("psh c\n");
        code.append("mul\n");
        code.append("psh b\n");
        code.append("psh b\n");
        code.append("mul\n");
        code.append("sub\n");
        code.append("sqr\n");
        code.append("psh b\n");
        code.append("psh 0\n");
        code.append("sub\n");
        code.append("sub\n");
        code.append("div\n");

        codewalker = new Scanner(code.toString());
        while (codewalker.hasNext()){
            String cmd = codewalker.nextLine();
            String[] splitCmd = cmd.split(" ");
            cmds.get(splitCmd[0].toUpperCase()).execute(stack, vars, splitCmd);
        }

        assert (stack.peek() == -1.0);
    }
}
