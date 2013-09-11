package com.suhorukov.commands;


import java.util.HashMap;
import java.util.Stack;

public class Add implements Command{
    @Resource(type = "stack")
    Stack<Double> stack;

    public void execute(String[] params){
        stack.push(stack.pop() + stack.pop());
    }
}
