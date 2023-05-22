package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    static boolean signNegative = false;
    static int functionUsed =0;
    public static boolean isSymbol(char ch){
        if(ch == '+' || ch =='-' || ch == '/' || ch == 'x' ){
            return true;
        }
        return false;

    }
    public static int jFinder(ArrayList<Character> sym){
       for(int i =0;i<sym.size();i++){
           if(sym.get(i) =='/'){
               return  i;
           }
       }
        for(int i =0;i<sym.size();i++){
            if(sym.get(i) =='x'){
                return  i;
            }
        }
        for(int i =0;i<sym.size();i++){
            if(sym.get(i) =='+'){
                return  i;
            }
        }
        for(int i =0;i<sym.size();i++){
            if(sym.get(i) =='-'){
                return  i;
            }
        }
        return 0;



    }
    public static String cals(String il,String i2,char sym){
        float num1 = Float.parseFloat(il);
        float num2 = Float.parseFloat(i2);
        if(functionUsed == 0 && signNegative == true){

            num1 = num1*(-1);

        }
        if(sym =='+'){
            float add = num1+num2;
            return Float.toString(add);

        }else if (sym =='-'){
            return Float.toString(num1-num2);
        }else if (sym == '/'){
            return Float.toString(num1/num2);
        }else if(sym == 'x'){
            return Float.toString(num1*num2);
        }
        return "error";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int sum = 0;
        Button one, two, three, four, five, six, seven, eight, nine, zero, doublezero,equal;
        Button add,sub,mul,div,clear,dot,perc;
        ImageButton delete ;

        delete = findViewById(R.id.delete);
        perc = findViewById(R.id.perc);
        dot = findViewById(R.id.dot);
        clear = findViewById(R.id.c);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.subtract);
        mul = findViewById(R.id.multiply);
        div  = findViewById(R.id.divide);
        equal = findViewById(R.id.equal);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        TextView answer = findViewById(R.id.answer);
        doublezero = findViewById(R.id.doubleZero);


        StringBuilder sb = new StringBuilder();
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(1);
                answer.setText(sb.toString());
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(2);
                answer.setText(sb.toString());
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(3);
                answer.setText(sb.toString());
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(4);
                answer.setText(sb.toString());
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(5);
                answer.setText(sb.toString());
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(6);
                answer.setText(sb.toString());
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(7);
                answer.setText(sb.toString());
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(8);
                answer.setText(sb.toString());
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append('9');
                answer.setText(sb.toString());
            }
        });
        doublezero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append("0");
                answer.setText(sb.toString());
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append("00");
                answer.setText(sb.toString());
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sb.length() == 0){
                    return;
                }else if(isSymbol(sb.charAt(sb.length()-1))){
                    sb.setCharAt(sb.length()-1,'+');

                }else {
                    sb.append("+");
                }
                answer.setText(sb.toString());
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sb.length() == 0){
                    signNegative = true;
                }else if(isSymbol(sb.charAt(sb.length()-1))){
                    sb.setCharAt(sb.length()-1,'-');
                }else {
                    sb.append("-");
                }
                answer.setText(sb.toString());
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sb.length() == 0) {
                    return;
                } else if (isSymbol(sb.charAt(sb.length() - 1))) {
                    sb.setCharAt(sb.length() - 1, 'x');

                } else {
                    sb.append("x");
                }
                answer.setText(sb.toString());
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sb.length() == 0){
                    signNegative = true;
                }else if(isSymbol(sb.charAt(sb.length()-1))){
                    sb.setCharAt(sb.length()-1,'/');
                }else {
                    sb.append("/");
                }
                answer.setText(sb.toString());
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                    answer.setText(sb.toString());
                }
            }
        });

        perc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append('%');
                answer.setText(sb.toString());
                sb.deleteCharAt(sb.length()-1);
                sb.append("x");
                sb.append("100");


            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.setLength(0);
                answer.setText(sb.toString());

            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sb.charAt(sb.length()-1) != '.'){
                sb.append(".");
                answer.setText(sb.toString());

                }
            }
        });



        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                ArrayList<String> numbers = new ArrayList<>();
                ArrayList<Character> sym = new ArrayList<>();

                StringBuilder temp = new StringBuilder();
                if (signNegative == true){
                    sb.deleteCharAt(0);
                }
                for (int i = 0; i < sb.length(); i++) {

                    if (!isSymbol(sb.charAt(i))) {
                        temp.append(sb.charAt(i));
                    } else if (isSymbol(sb.charAt(i))) {
                        sym.add(sb.charAt(i));
                        numbers.add(temp.toString());
                        temp.setLength(0);
                    }
                    if (i == sb.length() - 1) {
                        numbers.add(temp.toString());
                        temp.setLength(0);
                    }
                }
                int j = jFinder(sym);
                    while(numbers.size() != 1){
                    numbers.set(j+1,cals(numbers.get(j),numbers.get(j+1),sym.get(j)));
                   numbers.remove(j);
                   sym.remove(j);
                    j = jFinder(sym);
                }
                answer.setText(numbers.get(numbers.size()-1));
            }
        });













    }
}