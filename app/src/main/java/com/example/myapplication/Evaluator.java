package com.example.myapplication;

import java.util.ArrayList;

public class Evaluator {

    private StringBuilder m_Expression; // The input expression
    public static boolean signNegative = false; // The first sign


    // Main arrays of the numbers and symbols
    ArrayList<String> numbers = new ArrayList<>();
    ArrayList<Character> sym = new ArrayList<>();
    ArrayList<Character> brackets = new ArrayList<>();
    ArrayList<Integer> bracPos = new ArrayList<>();
    StringBuilder temp = new StringBuilder();

    public Evaluator(StringBuilder expression) {
        this.m_Expression = expression;
    }

    public static boolean isSymbol(char ch){
        if(ch == '+' || ch =='-' || ch == '/' || ch == 'x' ){
            return true;
        }
        return false;
    }

    // Function to find the j, where j is the correct order to implement BODMAS
    public int jFinder(ArrayList<Character> sym, int start, int end){
        for(int i =start;i<end;i++){
            if(sym.get(i) =='/'){
                return  i;
            }
        }
        for(int i =start;i<end;i++){
            if(sym.get(i) =='x'){
                return  i;
            }
        }
        for(int i =start;i<end;i++){
            if(sym.get(i) =='+'){
                return  i;
            }
        }
        for(int i =start;i<sym.size();i++){
            if(sym.get(i) =='-'){
                return  i;
            }
        }
        return 0;

    }
    public String cals(String il, String i2, char sym){
        float num1 = Float.parseFloat(il);
        float num2 = Float.parseFloat(i2);

        if(signNegative == true){
            num1 = num1*(-1);

            signNegative = false;
        }
        if(sym =='+'){
            float add = num1 + num2;
            return Float.toString(add);
        }else if (sym =='-'){
            return Float.toString(num1 - num2);
        }else if (sym == '/'){
            return Float.toString(num1 / num2);
        }else if(sym == 'x'){
            return Float.toString(num1 * num2);
        }
        return "error";
    }

    // The main evaluate function that evaluates the given expression
    public String evaluate() {
        if (signNegative){
            m_Expression.deleteCharAt(0);
        }

        for (int i = 0; i < m_Expression.length(); i++) {

            if (!isSymbol(m_Expression.charAt(i)) && (m_Expression.charAt(i) != '(' && m_Expression.charAt(i) != ')')) {
                temp.append(m_Expression.charAt(i));
            }
            else if (isSymbol(m_Expression.charAt(i))) {
                sym.add(m_Expression.charAt(i));
                numbers.add(temp.toString());
                temp.setLength(0);
            }
            else if(m_Expression.charAt(i) == '(' || m_Expression.charAt(i) == ')'){
                brackets.add(m_Expression.charAt(i));
                if (m_Expression.charAt(i) == '(') {
                    bracPos.add(sym.size());
                }else {
                    bracPos.add(-(sym.size()) );
                }
            }
            if (i == m_Expression.length() - 1) { //for the last number
                numbers.add(temp.toString());
                temp.setLength(0);
            }
        }
        if(bracPos.size() != 0) {

            for (int i = bracPos.size()-2 ;  i >= 0 ; i--) {

                int start= bracPos.get(i);
                int end  = (bracPos.get(i + 1) * -1);
                int subtractor =0;
                for(int l = start;l<end;l++) {
                    int j = jFinder(sym,bracPos.get(i),(bracPos.get(i + 1) * -1)-subtractor);
                    numbers.set(j+1,cals(numbers.get(j),numbers.get(j+1),sym.get(j)));
                    numbers.remove(j);
                    sym.remove(j);
                    subtractor++;
                }

//                int k ;
//                for( k = (bracPos.get(i+1)*-1)-1 ;k>=(bracPos.get(i));k--){
//                    numbers.remove(k);
//                    sym.remove(k);
//                }
                bracPos.remove(i+1);
                bracPos.remove(i);
            }
        }

        int j = jFinder(sym,0,sym.size());
        while(numbers.size() != 1){
            numbers.set(j+1,cals(numbers.get(j),numbers.get(j+1),sym.get(j)));
            numbers.remove(j);
            sym.remove(j);
            j = jFinder(sym,0,sym.size());
        }


        return  numbers.get(numbers.size()-1).toString();
    }

}
