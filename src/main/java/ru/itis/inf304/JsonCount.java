package ru.itis.inf304;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonCount {
    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println(jsonCount(args[0]));
        System.out.println(jsonCount("JSON.json"));
    }

    public static int jsonCount(String a) throws NullPointerException, FileNotFoundException, RuntimeException {
        //если пустое имя
        if(a.isEmpty()){
            throw new NullPointerException();
        }

        File json = new File(a);
        //если не существует
        if(!json.exists()) {
            throw new FileNotFoundException();
        }


        try (Reader is = new FileReader(a)) {
            int b;
            StringBuilder sb = new StringBuilder();//строка со скобками

            while ((b = is.read()) != -1) {

                if (b == (byte) '{' | b == (byte) '}') {
                    sb.append((char) b);
                }
                //если не текстовый
                if (Pattern.matches("\\w", String.valueOf(b))){
                    throw new RuntimeException();
                }

            }
            return isBalanced(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


        return 0;
    }

    public static int isBalanced(String str) {

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '{') { //открвающую - положить в стэк
                stack.push(c);

            }
            if (c == '}') { //закрываующую - не трогаем(если стек не пуст - удаляем)
                if (stack.isEmpty()) {//при пустом стеке - вывод
                    return i+1;
                } else {
                    stack.pop();
                }

            }
        }
        if(!stack.isEmpty()){
            return str.length()+1;
        }
        return 0;
    }
}



