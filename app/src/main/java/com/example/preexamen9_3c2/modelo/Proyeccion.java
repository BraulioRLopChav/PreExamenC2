package com.example.preexamen9_3c2.modelo;

import android.database.Cursor;

import com.example.preexamen9_3c2.Usuario;

import java.util.List;

public interface Proyeccion {
    public Usuario getUsuario(String correo);
    public List<Usuario> allUsuarios();
    public Usuario readUsuario(Cursor cursor);
}
