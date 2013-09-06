package com.suhorukov.commands;


import java.util.HashMap;
import java.util.Stack;

public class Mul implements Command{
    public void execute(Stack<Double> stack, HashMap<String, Double> vars, String[] params){
        stack.push(stack.pop() * stack.pop());
    }
}
