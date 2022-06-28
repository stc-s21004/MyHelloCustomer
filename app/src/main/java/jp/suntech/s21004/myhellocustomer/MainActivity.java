package jp.suntech.s21004.myhellocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyOnClickListener listener = new MyOnClickListener();

        Button btShow = findViewById(R.id.btShow);
        btShow.setOnClickListener(listener);
        Button btClearLocate = findViewById(R.id.btClearLocate);
        btClearLocate.setOnClickListener(listener);
        Button btClearName = findViewById(R.id.btClearName);
        btClearName.setOnClickListener(listener);
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText inputLocate = findViewById(R.id.etLocate);
            EditText inputName = findViewById(R.id.etName);
            TextView output = findViewById(R.id.tvOutput);

            int id = view.getId();
            switch (id) {
                case R.id.btShow:
                    String locate = inputLocate.getText().toString();
                    String name = inputName.getText().toString();
                    if (locate.isEmpty()) {
                        output.setText("住まいが入力されていません。");
                    } else if (name.isEmpty()) {
                        output.setText("お名前が入力されていません。");
                    } else {
                        output.setText(locate + "にお住いの" + name + "さん、こんにちは！");
                    }
                    break;

                case R.id.btClearLocate:
                    inputLocate.setText("");
                    output.setText("");
                    break;

                case R.id.btClearName:
                    inputName.setText("");
                    output.setText("");
                    break;
            }
        }
    }
}