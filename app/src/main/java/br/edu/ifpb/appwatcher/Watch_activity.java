package br.edu.ifpb.appwatcher;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class Watch_activity extends Activity {

    private EditText passwordEditText;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

        /* Initializing views */
        passwordEditText = (EditText) findViewById(R.id.pesquisa);
        textView = (TextView) findViewById(R.id.passwordHint);
        textView.setVisibility(View.GONE);

        /* Set Text Watcher listener */
        passwordEditText.addTextChangedListener(passwordWatcher);
    }

    private final TextWatcher passwordWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textView.setVisibility(View.VISIBLE);
        }

        public void afterTextChanged(Editable s) {
            if (s.length() == 0) {
                textView.setVisibility(View.GONE);
            } else{
                textView.setText("You have entered : " + passwordEditText.getText());
            }
        }
    };
}
