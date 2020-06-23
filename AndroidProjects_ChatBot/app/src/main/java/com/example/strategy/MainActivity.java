package com.example.strategy;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KMLoginHandler;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.applozic.mobicomkit.api.account.register.RegistrationResponse;




public class MainActivity extends AppCompatActivity {
    AppCompatButton  startChatBot;
    public static final String APP_ID = "e708aec27dc26d11d20aaf7eb3909103";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        Kommunicate.init(context, APP_ID);

        startChatBot = findViewById(R.id.btn_start_chat_bot);



    startChatBot.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Se logheaza..");
            progressDialog.setMessage("Asteptata un pic...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            Kommunicate.loginAsVisitor(MainActivity.this, new KMLoginHandler() {
                @Override
                public void onSuccess(RegistrationResponse registrationResponse, Context context) {
                    finish();
                    progressDialog.dismiss();
                    Kommunicate.openConversation(context, null);
                }

                @Override
                public void onFailure(RegistrationResponse registrationResponse, Exception exception) {
                    //progressDialog.dismiss();
                   // createLoginErrorDialog(registrationResponse, exception);
                }
            });
        }
    });
}

}
