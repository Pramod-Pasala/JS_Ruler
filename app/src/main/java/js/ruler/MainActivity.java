package js.ruler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText p_kg,p_cost;
    TextView m_kg,m_cost;
    int kg=1000;
    boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p_kg=(EditText)findViewById(R.id.prime_kg);
        p_cost=(EditText)findViewById(R.id.prime_cost);
        m_kg=(TextView) findViewById(R.id.kgs_val);
        m_cost=(TextView) findViewById(R.id.cost_val);
        p_kg.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                kg=Integer.parseInt(p_kg.getText().toString());
                flag=true;
                m_kg.setText(kg);
                return true;
            }
        });
        if (flag==false){
            m_kg.setText(kg);
            }

        p_cost.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                int cost=Integer.parseInt(p_cost.getText().toString());
                m_cost.setText(cost);
                return true;

            }
        });
    }
}