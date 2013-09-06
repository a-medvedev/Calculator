package com.suhorukov.commands;


import java.util.HashMap;
import java.util.Stack;

public class Print implements Command{
    public void execute(Stack<Double> stack, HashMap<String, Double> vars, String[] params){
        System.out.println(stack.peek());
    }
}
