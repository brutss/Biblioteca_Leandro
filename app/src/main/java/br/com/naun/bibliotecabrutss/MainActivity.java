package br.com.naun.bibliotecabrutss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Button btnEntrar = (Button) findViewById(R.id.btnEntrar);
            final EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
            final TextView txtSenha = (TextView) findViewById(R.id.txtSenha);


            btnEntrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = txtEmail.getText().toString();
                    String senha = txtSenha.getText().toString();

                    if(email.equalsIgnoreCase("admin") &&
                            senha.equalsIgnoreCase("5421")){
                        startActivity(new Intent(MainActivity.this, AlteraDados.class));
                    }}

            });


        }
        private void alert(String s){
            Toast.makeText(this,s,Toast.LENGTH_LONG).show();


        }

    }



