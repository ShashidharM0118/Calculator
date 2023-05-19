package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public static boolean isSymbol(char ch){
        if(ch == '+' || ch =='-' || ch == '/' || ch == 'X'){
            return true;
        }
        return false;

    }
    public static String cals(String i1,String i2,char sym){
        int num1 =Integer.parseInt(i1);
        int num2 = Integer.parseInt(i2);
        if(sym =='+'){
            int add = num1+num2;
            return Integer.toString(add);

        }else if (sym =='-'){
            return Integer.toString(num1-num2);
        }else if (sym == '/'){
            return Integer.toString(num1/num2);
        }else if(sym == '*'){
            return Integer.toString(num1*num2);
        }
        return "error";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int sum = 0;
        Button one, two, three, four, five, six, seven, eight, nine, zero, doublezero,equal;
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
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(2);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(3);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(4);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(5);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(6);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(8);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append('0');
            }
        });
        doublezero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb.append(00);
            }
        });
        String copy = sb.toString();
        String copy2 = sb.toString();
        ArrayList<String>  numbers = new ArrayList<>();
        ArrayList<Character>  sym = new ArrayList<>();
        int j =0;
        StringBuilder temp = new StringBuilder();
        for(int i = 0;i <copy.length();i++ ){
            if(!isSymbol(copy.charAt(i))){
                temp.append(copy.charAt(i));
            }
            else if(isSymbol(copy.charAt(i))){

                sym.add(copy.charAt(i));
                numbers.add(temp.toString());
                temp.setLength(0);

            }

        }
        int count =0;
        for(int i =0;numbers.size() != 0 && i< numbers.size()-1;i++){
            numbers.set(i+1,cals(numbers.get(i),numbers.get(i+1),sym.get(count)));
            count++;
        }
            equal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    answer.setText(numbers.get(numbers.size() - 1));
                }
            });











    }
}