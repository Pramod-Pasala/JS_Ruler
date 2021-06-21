package js.ruler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.util.Vector;


public class MainActivity extends AppCompatActivity {
    EditText p_kg,p_cost,m_kg,m_cost;
    TextView[] calculate=new TextView[8];
    TextView[] invisable=new TextView[8];
    static int kg=1000;
    static int cost=0;
    static boolean sync=true;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p_kg = findViewById(R.id.prime_kg);
        p_cost = findViewById(R.id.prime_cost);
        m_kg = findViewById(R.id.m_kg);
        m_cost = findViewById(R.id.m_cost);
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
        Python py = Python.getInstance();
        PyObject pyobj = py.getModule("calculate");
        PyObject pyobj2=py.getModule("startcal");

        calculate = new TextView[]{findViewById(R.id.val_1000), findViewById(R.id.val_500), findViewById(R.id.val_250), findViewById(R.id.val_125), findViewById(R.id.val_100),
                findViewById(R.id.val_50), findViewById(R.id.kg_10), findViewById(R.id.kg_5)};
        invisable = new TextView[]{findViewById(R.id.kg_1000), findViewById(R.id.kg_500), findViewById(R.id.kg_250), findViewById(R.id.kg_125), findViewById(R.id.kg_100),
                findViewById(R.id.kg_50), findViewById(R.id.val_10), findViewById(R.id.val_5)};
        m_kg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!sync) {
                    sync = true;
                    return;
                }
                if (s.length() != 0) {
                    sync = false;

                    PyObject obj = pyobj.callAttr("cal", 1, m_kg.getText().toString(), kg, cost);
                    m_cost.setText(obj.toString());
                } else {
                    sync = false;
                    m_cost.setText("");
                }
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
                if (!sync) {
                    sync = true;
                    return;
                }
                if (s.length() != 0) {
                    sync = false;
                    PyObject obj = pyobj.callAttr("cal", 1, m_cost.getText().toString(), kg, cost);
                    m_kg.setText(obj.toString());
                } else {
                    sync = false;
                    m_kg.setText("");
                }
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
                if (s.length() != 0) {
                    kg = Integer.parseInt(p_kg.getText().toString());
                    PyObject ob=pyobj2.callAttr("cal",kg,cost);
                    int[][] arr=ob.toJava(int[][].class);
                    display(arr[0],arr[1]);

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
                if (s.length() != 0) {
                    cost = Integer.parseInt(p_cost.getText().toString());
                    PyObject ob=pyobj2.callAttr("cal",kg,cost);
                    int[][] arr=ob.toJava(int[][].class);
                    display(arr[0],arr[1]);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
        @SuppressLint("SetTextI18n")
        public void display ( int[] a, int[] b){
            for (int i = 0; i < a.length; i++) calculate[i].setText(a[i] + "rs");
            calculate[6].setText(b[0] + "gm");
            calculate[7].setText(b[1] + "gm");
            for (TextView tv : invisable) {
                tv.setVisibility(View.VISIBLE);
            }


        }



}