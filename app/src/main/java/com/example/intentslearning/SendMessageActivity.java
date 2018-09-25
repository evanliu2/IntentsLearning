package com.example.intentslearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessageActivity extends AppCompatActivity {


    private Button buttonSendMessage;
    private EditText editTextMessage;

    public static final String EXTRA_SENT_MESSAGE = "the message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        wireWidgets();

        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the text from the edittext
                String message = editTextMessage.getText().toString();
                // create an intent
                // the arguments are where are you are coming from
                // and where you are going
                Intent intentSendMessage = new Intent(SendMessageActivity.this, ReceiveMessageActivity.class);
                // package the text into the intent
                intentSendMessage.putExtra(EXTRA_SENT_MESSAGE, message);
                // start the new activity
                startActivity(intentSendMessage);

            }
        });
    }

    private void wireWidgets() {

        buttonSendMessage = findViewById(R.id.button_sendmessage_send);
        editTextMessage = findViewById(R.id.edittext_sendmessage_msg);

    }
}
