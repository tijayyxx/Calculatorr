package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {
    EditText number1, number2;
    Button btn;
    TextView tv;
    Spinner spin;
    String[] oper={"Choose operation","Add","Subtract","Multiply","Divide"};
    String ops;
    double Value1, Value2, Result;
    private OnClickListener myClickListener = new OnClickListener()
    {
        public void onClick(View v) {

            process((Value1=Double.parseDouble(num1.getText().toString())),
                    (Value2=Double.parseDouble(num2.getText().toString())),
                    spin.getSelectedItem();


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView)findViewById(R.id.tv);

        btn1 = (Button)findViewById(R.id.b1);
        btn1.setText("Calculate");
        btn1.setOnClickListener(myClickListener);

        num1 = (EditText)findViewById(R.id.ed1);
        num1.setText("");
        num2 = (EditText)findViewById(R.id.ed2);
        num2.setText("");

        //list of operations
        spin= (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, operation);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ops1=operation[position];
        tv1.setText("You have selected " + ops1);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        tv1.setText("Please select ops");

    }
    void process(int first,int second,String operation){

        if (ops1=="Add"){Result=first+second; tv1.setText(Double.toString(Result));}
        else if (ops1=="Subtract"){Result=first-second; tv1.setText(Double.toString(Result));}
        else if (ops1=="Multiply"){Result=first*second; tv1.setText(Double.toString(Result));}
        else if (ops1=="Divide"){Result=first/second;int reminder=first%second; tv1.setText( "Result"+Double.toString(Result)+ ""+"reminder"+reminder);}
        else {tv1.setText("Please select the operation");}

    }
}