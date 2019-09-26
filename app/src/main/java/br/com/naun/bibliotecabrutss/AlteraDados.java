package br.com.naun.bibliotecabrutss;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AlteraDados extends AppCompatActivity {
    EditText livro;
    EditText autor;
    EditText editora;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_dados);
        codigo = this.getIntent().getStringExtra("codigo");
        crud = new BancoController(getBaseContext());
        livro = (EditText)findViewById(R.id.txtTitulo);
        autor = (EditText)findViewById(R.id.txtAutor);
        editora = (EditText)findViewById(R.id.txtEditora);
        alterar = (Button)findViewById(R.id.btnAlterar);
        deletar = (Button)findViewById(R.id.btnDeletar);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        livro.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getTITULO())));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getAUTOR())));

        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getEDITORA())));
        alterar.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo),
                        livro.getText().toString(),autor.getText().toString(),
                        editora.getText().toString());
                Intent intent = new Intent(AlteraDados.this,ConsultaDados.class);
                startActivity(intent);
                finish();
            }
        });
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(AlteraDados.this,ConsultaDados.class);
                startActivity(intent);
                finish();
            }
        });

    }





}
