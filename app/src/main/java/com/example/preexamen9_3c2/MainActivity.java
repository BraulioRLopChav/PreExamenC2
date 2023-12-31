package com.example.preexamen9_3c2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.preexamen9_3c2.modelo.UsuariosDb;

public class MainActivity extends AppCompatActivity {

    private EditText txtCorreo, txtContra;
    private Button btnIngresar, btnRegistrarse, btnSalir;;
    private UsuariosDb usuariosDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuariosDb = new UsuariosDb(this);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtContra = findViewById(R.id.txtContra);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnSalir = findViewById(R.id.btnSalir);


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = txtCorreo.getText().toString();
                String contra = txtContra.getText().toString();

                Usuario usuario = usuariosDb.getUsuario(correo);

                if (usuario != null && usuario.getContra().equals(contra)){
                    Toast.makeText(MainActivity.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Datos incorrectos o no está registrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnSalir.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Confirmar salida");
            builder.setMessage("¿Estás seguro de que deseas salir?");
            builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }
}
