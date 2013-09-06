package com.suhorukov.commands;


import java.util.HashMap;
import java.util.Stack;

public class Sqrt implements Command{
    public void execute(Stack<Double> stack, HashMap<String, Double> vars, String[] params){
        stack.push(Math.sqrt(stack.pop()));
    }
}
