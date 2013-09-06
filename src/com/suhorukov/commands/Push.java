package com.suhorukov.commands;


import java.util.HashMap;
import java.util.Stack;

public class Push implements Command{
    public void execute(Stack<Double> stack, HashMap<String, Double> vars, String[] params){
        if (vars.containsKey(params[1])){
            stack.push(vars.get(params[1]));
        } else {
            stack.push(Double.valueOf(params[1]));
        }

    }
}
