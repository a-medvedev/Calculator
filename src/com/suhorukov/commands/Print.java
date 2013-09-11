package com.suhorukov.commands;


import java.util.HashMap;
import java.util.Stack;

public class Print implements Command{
    @Resource(type = "stack")
    Stack<Double> stack;

    public void execute(String[] params){
        System.out.println(stack.peek());
    }
}
