package com.example.preexamen9_3c2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.preexamen9_3c2.modelo.UsuariosDb;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ListView listViewUsuarios;
    private UsuariosDb usuariosDb;
    private Button btnRegresarLst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listViewUsuarios = findViewById(R.id.listViewUsuarios);
        usuariosDb = new UsuariosDb(this);
        btnRegresarLst = findViewById(R.id.btnRegresarLst);

        List<Usuario> listaUsuarios = usuariosDb.allUsuarios();
        UsuarioAdapter adapter = new UsuarioAdapter(this, listaUsuarios);

        listViewUsuarios.setAdapter(adapter);

        btnRegresarLst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

