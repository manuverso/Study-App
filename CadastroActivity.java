package com.example.mystudy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    EditText editDisciplina;
    EditText editHorario;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editDisciplina = findViewById(R.id.editDisciplina);
        editHorario = findViewById(R.id.editHorario);
        btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String disciplina = editDisciplina.getText().toString().trim();
                String horario = editHorario.getText().toString().trim();

                if (disciplina.isEmpty() || horario.isEmpty()) {

                    Toast.makeText(CadastroActivity.this,
                            "Preencha todos os campos",
                            Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(CadastroActivity.this,
                            "Atividade cadastrada com sucesso!",
                            Toast.LENGTH_LONG).show();

                    // Limpa os campos
                    editDisciplina.setText("");
                    editHorario.setText("");

                    // Volta para a tela inicial após 2 segundos
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }, 2000);
                }
            }
        });
    }
}


