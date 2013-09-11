package com.suhorukov.commands;


import java.util.HashMap;
import java.util.Stack;

public class Pop implements Command{
    @Resource(type = "vars")
    HashMap vars;
    @Resource(type = "stack")
    Stack<Double> stack;
    public void execute(String[] params){
        vars.put(params[1], stack.pop());
    }
}
