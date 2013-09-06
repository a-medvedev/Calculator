package com.suhorukov.commands;


import java.util.HashMap;
import java.util.Stack;

public class Pop implements Command{
    public void execute(Stack<Double> stack, HashMap<String, Double> vars, String[] params){
        vars.put(params[1], stack.pop());
    }
}
