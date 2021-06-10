package js.ruler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    EditText p_kg,p_cost,m_kg,m_cost;
    TextView[] calculate=new TextView[8];
    TextView[] invisable=new TextView[8];
    static int kg=1000;
    static int cost=0;
    boolean flag=true;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p_kg= findViewById(R.id.prime_kg);
        p_cost=findViewById(R.id.prime_cost);
        m_kg=findViewById(R.id.m_kg);
        m_cost=findViewById(R.id.m_cost);

        calculate= new TextView[]{ findViewById(R.id.val_1000),findViewById(R.id.val_500),  findViewById(R.id.val_250),  findViewById(R.id.val_125),  findViewById(R.id.val_100),
                 findViewById(R.id.val_50),  findViewById(R.id.kg_10),  findViewById(R.id.kg_5)};
        invisable= new TextView[]{ findViewById(R.id.kg_1000),findViewById(R.id.kg_500),  findViewById(R.id.kg_250),  findViewById(R.id.kg_125),  findViewById(R.id.kg_100),
                findViewById(R.id.kg_50),  findViewById(R.id.val_10),  findViewById(R.id.val_5)};
        m_kg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(flag){
                flag=false;
                caly();
            }
            else return;
            }

            @Override
            public void afterTextChanged(Editable s) {
                flag=true;
            }
        });
        m_cost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(flag){
                    flag=false;
                    calx();
                }
                else return;
            }


            @Override
            public void afterTextChanged(Editable s) {
                flag=true;
            }
        });
        p_kg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()!=0){
                    kg=Integer.parseInt(p_kg.getText().toString());
                    startcal();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        p_cost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()!=0) {
                    cost = Integer.parseInt(p_cost.getText().toString());
                    startcal();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    public void startcal(){
        int[] ylist={1000,500,250,125,100,50};
        int[] xlist={10,5};
        int[] xval= new int[ylist.length];
        int[] yval= new int[xlist.length];
        try {
            for (int i = 0; i < ylist.length; i++) {
                xval[i] = (int) Math.ceil((ylist[i] * cost) / kg);
            }
            for (int j = 0; j < xlist.length; j++) {
                yval[j] = (int) Math.floor((xlist[j] * kg) / cost);
            }
            display(xval, yval);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressLint("SetTextI18n")
    public void display(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) calculate[i].setText(a[i] + "rs");
        calculate[6].setText(b[0] + "gm");
        calculate[7].setText(b[1] + "gm");
        for (TextView tv : invisable) {
            tv.setVisibility(View.VISIBLE);
        }


    }
    @SuppressLint("SetTextI18n")
    public void calx(){
        int y=Integer.parseInt(m_cost.getText().toString());
        int x=(int)Math.floor((y*kg)/cost);
        m_cost.setText(Integer.toString(x));
    }
    @SuppressLint("SetTextI18n")
    public void caly(){
        int x=Integer.parseInt(m_kg.getText().toString());
        int y=(int)Math.ceil((x*cost)/kg);
        m_cost.setText(Integer.toString(y));
        
    }



}