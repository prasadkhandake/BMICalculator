package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    Button cal;
    EditText wt,ht;
    TextView ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal=findViewById(R.id.button);
        wt=findViewById(R.id.weight);
        ht=findViewById(R.id.height);
        ans=findViewById(R.id.answer);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String s1= String.valueOf(wt.getText());
                String s2= String.valueOf(ht.getText());
                double res=0;
                if (s1.isEmpty() || s2.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter Fields",Toast.LENGTH_LONG).show();
                    wt.setError("Fill all the fields");
                    ht.setError("Fill all the fields");
                }
                else
                {
                    double w=Double.parseDouble(s1);
                    double h=Double.parseDouble(s2);
                    try
                    {
                         res=(w*10000)/(h*h);

                        String temp=String.valueOf(res);
                        ans.setText(temp);
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(), (CharSequence) e,Toast.LENGTH_LONG).show();
                    }
                    if(res<18.5)
                    {
                        Toast.makeText(getApplicationContext(), "! You are underweight",Toast.LENGTH_LONG).show();
                    }
                    else if(res>18.5 || res<24.9)
                    {
                        Toast.makeText(getApplicationContext(), "You are Healthy",Toast.LENGTH_LONG).show();
                    }
                    else if(res>24.9)
                    {
                        Toast.makeText(getApplicationContext(), "! You are Overweight",Toast.LENGTH_LONG).show();
                    }



                }

            }
        });
    }

}
