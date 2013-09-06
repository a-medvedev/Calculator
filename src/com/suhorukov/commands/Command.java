package com.suhorukov.commands;

import java.util.HashMap;
import java.util.Stack;

public interface Command {
    public void execute(Stack<Double> stack, HashMap<String, Double> vars, String[] params);
}
