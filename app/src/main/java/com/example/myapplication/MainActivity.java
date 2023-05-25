package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Openbracket, Closebracket, equal;

        int[] internal_button_ids = {
                R.id.button_0,
                R.id.button_1,
                R.id.button_2,
                R.id.button_3,
                R.id.button_4,
                R.id.button_5,
                R.id.button_6,
                R.id.button_7,
                R.id.button_8,
                R.id.button_9,
        };
        Button[] num_buttons = new Button[10];

        Button clear, allClear;
        Button add, sub, mul, div;
        Button dot, perc;

        StringBuilder sb = new StringBuilder();
        TextView answer = findViewById(R.id.answer);

        for (int i = 0; i < num_buttons.length; i++)
            num_buttons[i] = (Button) findViewById(internal_button_ids[i]);

        num_buttons[1].setOnClickListener(view -> {
            sb.append(1);
            answer.setText(sb.toString());
        });
        num_buttons[2].setOnClickListener(view -> {
            sb.append(2);
            answer.setText(sb.toString());
        });
        num_buttons[3].setOnClickListener(view -> {
            sb.append(3);
            answer.setText(sb.toString());
        });
        num_buttons[4].setOnClickListener(view -> {
            sb.append(4);
            answer.setText(sb.toString());
        });
        num_buttons[5].setOnClickListener(view -> {
            sb.append(5);
            answer.setText(sb.toString());
        });
        num_buttons[6].setOnClickListener(view -> {
            sb.append(6);
            answer.setText(sb.toString());
        });
        num_buttons[7].setOnClickListener(view -> {
            sb.append(7);
            answer.setText(sb.toString());
        });
        num_buttons[8].setOnClickListener(view -> {
            sb.append(8);
            answer.setText(sb.toString());
        });
        num_buttons[9].setOnClickListener(view -> {
            sb.append('9');
            answer.setText(sb.toString());
        });

        num_buttons[0].setOnClickListener(view -> {
            sb.append("0");
            answer.setText(sb.toString());
        });

        Openbracket = findViewById(R.id.openbracket);
        Closebracket = findViewById(R.id.closeBracket);
        perc = findViewById(R.id.perc);
        dot = findViewById(R.id.dot);
        clear = findViewById(R.id.clear);
        allClear = findViewById(R.id.c);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.subtract);
        mul = findViewById(R.id.multiply);
        div  = findViewById(R.id.divide);
        equal = findViewById(R.id.equal);

        Openbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sb.length() == 0 || sb.length() != 0 && Evaluator.isSymbol(sb.charAt(sb.length()-1))) {
                    sb.append(('('));
                    answer.setText(sb.toString());
                }
            }
        });

        Closebracket.setOnClickListener(view -> {
            if(sb.length()!= 0 && !Evaluator.isSymbol(sb.charAt(sb.length()-1))) {
                sb.append((')'));
                answer.setText(sb.toString());
            }
        });
        add.setOnClickListener(view -> {
            if(sb.length() == 0){
                return;
            }else if(Evaluator.isSymbol(sb.charAt(sb.length()-1))){
                sb.setCharAt(sb.length()-1,'+');

            }else {
                sb.append("+");
            }
            answer.setText(sb.toString());
        });
        sub.setOnClickListener(view -> {
            if(sb.length() == 0){
                sb.append("-");
                Evaluator.signNegative = true;
            }else if(Evaluator.isSymbol(sb.charAt(sb.length()-1))){
                sb.setCharAt(sb.length()-1,'-');
            }else {
                sb.append("-");
            }
            answer.setText(sb.toString());
        });

        mul.setOnClickListener(view -> {
            if (sb.length() == 0) {
                return;
            } else if (Evaluator.isSymbol(sb.charAt(sb.length() - 1))) {
                sb.setCharAt(sb.length() - 1, 'x');

            } else {
                sb.append("x");
            }
            answer.setText(sb.toString());
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sb.length() == 0){
                    Evaluator.signNegative = true;
                }else if(Evaluator.isSymbol(sb.charAt(sb.length()-1))){
                    sb.setCharAt(sb.length()-1,'/');
                }else {
                    sb.append("/");
                }
                answer.setText(sb.toString());
            }
        });

        clear.setOnClickListener(view -> {
            if(sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
                answer.setText(sb.toString());
            }
        });

        perc.setOnClickListener(view -> {
            sb.append('%');
            answer.setText(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            sb.append("x");
            sb.append("100");


        });

        allClear.setOnClickListener(view -> {
            sb.setLength(0);
            answer.setText(sb.toString());

        });
        dot.setOnClickListener(view -> {
            if(sb.charAt(sb.length()-1) != '.'){
                sb.append(".");
                answer.setText(sb.toString());
            }
        });
        equal.setOnClickListener(view -> {
            Evaluator e = new Evaluator(sb);
            answer.setText( e.evaluate());
        });
    }
}