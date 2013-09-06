package com.suhorukov.commands;


import java.util.HashMap;
import java.util.Stack;

public class Define implements Command{
    public void execute(Stack<Double> stack, HashMap<String, Double> vars, String[] params){
        vars.put(params[1], Double.valueOf(params[2]));
    }
}
