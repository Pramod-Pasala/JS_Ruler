package js.ruler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText p_kg,p_cost;
    TextView m_kg,m_cost;
    int kg=1000;
    boolean flag=false;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p_kg=(EditText)findViewById(R.id.prime_kg);
        p_cost=(EditText)findViewById(R.id.prime_cost);
        m_kg=(TextView) findViewById(R.id.kgs_val);
        m_cost=(TextView) findViewById(R.id.cost_val);
        m_kg.setText(Integer.toString(kg));
        p_kg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                m_kg.setText(p_kg.getText().toString());
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
                m_cost.setText(p_cost.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}