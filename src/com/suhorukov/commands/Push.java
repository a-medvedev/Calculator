package com.suhorukov.commands;


import java.util.HashMap;
import java.util.Stack;

public class Push implements Command{
    @Resource(type = "stack")
    Stack<Double> stack;

    @Resource(type = "vars")
    HashMap<String, Double> vars;

    public void execute(String[] params){
        if (vars.containsKey(params[1])){
            stack.push(vars.get(params[1]));
        } else {
            stack.push(Double.valueOf(params[1]));
        }

    }
}
