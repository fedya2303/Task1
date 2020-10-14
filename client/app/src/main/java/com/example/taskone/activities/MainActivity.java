package com.example.taskone.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taskone.viewmodel.MyViewModel;
import com.example.taskone.R;

public class MainActivity extends AppCompatActivity {

    private MyViewModel viewModel = new MyViewModel();;
    EditText hostEditText;
    Button sendReqButton;
    EditText portEditText;
    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendReqButton = findViewById(R.id.btn_req);
        hostEditText = findViewById(R.id.host_edit_text);
        portEditText = findViewById(R.id.port_edit_text);
        responseText = findViewById(R.id.grpc_response_text);

        sendReqButton.setOnClickListener(view -> {
            viewModel.sendRequest(hostEditText.getText().toString(), portEditText.getText().toString());
        });

        viewModel.getNumber().observe(this,
                number -> responseText.setText(number.toString()));
    }
}