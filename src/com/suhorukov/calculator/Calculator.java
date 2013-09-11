package com.suhorukov.calculator;

import com.suhorukov.commands.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Stack;
import java.util.Scanner;
import java.util.HashMap;

public class Calculator {
    private static Scanner input;

    public static void main(String[] args){
        HashMap<String, Command> cmds = new HashMap<String, Command>();
//        cmds.put("ADD", new Add());
//        cmds.put("DEF", new Define());
//        cmds.put("DIV", new Div());
//        cmds.put("MUL", new Mul());
//        cmds.put("POP", new Pop());
//        cmds.put("PRN", new Print());
//        cmds.put("PSH", new Push());
//        cmds.put("SQR", new Sqrt());
//        cmds.put("SUB", new Sub());

        FileReader fReader = null;
        try {
            fReader = new FileReader("./src/com/suhorukov/calculator/comm.prop");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
        }

        Properties prop = new Properties();
        try {
            prop.load(fReader);
        } catch (IOException e) {
            System.out.println("Cannot load property file.");
            System.exit(2);
        }



        boolean isInteractive = false;//флаг для интерактивной подсказки
        if (args.length > 0){
            try {
                input = new Scanner(new FileInputStream(args[0]));
                System.out.println("Обрабатывается файл " + args[0]);
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден.");
                System.exit(1);
            }
        } else {
            isInteractive = true;
            input = new Scanner(System.in);
            System.out.println("Введите команды, завершая каждую нажатием <Enter>.\nВведите пустую строку для завершения работы.");
            System.out.print(">>> ");
        }

        Stack<Double> stack = new Stack<Double>();
        HashMap<String, Double> vars = new HashMap<String, Double>();
        while (input.hasNextLine()){
            //приглашение, если вводим команды с клавиатуры
            if (isInteractive){
                System.out.print(">>> ");
            }

            String cmd = input.nextLine();
            String[] splitCmd = cmd.split(" ");
            //Если в строке содержится комментарий
            if (splitCmd[0].startsWith("#")){
                continue;
            }
            try {
                cmds.get(splitCmd[0].toUpperCase()).execute(splitCmd);
            } catch (NullPointerException e){
                System.out.println("Программа завершена");
                System.exit(0);
            }
        }
        System.out.println("Программа завершена");
    }
}
