package com.example.mycs.alertdialoglogin;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void btnClicked (View view) {
        LayoutInflater inflater = getLayoutInflater();
        @SuppressLint("InflateParams") View alertLayout = inflater.inflate(R.layout.login_dialog, null);
        final EditText etUsername = alertLayout.findViewById(R.id.textUsername);
        final EditText etPassword = alertLayout.findViewById(R.id.textPassword);
        final CheckBox cbToggle = alertLayout.findViewById(R.id.cb_show_pass);

        cbToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    etPassword.setTransformationMethod(null);
                }
            }
        });

        AlertDialog.Builder login = new AlertDialog.Builder(this);
        login.setTitle("Login");
        login.setView(alertLayout);
        login.setCancelable(false);
        login.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getBaseContext(), "Cancel clicked.", Toast.LENGTH_SHORT).show();
            }
        });
        login.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String user = etUsername.getText().toString();
                String pass = etPassword.getText().toString();
                Toast.makeText(getBaseContext(), "User: " + user + " Password: " + pass + " Logged in.", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog = login.create();
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}