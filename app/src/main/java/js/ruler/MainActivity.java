package js.ruler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText p_kg,p_cost,m_kg,m_cost;
    TextView kg_tho,kg_fiv,kg_pav,kg_adp,kg_ren,kg_cha,cost_ten,cost_five;

    int kg=1000;
    int cost=0;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p_kg=(EditText)findViewById(R.id.prime_kg);
        p_cost=(EditText)findViewById(R.id.prime_cost);
        m_kg=(EditText) findViewById(R.id.kgs_val);
        m_cost=(EditText) findViewById(R.id.cost_val);
        kg_tho=(TextView)findViewById(R.id.val_1000);
        kg_fiv=(TextView)findViewById(R.id.val_500);
        kg_pav=(TextView)findViewById(R.id.val_250);
        kg_adp=(TextView)findViewById(R.id.val_125);
        kg_ren=(TextView)findViewById(R.id.val_100);
        kg_cha=(TextView)findViewById(R.id.val_50);
        cost_ten=(TextView)findViewById(R.id.kg_10);
        cost_five=(TextView)findViewById(R.id.kg_5);
        m_kg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                m_cost.setText(Integer.toString((int)Math.ceil(Integer.parseInt(m_kg.getText().toString())*cost)/kg));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        m_cost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                m_kg.setText(Integer.toString((int)Math.floor(Integer.parseInt(m_cost.getText().toString())*kg)/cost));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        p_kg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                kg=Integer.parseInt(p_kg.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                startcal();

            }
        });
        p_cost.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cost=Integer.parseInt(p_cost.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!TextUtils.isEmpty(p_cost.getText().toString()))
                {
                    startcal();
                }


            }
        });

    }
    public void startcal(){
        int[] ylist={1000,500,250,125,100,50};
        int[] xlist={10,5};
        int[] xval= new int[ylist.length];
        int[] yval= new int[xlist.length];
        for(int i=0;i< ylist.length;i++) {
            xval[i] = (int)Math.ceil((ylist[i] * cost) / kg);
        }
        for(int j=0;j<xlist.length;j++) {
            yval[j] =(int)Math.floor((xlist[j] * kg) / cost);
        }
        display(xval,yval);

    }
    public void display(int[] a, int[] b){
        kg_tho.setText(Integer.toString(a[0]));
        kg_fiv.setText(Integer.toString(a[1]));
        kg_pav.setText(Integer.toString(a[2]));
        kg_adp.setText(Integer.toString(a[3]));
        kg_ren.setText(Integer.toString(a[4]));
        kg_cha.setText(Integer.toString(a[5]));
        cost_ten.setText(Integer.toString(b[0]));
        cost_five.setText(Integer.toString(b[1]));



    }
}